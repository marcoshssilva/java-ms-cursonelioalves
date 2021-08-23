package br.com.marcoshssilva.hsworker.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private static Logger LOG = LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	WorkerRepository workerRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workers = this.workerRepository.findAll();
		LOG.info("HR-WORKER - Successfull request, PORT=" + env.getProperty("local.server.port"));
		return ResponseEntity.ok(workers);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Worker w = workerRepository.findById(id).get();
		LOG.info("HR-WORKER - Successfull request, PORT=" + env.getProperty("local.server.port"));
		return ResponseEntity.ok(w);
	}
}
