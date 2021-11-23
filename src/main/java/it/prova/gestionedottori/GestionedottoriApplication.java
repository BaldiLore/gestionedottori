package it.prova.gestionedottori;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.prova.gestionedottori.model.Dottore;
import it.prova.gestionedottori.service.DottoreService;

@SpringBootApplication
public class GestionedottoriApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionedottoriApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDottori(DottoreService dottoreService) {
		return (args) -> {

			// inizializzo il Db
			dottoreService.save(new Dottore("Paolo", "Brosio", "PB53628", false, false));
			dottoreService.save(new Dottore("Nicola", "Golia", "NG93925", true, false));
			dottoreService.save(new Dottore("Ajeje", "Brazorf", "AB67293", true, false));
			dottoreService.save(new Dottore("Mario", "Rossi", "MR64873", false, false));
			dottoreService.save(new Dottore("Maria", "Bianchi", "MB67721", true, true));

			// verifico inserimento
			System.out.println("Elenco Dottori");
			dottoreService.listAll().forEach(item -> {
				System.out.println(item);
			});

		};
	}

}
