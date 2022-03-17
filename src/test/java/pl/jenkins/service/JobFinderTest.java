package pl.jenkins.service;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jenkins.model.Job;
import pl.jenkins.model.JobStatus;

class JobFinderTest {
    private JobFinder jobFinder;

    @BeforeEach
    void init() {
        jobFinder = new JobFinder();
    }

    @Test
    void findByDescriptionWhenJobFound() {
        // given
        // when
        Optional<Job> optionalJob = jobFinder.findByDescription(asList("10", "20"), "XYZ-123");

        // then
        Job job = optionalJob.get();
        assertThat(job.getStatus()).isEqualTo(JobStatus.RUNNING);
        assertThat(job.getDescription()).contains("XYZ-123");
    }

    @Test
    void findByDescriptionWhenJobNotFound() {
        // given
        // when
        Optional<Job> optionalJob = jobFinder.findByDescription(asList("10", "20"), "XYZ-123");

        // then
        assertThat(optionalJob).isNotPresent();
    }

    @Test
    void foundInHtml() {
        // when
        Optional<Job> optionalJob = jobFinder.findInHtml(
                "<a tooltip=\"Build Parameters:&lt;br&gt;BRANCH=XYZ-123-some-desc&lt;br&gt\" href=\"#\">", "XYZ-123");

        // then
        assertThat(optionalJob).isPresent();
        Job job = optionalJob.get();
        assertThat(job.getStatus()).isEqualTo(JobStatus.PENDING);
        assertThat(job.getDescription()).contains("XYZ-123");
    }

    @Test
    void notFoundInHtml() {
        // when
        Optional<Job> optionalJob = jobFinder.findInHtml(
                "<a tooltip=\"Build Parameters:&lt;br&gt;BRANCH=XYZ-124-some-desc&lt;br&gt\" href=\"#\"><a tooltip=\"Build Parameters:&lt;br&gt;BRANCH=XYZ-125-some-desc&lt;br&gt\" href=\"#\">",
                "XYZ-123");
        // then
        assertThat(optionalJob).isEmpty();
    }
}