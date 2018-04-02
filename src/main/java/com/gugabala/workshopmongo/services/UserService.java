package com.gugabala.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gugabala.workshopmongo.domain.User;
import com.gugabala.workshopmongo.dto.UserDTO;
import com.gugabala.workshopmongo.repository.UserRepository;
import com.gugabala.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		User user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		return user;
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.delete(id);
	}

	public User fromDto(UserDTO obj) {
		return new User(obj.getId(), obj.getNome(), obj.getEmail());
	}
}