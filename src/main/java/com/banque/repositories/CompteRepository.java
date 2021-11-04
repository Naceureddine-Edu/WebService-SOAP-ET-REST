package com.banque.repositories;

import com.banque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long>
{
    // Voir Application.properties pour Request Mapping
}
