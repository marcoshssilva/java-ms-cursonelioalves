package br.com.marcoshssilva.hsworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcoshssilva.hsworker.entities.Worker;
import br.com.marcoshssilva.hsworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	@Autowired
	WorkerRepository workerRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.ok(this.workerRepository.findAll());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker w = workerRepository.findById(id).get();
		return ResponseEntity.ok(w);
	}
}
