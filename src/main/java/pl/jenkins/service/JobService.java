package pl.jenkins.service;

import java.util.Optional;
import pl.jenkins.library.JsonMap;
import pl.jenkins.model.Job;

public class JobService {

    public Optional<Job> getJob(String jobNumber) {
        try {
            JsonMap jsonMap = requestService.getJson(jobsUrl + "/" + jobNumber);
            return Optional.of(new Job(jsonMap));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
