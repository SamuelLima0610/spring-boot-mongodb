package com.samuel.vitorio.workshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<UserDTO> deleteById(@PathVariable String id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO dto){
		User user = service.fromDTO(dto);
		user = service.create(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
