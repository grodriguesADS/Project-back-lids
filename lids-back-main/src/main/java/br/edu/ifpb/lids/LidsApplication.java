package br.edu.ifpb.lids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class LidsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LidsApplication.class, args);
	}

}
