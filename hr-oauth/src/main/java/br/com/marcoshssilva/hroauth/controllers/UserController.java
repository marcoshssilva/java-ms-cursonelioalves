package br.com.marcoshssilva.hroauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcoshssilva.hroauth.models.User;
import br.com.marcoshssilva.hroauth.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {
			User u = service.findByEmail(email);
			return ResponseEntity.ok(u);
			
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).build();
			
		}
	}
}
