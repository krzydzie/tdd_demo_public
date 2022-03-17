package pl.jenkins.library;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class JsonTest {

    @Test
    void jsonBundle() {
        // given
        JsonMap jsonMap = JsonMap.create();

        // when
        jsonMap.addAttribute("description", "some description");
        JsonList builds = jsonMap.addList("builds");
        builds.addItem("build", "45");
        builds.addItem("build", "46");
        JsonMap parametersMap = jsonMap.addMap("parameters");
        parametersMap.addAttribute("jira-ticket", "XYZ-123");

        // then
        assertThat(jsonMap.getAttribute("description")).isEqualTo("some description");
        assertThat(jsonMap.findAttribute("unknown")).isEqualTo(Optional.empty());
        assertThat(jsonMap.getList("builds").getList()).hasSize(2);
        JsonMap builds0 = jsonMap.getList("builds").getList().get(0).asJsonMap();
        assertThat(builds0.getAttribute("build")).isEqualTo("45");
        assertThat(jsonMap.getMap("parameters").getAttribute("jira-ticket")).isEqualTo("XYZ-123");
    }
}