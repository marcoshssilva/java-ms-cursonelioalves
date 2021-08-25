package br.com.marcoshssilva.hrconfigserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {

	@Value("${spring.cloud.config.server.git.username}")
	private String git_user;
	
	@Value("${spring.cloud.config.server.git.password}")
	private String git_pass;
	
	private static final Logger LOG = LoggerFactory.getLogger(HrConfigServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("CONFIG SERVER enable and connected to Git");
		//LOG.info("CREDENTIALS: " + git_user + " " + git_pass);
	}

}
