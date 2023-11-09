package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//notation responsável por definir um controller(gerenciador de requests)
@RestController
public class GreetingController {

	//mensagem da request
	private static final String template = "Dale, %s!";
	//contador dos ids das requests
	private final AtomicLong counter = new AtomicLong();
	
	//notation responsável por definir o caminho na url em que se localiza a request
	@RequestMapping("/greeting")
	public Greeting greeting(
			//definindo parâmetro da request
			@RequestParam(value = "name", defaultValue = "World") 
			String name) {
			return new Greeting(counter.incrementAndGet(), String.format(template , name));
	}
	
}
