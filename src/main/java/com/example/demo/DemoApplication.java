package com.example.demo;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.SimpleDateFormat;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role1 = roleService.save(new Role("Admin"));		
		Role role2 = roleService.save(new Role("User"));
		userService.save(new User("SA", "sa@gmail.com", "L", new SimpleDateFormat("dd/MM/yyyy").parse("22/10/1994"), "Adalah alamat saja", role1));
		userService.save(new User("Programmer", "programer@gmail.com", "L", new SimpleDateFormat("dd/MM/yyyy").parse("22/10/1994"), "Adalah alamat saja", role1));
	}
}
