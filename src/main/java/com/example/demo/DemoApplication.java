package com.example.demo;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.example.demo.configuration.AppUser;
import com.example.demo.configuration.LoggedInUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
       
	@GetMapping("/")
        public String healthCheck(){
                return "HEALTH CHECK OK!";
        }

	@GetMapping("/secured")
	public Object secured(@LoggedInUser AppUser appUser){
		return appUser.getUser();
	}

	@GetMapping("/secured-admin")
	@PreAuthorize("hasRole('ROLE_admin')")
	public String securedAdmin(){
		return "Only admin can see  this";
	}
	
	@GetMapping("/public")
	public String pub(){
		
		return "This is public endpoint";
	}

	@GetMapping("/what-is-the-time")
	String time(){
		return LocalDateTime.now(ZoneOffset.UTC).toString();
	}
	
	@GetMapping("/devops")
	String turma(){
		return "Zumbi";
	}
	
	@GetMapping("/autoglass")
	String autoglass(){
		return "https://www.autoglassonline.com.br/";
	}
	
	@GetMapping("/9CLDR")
	String cldr(){
		return "Turma 9 MBA Cloud";
	}

	@GetMapping("/7DVPR")
	String DVP7(){
		return "Turma 7 MBA DEVOPS";
	}
	
	@GetMapping("/UFSCAR")
	String UFSCAR(){
		return "Turma UFSCAR 2026";
	}

	@GetMapping(value = "/FIAP", produces = MediaType.TEXT_HTML_VALUE)
	String FIAP(){
		return "11CLDR / devops ci/cd /Profº. Fabiano da Silva Carneiro<br>"
			+ "Gregory Dias Borges Gonçalves - RM368346<br>"
			+ "Kleber dos Santos Guerra - RM369570<br>"
			+ "Luís Rodrigo Melo Siqueira - RM367616<br>"
			+ "Phelip logan Pereira Alves - RM368507<br>"
			+ "André Luís Pires Carvalho - RM368115";
	}
	
	@GetMapping(value = "/fiap", produces = MediaType.TEXT_HTML_VALUE)
	String fiap(){
		return "11CLDR / devops ci/cd /Profº. Fabiano da Silva Carneiro<br>"
			+ "Gregory Dias Borges Gonçalves - RM368346<br>"
			+ "Kleber dos Santos Guerra - RM369570<br>"
			+ "Luís Rodrigo Melo Siqueira - RM367616<br>"
			+ "Phelip logan Pereira Alves - RM368507<br>"
			+ "André Luís Pires Carvalho - RM368115";
	}
}