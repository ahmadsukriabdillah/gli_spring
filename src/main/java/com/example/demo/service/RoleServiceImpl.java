package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Optional<Role> findById(Integer id) {
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role save(Role values) {
		return roleRepository.save(values);
	}

	@Override
	public void deleteById(Integer value) {
		roleRepository.deleteById(value);
	}

	@Override
	public void update(Role values) {
		if(roleRepository.existsById(values.getId())) {
			roleRepository.save(values);
		}		
	}

}
