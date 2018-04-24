package io.github.ashayking.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Configuration
public class JdbcUserDetailsService implements UserDetailsService {

	private List<UserDetailsService> uds = new LinkedList<>();

	public JdbcUserDetailsService() {
		// Default constructor
	}

	public void addService(UserDetailsService srv) {
		uds.add(srv);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if (uds != null) {
			for (UserDetailsService srv : uds) {
				try {
					final UserDetails details = srv.loadUserByUsername(userName);
					if (details != null) {
						return details;
					}
				} catch (UsernameNotFoundException ex) {
					assert ex != null;
				} catch (Exception ex) {
					throw ex;
				}
			}
		}

		throw new UsernameNotFoundException("Unknown user");
	}
}