package com.samuel.vitorio.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.vitorio.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1","Maria do Socorro","maria@email.com");
		User luana = new User("1","Luana Lima","luana@email.com");
		List<User> users = new ArrayList<>();
		users.addAll(Arrays.asList(maria,luana));
		return ResponseEntity.ok().body(users);
	}
}
