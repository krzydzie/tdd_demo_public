package pl.jenkins.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class JobStatusTest {

    @ParameterizedTest
    @EnumSource(JobStatus.class)
    void mapping(JobStatus jobStatus) {
        assertThat(JobStatus.fromJenkins(jobStatus.getResult())).isEqualTo(jobStatus);
    }

    @Test
    void wrongMapping() {
        assertThatThrownBy(() -> JobStatus.fromJenkins("xyz")).isInstanceOf(IllegalArgumentException.class);
    }
}