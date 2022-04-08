package pl.jenkins.service;

import pl.jenkins.library.JsonMap;

public interface RequestService {
    //tdd - JobListServiceTest - mock requestService.getJson() in findJobByJiraTicket(), jobListEmpty()

    JsonMap getJson(String jobsUrl);
}
