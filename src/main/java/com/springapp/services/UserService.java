/**
 * 
 */
package com.springapp.services;

import java.util.List;

import com.springapp.entities.User;
import com.springapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	@Transactional(readOnly = true)
	public User findUserById(int id) {
		return userRepository.findOne(id);
	}

	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.delete(id);
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
}

