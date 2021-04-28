package app.zoftwhere.alacrity.server.index;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class IndexControllerTest {

    @LocalServerPort
    private int serverPort;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    private IndexController controller;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    private TestRestTemplate restTemplate;

    @Test
    void testWiring() {
        final String localhost = "http://localhost:" + serverPort;
        assertThat(controller).isNotNull();
        assertThat(restTemplate.getForObject(localhost + "/", String.class)).isNotNull();
    }

}
