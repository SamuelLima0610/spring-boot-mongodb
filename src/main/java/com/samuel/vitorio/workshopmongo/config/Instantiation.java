package com.samuel.vitorio.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.samuel.vitorio.workshopmongo.domain.Post;
import com.samuel.vitorio.workshopmongo.domain.User;
import com.samuel.vitorio.workshopmongo.dto.AuthorDTO;
import com.samuel.vitorio.workshopmongo.repository.PostRepository;
import com.samuel.vitorio.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null,"Samuel Lima","sam@mail.com");
		User u2 = new User(null,"Luana Lima","lu@mail.com");
		User u3 = new User(null,"Rafael Lima","rafa@mail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Post postI = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!!", "Vou viajar para São Paulo. Abraços a todos!",new AuthorDTO(u1));
		Post postII = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!",new AuthorDTO(u1));
		
		postRepository.saveAll(Arrays.asList(postI,postII));
		
		u1.getPosts().addAll(Arrays.asList(postI,postII));
		userRepository.save(u1);
	
	}

}
