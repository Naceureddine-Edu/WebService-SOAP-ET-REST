package com.banque;

import com.banque.entities.Compte;
import com.banque.entities.TypeCompte;
import com.banque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class BanqueMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanqueMicroServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            RepositoryRestConfiguration restConfiguration)
    {
        return args -> {
            // Afficher le ID Dans Les RepositoryRest
            restConfiguration.exposeIdsFor(Compte.class);

            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE));
            compteRepository.findAll().forEach(cpt -> System.out.println(cpt.toString()));
        };
    }
}
