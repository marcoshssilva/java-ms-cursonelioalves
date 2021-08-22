package br.com.marcoshssilva.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcoshssilva.hrpayroll.feignclients.WorkerFeignClient;
import br.com.marcoshssilva.hrpayroll.models.Payment;
import br.com.marcoshssilva.hrpayroll.models.Worker;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = this.workerFeignClient.findById(workerId).getBody();		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
