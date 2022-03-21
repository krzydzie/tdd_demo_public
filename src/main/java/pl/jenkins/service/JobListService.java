package pl.jenkins.service;

import pl.jenkins.model.JobStatus;

public class JobListService {

    public JobStatus getStatusByTicketNumber(String ticketNumber) {
        return JobStatus.PENDING;
    }
}
