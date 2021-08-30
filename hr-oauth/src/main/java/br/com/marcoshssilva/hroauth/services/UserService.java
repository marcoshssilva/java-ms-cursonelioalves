package br.com.marcoshssilva.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.marcoshssilva.hroauth.feignclients.UserFeignClient;
import br.com.marcoshssilva.hroauth.models.User;

@Service
public class UserService implements UserDetailsService {

	private static Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient client;
	
	public User findByEmail(String email) {
		User u = client.findBySearch(email).getBody();
		
		if(u == null) {
			LOG.info("Email not found or not exists, value: " + email);
			throw new IllegalArgumentException("email not found or not exists");
		}
		
		return u;
	}
	
	public User findById(Long id) {
		User u = client.findById(id).getBody();
		return u;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			return this.findByEmail(username);
		} catch(IllegalArgumentException e) {
			throw new UsernameNotFoundException("Email not found");
		}
		
	}
}
