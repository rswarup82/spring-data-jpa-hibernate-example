package org.springframework.data.jpa.example.repository;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(locations = {
        "classpath:/META-INF/spring/test-infrastructure-data.xml"
})
@ActiveProfiles("dev")
public abstract class BaseIntegrationTest {

}
