package io.github.ashayking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.security.oauth2.client.ResourceServerTokenRelayAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Configuration
@ImportAutoConfiguration(classes = { ResourceServerTokenRelayAutoConfiguration.class })
public class OAuthClientConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	@Qualifier("tokenRelayRequestInterceptor")
	HandlerInterceptor tokenRelayHandlerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.tokenRelayHandlerInterceptor);
	}

	@Bean
	@LoadBalanced
	public OAuth2RestTemplate restTemplate(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
		return new OAuth2RestTemplate(resource, context);
	}

}
