package br.com.marcoshssilva.hrpayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.marcoshssilva.hrpayroll.models.Payment;
import br.com.marcoshssilva.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,@PathVariable Integer days) {
		Payment payment = this.service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
	/**
	 * comando alternativo, em caso de falha sobre o getPayment
	 * será automaticamente executado pelo HystrixCommand
	 * 
	 * @param workerId
	 * @param days
	 * @return
	 */
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
		Payment payment = new Payment("None", 0.00, days);
		return ResponseEntity.ok(payment);
	}
}
