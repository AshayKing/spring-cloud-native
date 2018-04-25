package io.github.ashayking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * 
 * @author Ashay S Patil
 *
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinTracingApplication.class, args);
	}
}
