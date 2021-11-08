package com.banque.controllers;

import com.banque.entities.Compte;
import com.banque.repositories.CompteRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/banque")
public class CompteController
{
    @Autowired
    CompteRepository compteRepository;

    @GetMapping(path = "/comptes",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Method that return all COMPTE in the data base",
            description = "return all compte objects the the client")
    public List<Compte> compteList()
    {
        return compteRepository.findAll();
    }

    @GetMapping(path ="/comptes/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
            /*produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})*/
    @Operation(summary = "Method that return one COMPTE with his ID",
            description = "return the compte that match the id in the path variable ")
    public Compte getCompteById(@PathVariable Long id)
    {
        return compteRepository.findById(id).get();
    }

    @PostMapping(path ="/comptes",produces = {MediaType.APPLICATION_JSON_VALUE})
            /*produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})*/
    @Operation(summary = "Method that create a new COMPTE in the data base",
            description = "Adding new Compte")
    public Compte saveCompte(@RequestBody Compte compte)
    {
        return compteRepository.save(compte);
    }

    @PutMapping(path ="/comptes/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
           /* produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})*/
    @Operation(summary = "Method that update COMPTE with his ID",
            description = "updating Compte that match the id in the path variable")
    public Compte updateCompte(@RequestBody Compte compte, @PathVariable Long id)
    {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path ="/comptes/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
            /*produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})*/
    @Operation(summary = "Method that delete COMPTE with his ID",
            description = "deleting Compte that match the id in the path variable")
    public void deleteCompte(@PathVariable Long id)
    {
        compteRepository.deleteById(id);
    }
}
