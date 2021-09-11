package br.com.marcoshssilva.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcoshssilva.hruser.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
