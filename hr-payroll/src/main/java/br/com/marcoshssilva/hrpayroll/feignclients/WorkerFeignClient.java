package br.com.marcoshssilva.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.marcoshssilva.hrpayroll.models.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id);
}
