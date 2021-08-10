package br.com.marcoshssilva.hsworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcoshssilva.hsworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
