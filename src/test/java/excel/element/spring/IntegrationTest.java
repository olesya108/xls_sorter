package excel.element.spring;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private static String path;

    @BeforeAll
    public static void init() {
        path = new File("src/test/resources/xls/example.xlsx").getAbsolutePath();
    }

    @Test
    public void testNElement() {
        assertEquals(6, restTemplate.getForObject("http://localhost:" + port + "/excel/element?n=1&path=" + path, Integer.class));
    }

    //todo implement more tests

}
