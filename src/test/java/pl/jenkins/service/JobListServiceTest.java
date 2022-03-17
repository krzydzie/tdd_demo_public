package pl.jenkins.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.jenkins.model.JobStatus;

@ExtendWith(MockitoExtension.class)
class JobListServiceTest {
    private static final String DUMMY_URL = "https://jenkins.acme.com/SuperService/job/super-sevice-CI/";
    private JobListService jobListService;

    @Mock
    private RequestService requestService;

    @BeforeEach
    void init() {
        jobListService = new JobListService(DUMMY_URL, requestService);
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