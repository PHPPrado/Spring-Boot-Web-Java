package com.unip.universidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class UniversidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversidadeApplication.class, args);
		testeGetAlunos();
	}


	private RestTemplate restTemplate = new RestTemplate();
	public static void testeGetAlunos(){
		String url = "http://localhost:8080/listaAlunos";
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(restTemplate.getForObject(url, String.class));
	}

}
