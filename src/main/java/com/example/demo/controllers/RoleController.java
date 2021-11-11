package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Role;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	private RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> getAll() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }
 
	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getById(@PathVariable Integer id) {
    	Optional<Role> user = roleService.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
		else {
			throw new RecordNotFoundException();
		}
    }
	@RequestMapping(path = "", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> create(@Valid @RequestBody Role request) {
    	Role user = roleService.save(request);
    	return ResponseEntity.ok(user);
    }
	
	
	@RequestMapping(path = "", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> update(@Valid @RequestBody Role request) {
    	roleService.update(request);
    	return ResponseEntity.ok(request);
    }
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public HttpStatus delete(@PathVariable Integer id) {
		roleService.deleteById(id);
    	return HttpStatus.OK;
    }

}
