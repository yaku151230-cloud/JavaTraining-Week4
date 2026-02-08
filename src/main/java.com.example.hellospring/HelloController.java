package com.example.hellospring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Helloのコントローラー
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello, Spring Boot!";
	}

}
