package pl.jenkins.service;

import pl.jenkins.library.JsonMap;

public interface RequestService {

    JsonMap getJson(String jobsUrl);

    String getText(String jobsUrl);
}
