package pl.jenkins.service;

import java.util.Optional;
import pl.jenkins.library.JsonMap;
import pl.jenkins.model.Job;

public class JobService {

    private final String jobsUrl;
    private final RequestService requestService;

    public JobService(String jobsUrl, RequestService requestService) {
        this.jobsUrl = jobsUrl;
        this.requestService = requestService;
    }

    public Optional<Job> getJob(String jobNumber) {
        try {
            JsonMap jsonMap = requestService.getJson(jobsUrl + "/" + jobNumber);
            return Optional.of(new Job(jsonMap));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
