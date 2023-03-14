package com.matheuswaked.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheuswaked.workshopmongo.domain.User;
import com.matheuswaked.workshopmongo.dto.UserDTO;
import com.matheuswaked.workshopmongo.repository.UserRepository;
import com.matheuswaked.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
}
