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
		return "<!DOCTYPE html>"
			+ "<html lang=\"pt-br\">"
			+ "<head>"
			+ "<meta charset=\"UTF-8\">"
			+ "<title>11CLDR - DevOps CI/CD</title>"
			+ "<style>"
			+ "body {"
			+ "  margin: 0;"
			+ "  min-height: 100vh;"
			+ "  display: flex;"
			+ "  align-items: center;"
			+ "  justify-content: center;"
			+ "  background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);"
			+ "  font-family: 'Segoe UI', Arial, sans-serif;"
			+ "}"
			+ ".card {"
			+ "  background: rgba(255, 255, 255, 0.08);"
			+ "  backdrop-filter: blur(10px);"
			+ "  border: 1px solid rgba(255, 255, 255, 0.15);"
			+ "  border-radius: 20px;"
			+ "  padding: 40px 50px;"
			+ "  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.4);"
			+ "  color: #fff;"
			+ "  text-align: center;"
			+ "  animation: fadeIn 1s ease-in-out;"
			+ "}"
			+ "h1 {"
			+ "  font-size: 1.6rem;"
			+ "  margin-bottom: 4px;"
			+ "  background: linear-gradient(90deg, #00c6ff, #0072ff);"
			+ "  -webkit-background-clip: text;"
			+ "  -webkit-text-fill-color: transparent;"
			+ "}"
			+ "h2 {"
			+ "  font-weight: 400;"
			+ "  font-size: 1rem;"
			+ "  color: #a0d8ff;"
			+ "  margin-top: 0;"
			+ "  margin-bottom: 25px;"
			+ "}"
			+ "ul {"
			+ "  list-style: none;"
			+ "  padding: 0;"
			+ "  margin: 0;"
			+ "  text-align: left;"
			+ "}"
			+ "li {"
			+ "  padding: 10px 0;"
			+ "  border-bottom: 1px solid rgba(255, 255, 255, 0.1);"
			+ "  font-size: 1rem;"
			+ "}"
			+ "li:last-child { border-bottom: none; }"
			+ ".rm {"
			+ "  color: #7fdbff;"
			+ "  font-weight: bold;"
			+ "  float: right;"
			+ "}"
			+ "@keyframes fadeIn {"
			+ "  from { opacity: 0; transform: translateY(20px); }"
			+ "  to { opacity: 1; transform: translateY(0); }"
			+ "}"
			+ "</style>"
			+ "</head>"
			+ "<body>"
			+ "<div class=\"card\">"
			+ "<h1>11CLDR / DevOps CI/CD</h1>"
			+ "<h2>Prof\u00ba. Fabiano da Silva Carneiro</h2>"
			+ "<ul>"
			+ "<li>Gregory Dias Borges Gon\u00e7alves <span class=\"rm\">RM368346</span></li>"
			+ "<li>Kleber dos Santos Guerra <span class=\"rm\">RM369570</span></li>"
			+ "<li>Lu\u00eds Rodrigo Melo Siqueira <span class=\"rm\">RM367616</span></li>"
			+ "<li>Phelip Logan Pereira Alves <span class=\"rm\">RM368507</span></li>"
			+ "<li>Andr\u00e9 Lu\u00eds Pires Carvalho <span class=\"rm\">RM368115</span></li>"
			+ "</ul>"
			+ "</div>"
			+ "</body>"
			+ "</html>";
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