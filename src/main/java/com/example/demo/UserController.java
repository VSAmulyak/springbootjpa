package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public List<UserDetails> getAllUser() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public void addUser(@RequestBody UserDetails userRecord) {
		userService.addUser(userRecord);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public UserDetails getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
}
