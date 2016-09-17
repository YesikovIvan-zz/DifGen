/**
 * 
 */
package com.springapp.config;

import com.springapp.entities.User;
import com.springapp.web.config.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springapp.services.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException("UserName " + username + " not found");
		}
		return new SecurityUser(user);
	}

}
