package com.samuel.vitorio.workshopmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.vitorio.workshopmongo.domain.User;
import com.samuel.vitorio.workshopmongo.dto.UserDTO;
import com.samuel.vitorio.workshopmongo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> users = service.findAll();
		List<UserDTO> dto = users.stream().map((user) -> new UserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dto);
	}
}
