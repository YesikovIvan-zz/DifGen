/**
 * 
 */
package com.springapp.web.controllers;

import com.springapp.entities.User;
import com.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserService userService;

	@RequestMapping(value="", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User findUser(@PathVariable("id") int id) {
		return userService.findUserById(id);
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public ModelAndView createUser(@RequestBody User user) {
		userService.create(user);
		return new ModelAndView("redirect:/login/form");
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User savedUser = userService.update(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
