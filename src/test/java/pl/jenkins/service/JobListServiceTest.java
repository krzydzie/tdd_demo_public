package pl.jenkins.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.jenkins.library.JsonList;
import pl.jenkins.library.JsonMap;
import pl.jenkins.model.Job;
import pl.jenkins.model.JobStatus;

@ExtendWith(MockitoExtension.class)
class JobListServiceTest {
    private static final String DUMMY_URL = "https://jenkins.acme.com/SuperService/job/super-sevice-CI/";
    private JobListService jobListService;

    @Mock
    private RequestService requestService;

    @Mock
    private JobFinder jobFinder;

    @BeforeEach
    void init() {
        jobListService = new JobListService(DUMMY_URL, requestService, jobFinder);
    }

    @Test
    void findJobByJiraTicket() {
        // given
        given(requestService.getJson(DUMMY_URL)).willReturn(fixtureBuildsNumbers("548", "549"));
        given(jobFinder.findByDescription(anyList(), anyString())).willReturn(Optional.of(new Job(JobStatus.RUNNING,
                "description")));

        // when
        JobStatus actualJobStatus = jobListService.getStatusByTicketNumber("ABC-123");

        // then
        assertThat(actualJobStatus).isEqualTo(JobStatus.RUNNING);
    }

    @Test
    void jobListEmpty() {
        // given
        given(requestService.getJson(DUMMY_URL)).willReturn(fixtureBuildsEmptyList());
        //lenient() guardian added, it should not be called. But if starts we will be alarmed as the test starts failing
        lenient().when(jobFinder.findByDescription(anyList(), anyString()))
                .thenReturn(Optional.of(new Job(JobStatus.RUNNING, "description")));

        // when
        JobStatus actualJobStatus = jobListService.getStatusByTicketNumber("ABC-123");

        // then
        assertThat(actualJobStatus).isEqualTo(JobStatus.NOT_FOUND);
    }

    @Test
    void jobPendingInHtmlFound() {
        Assertions.fail("Not implemented yet");
        // given
        // when
        // then
    }

    @Test
    void jobPendingInHtmlNotFound() {
        Assertions.fail("Not implemented yet");
        // given
        // when
        // then
    }

    private JsonMap fixtureBuildsEmptyList() {
        return fixtureBuildsNumbers();
    }

    private JsonMap fixtureBuildsNumbers(String... numbers) {
        JsonMap json = JsonMap.create();
        JsonList builds = json.addList("builds");

        for (String number : numbers) {
            builds.addItem("number", number);
        }

        return json;
    }
}