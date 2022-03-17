package pl.jenkins.model;

public enum JobStatus {
    //skip STOPPED by now
    RUNNING(null), PENDING("_HTML_"), FAILED("FAILURE"), SUCCEEDED("SUCCESS"), NOT_FOUND("_NOT_FOUND_");

    private final String result;

    JobStatus(String result) {
        this.result = result;
    }

    public static JobStatus fromJenkins(String result) {
        if (result == null) {
            return JobStatus.RUNNING;
        }

        for (JobStatus status : JobStatus.values()) {
            if (result.equals(status.result)) {
                return status;
            }
        }

        throw new IllegalArgumentException("Unknown result " + result);
    }

    String getResult() {
        return result;
    }
}
