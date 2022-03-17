package pl.jenkins.service;

import java.util.List;
import java.util.Optional;
import pl.jenkins.model.Job;

public class JobFinder {

    private final JobService jobService;

    public JobFinder(JobService jobService) {
        this.jobService = jobService;
    }

    public Optional<Job> findByDescription(List<String> numbers, String ticketNumber) {
        for (String number : numbers) {
            Optional<Job> job = checkJob(number, ticketNumber);

            if (job.isPresent()) {
                return job;
            }
        }

        return Optional.empty();

    }

    public Optional<Job> findInHtml(String html, String ticketNumber) {
        return null;
    }

    private Optional<Job> checkJob(String number, String ticketNumber) {
        Optional<Job> job = jobService.getJob(number);

        if (job.isEmpty()) {
            return Optional.empty();
        }

        String description = job.get().getDescription();

        if (description != null && description.contains(ticketNumber)) {
            return job;
        } else {
            return Optional.empty();
        }
    }


}
