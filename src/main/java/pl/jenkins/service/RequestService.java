package pl.jenkins.service;

import pl.jenkins.library.JsonMap;

/**
 * I do not implement the class and tests as it is not very fascinating for our purposes.
 */
public interface RequestService {

    JsonMap getJson(String url);
}
