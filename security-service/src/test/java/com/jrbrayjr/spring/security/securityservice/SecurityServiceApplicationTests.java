package com.jrbrayjr.spring.security.securityservice;

import com.jrbrayjr.spring.security.securityservice.config.SampleSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration( classes = SampleSecurityConfig.class )
@SpringBootTest
class SecurityServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
