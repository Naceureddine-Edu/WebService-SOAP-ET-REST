package com.banque.web;

import com.banque.entities.Compte;
import com.banque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

//Pour Autowired sinon y'aura class not found puisque cette class n'est pas un composant spring
@Component
@Path("/banque")
public class CompteRestAPIJaxRS
{
    @Autowired
    CompteRepository compteRepository;

    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Compte> compteList()
    {
       return compteRepository.findAll();
    }

    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getCompteById(@PathParam(value = "id") Long id)
    {
        return compteRepository.findById(id).get();
    }

    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte saveCompte(Compte compte) // meme si on specifie pas @RequestBody ca passe
    {
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte updateCompte(Compte compte, @PathParam(value = "id") Long id)
    {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteCompte(@PathParam(value = "id") Long id)
    {
        compteRepository.deleteById(id);
    }
}
