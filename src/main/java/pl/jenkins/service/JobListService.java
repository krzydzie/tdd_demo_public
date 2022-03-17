package pl.jenkins.service;

import java.util.List;
import java.util.Optional;
import pl.jenkins.library.JsonMap;
import pl.jenkins.model.Job;
import pl.jenkins.model.JobNumbers;
import pl.jenkins.model.JobStatus;

public class JobListService {

    private final String jobsUrl;
    private final RequestService requestService;
    private final JobFinder jobFinder;

    public JobListService(String jobsUrl, RequestService requestService, JobFinder jobFinder) {
        this.jobsUrl = jobsUrl;
        this.requestService = requestService;
        this.jobFinder = jobFinder;
    }

    public JobStatus getStatusByTicketNumber(String ticketNumber) {
        JsonMap json = requestService.getJson(jobsUrl);

        List<String> numbers = new JobNumbers(json).getNumbers();

        if (numbers.isEmpty()) {
            return JobStatus.NOT_FOUND;
        }

        Optional<Job> job = jobFinder.findByDescription(numbers, ticketNumber);

        if (job.isEmpty()) {
            return JobStatus.NOT_FOUND;
        }

        return job.get().getStatus();
    }

}
