package br.com.marcoshssilva.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcoshssilva.hruser.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByEmail(String email);
}
