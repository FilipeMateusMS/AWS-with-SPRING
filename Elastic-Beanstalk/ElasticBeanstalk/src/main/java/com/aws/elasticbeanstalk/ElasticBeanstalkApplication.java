package com.aws.elasticbeanstalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ElasticBeanstalkApplication {

	@GetMapping( "/" )
	public String deploy() {
		return "Aplicação com deploy na AWS Beanstalk!";
	}
	public static void main(String[] args) {
		SpringApplication.run(ElasticBeanstalkApplication.class, args);
	}

}
