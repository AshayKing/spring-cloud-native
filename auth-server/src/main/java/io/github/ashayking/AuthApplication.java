package io.github.ashayking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @author Ashay S Patil
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@SessionAttributes("authorizationRequest")
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
}
