package com.manas.bidbits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.waleed.oopsproject")
@EntityScan("com.waleed.oopsproject")
@SpringBootApplication
public class OopsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OopsProjectApplication.class, args);
	}

}
