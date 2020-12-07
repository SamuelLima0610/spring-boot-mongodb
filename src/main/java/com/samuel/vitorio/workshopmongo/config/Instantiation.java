package com.samuel.vitorio.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.samuel.vitorio.workshopmongo.domain.User;
import com.samuel.vitorio.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		User u1 = new User(null,"Samuel Lima","sam@mail.com");
		User u2 = new User(null,"Luana Lima","lu@mail.com");
		User u3 = new User(null,"Rafael Lima","rafa@mail.com");
		repository.saveAll(Arrays.asList(u1,u2,u3));
	}

}
