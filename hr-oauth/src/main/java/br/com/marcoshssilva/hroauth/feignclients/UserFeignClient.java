package br.com.marcoshssilva.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.marcoshssilva.hroauth.models.User;

@FeignClient(name = "hr-user", path = "/users")
@Component
public interface UserFeignClient {
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id);
	
	@GetMapping("/search")
	public ResponseEntity<User> findBySearch(@RequestParam String email);
}
