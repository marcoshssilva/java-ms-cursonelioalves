package br.com.marcoshssilva.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HsWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HsWorkerApplication.class, args);
	}

}
