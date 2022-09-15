package it.uniroma3.siw.spring.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	protected UserRepository userRepository;

	@Transactional
	public User getUser(Long id) {
		Optional<User> result = this.userRepository.findById(id);
		return result.orElse(null);
	}

	@Transactional
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}

	@Transactional
	public List<User> getAllUsers() {
		List<User> result = new ArrayList<>();
		Iterable<User> iterable = this.userRepository.findAll();
		for(User u : iterable) 
			result.add(u);
		return result;
	}

	@Transactional 
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public User createUser() {
		return new User();
	}
}

