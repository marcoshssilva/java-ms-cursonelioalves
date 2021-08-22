package br.com.marcoshssilva.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.marcoshssilva.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 100.00, days);
	}
}
