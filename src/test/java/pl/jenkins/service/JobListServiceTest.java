package pl.jenkins.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jenkins.model.JobStatus;

class JobListServiceTest {

    private JobListService jobListService;

    @BeforeEach
    void init() {
        jobListService = new JobListService();
    }

    @Test
    void findJobByJiraTicket() {
        // given
        // when
        JobStatus actualJobStatus = jobListService.getStatusByTicketNumber("ABC-123");

        // then
        assertThat(actualJobStatus).isEqualTo(JobStatus.RUNNING);
    }

    @Test
    void jobListEmpty() {
        // given
        // when
        JobStatus actualJobStatus = jobListService.getStatusByTicketNumber("ABC-123");

        // then
        assertThat(actualJobStatus).isEqualTo(JobStatus.NOT_FOUND);
    }
}