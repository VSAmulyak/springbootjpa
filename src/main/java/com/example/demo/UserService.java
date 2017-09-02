package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<UserDetails> getAllUsers() {
		List<UserDetails> userRecords = new ArrayList<>();
		userRepository.findAll().forEach(userRecords::add);
		return userRecords;
	}

	public UserDetails getUser(String id) {
		return userRepository.findOne(id);
	}

	public void addUser(UserDetails userRecord) {
		userRepository.save(userRecord);
	}

	public void delete(String id) {
		userRepository.delete(id);
	}

}
