package io.github.ashayking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 
 * @author Ashay S Patil
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableResourceServer
@EnableOAuth2Client
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
