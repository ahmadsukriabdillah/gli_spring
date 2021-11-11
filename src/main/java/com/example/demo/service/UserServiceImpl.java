package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository; 

	@Override
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll(Sort.by("name").ascending());
	}

	@Override
	public User save(User values) {
		return userRepository.save(values);
	}

	@Override
	public void deleteById(Integer value) {
		userRepository.deleteById(value);
	}

	@Override
	public void update(User values) {
		if(userRepository.existsById(values.getId())) {
			userRepository.save(values);
		}
	}


}
