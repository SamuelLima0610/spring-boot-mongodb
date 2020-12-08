package com.samuel.vitorio.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuel.vitorio.workshopmongo.domain.User;
import com.samuel.vitorio.workshopmongo.dto.UserDTO;
import com.samuel.vitorio.workshopmongo.repository.UserRepository;
import com.samuel.vitorio.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id){
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
	}
	
	public void deleteById(String id){
		findById(id);
		repository.deleteById(id);
	}
	
	public User create(User user){
		return repository.insert(user);
	}
	
	public User fromDTO(UserDTO dto){
		return new User(dto.getId(),dto.getName(), dto.getEmail());
	}
}
