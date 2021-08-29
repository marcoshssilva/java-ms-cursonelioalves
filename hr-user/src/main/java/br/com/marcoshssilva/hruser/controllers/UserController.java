package br.com.marcoshssilva.hruser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcoshssilva.hruser.models.User;
import br.com.marcoshssilva.hruser.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User u = repository.findById(id).get();
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findBySearch(@RequestParam String email) {
		User u = repository.findByEmail(email);
		return ResponseEntity.ok(u);
	}
}
