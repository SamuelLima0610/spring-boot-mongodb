package com.samuel.vitorio.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuel.vitorio.workshopmongo.domain.Post;
import com.samuel.vitorio.workshopmongo.repository.PostRepository;
import com.samuel.vitorio.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id){
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitleContaining(text);
	}
	
}
