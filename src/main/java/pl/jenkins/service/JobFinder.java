package pl.jenkins.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pl.jenkins.model.Job;
import pl.jenkins.model.JobStatus;

public class JobFinder {

    private static final Pattern pattern = Pattern.compile(" tooltip=\"([^\"]+)\"");
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
        if (html == null || ticketNumber == null) {
            return Optional.empty();
        }

        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            if (matcher.group(1).contains(ticketNumber)) {
                return Optional.of(new Job(JobStatus.PENDING, ticketNumber));
            }
        }

        return Optional.empty();
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
