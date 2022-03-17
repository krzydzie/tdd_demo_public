package pl.jenkins.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jenkins.model.Job;
import pl.jenkins.model.JobStatus;

public class JobServiceTest {

    private JobService jobService;

    @BeforeEach
    void init() {
        jobService = new JobService();
    }

    @Test
    void jobFound() {
        // given
        // when
        Optional<Job> optionalJob = jobService.getJob("10");

        // then
        Job job = optionalJob.get();
        assertThat(job.getDescription()).contains("XYZ-123");
        assertThat(job.getStatus()).isEqualTo(JobStatus.SUCCEEDED);
    }

    @Test
    void jobNotFound() {
        // when
        Optional<Job> optionalJob = jobService.getJob("10");

        // then
        assertThat(optionalJob).isNotPresent();
    }
}
