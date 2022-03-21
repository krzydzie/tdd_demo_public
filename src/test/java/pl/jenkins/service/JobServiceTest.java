package pl.jenkins.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.jenkins.library.JsonMap;
import pl.jenkins.model.Job;
import pl.jenkins.model.JobStatus;

@ExtendWith(MockitoExtension.class)
public class JobServiceTest {

    private static final String DUMMY_URL = "https://jenkins.acme.com/SuperService/job/super-sevice-CI/";
    private JobService jobService;
    @Mock
    private RequestService requestService;


    @BeforeEach
    void init() {
        jobService = new JobService(DUMMY_URL, requestService);
    }

    @Test
    void jobFound() {
        // given
        given(requestService.getJson(DUMMY_URL + "/10")).willReturn(fixtureJob("XYZ-123", "SUCCESS"));

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

    private JsonMap fixtureJob(String ticket, String result) {
        JsonMap jsonMap = JsonMap.create();
        JsonMap parameters = jsonMap.addMap("parameters");
        parameters.addAttribute("branch", ticket);
        jsonMap.addAttribute("result", result);

        return jsonMap;
    }
}
