package pl.jenkins.service;

import pl.jenkins.model.JobStatus;

public class JobListService {
    //tdd - here - implement in getStatusByTicketNumber() not found part

    public JobStatus getStatusByTicketNumber(String ticketNumber) {
        return JobStatus.PENDING;
    }
}
