package paixao.erik.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import paixao.erik.cadastro.util.AppContext;

@SpringBootApplication
public class CadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppContext.class, args);	
	}
}
