package pl.jenkins.model;

import pl.jenkins.library.JsonMap;

public class Job {

    private final JobStatus status;
    private final String description;

    public Job(JsonMap json) {
        description = json.getMap("parameters").getAttribute("branch");
        status = JobStatus.fromJenkins(json.getAttribute("result"));
    }

    public Job(JobStatus status, String description) {
        this.status = status;
        this.description = description;
    }

    public JobStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
