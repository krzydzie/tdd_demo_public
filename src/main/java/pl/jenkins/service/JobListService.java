package pl.jenkins.service;

import java.util.List;
import pl.jenkins.library.JsonMap;
import pl.jenkins.model.JobNumbers;
import pl.jenkins.model.JobStatus;

public class JobListService {
    //tdd - add RequestService - missing class

    public JobStatus getStatusByTicketNumber(String ticketNumber) {
        JsonMap json = requestService.getJson(jobsUrl);

        List<String> numbers = new JobNumbers(json).getNumbers();

        if (numbers.isEmpty()) {
            return JobStatus.NOT_FOUND;
        }

        return JobStatus.PENDING;
    }
}
