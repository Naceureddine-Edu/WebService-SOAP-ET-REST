package com.banque.webservice;

import com.banque.entities.Compte;
import com.banque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.*;
import java.util.List;

// Pour utiliser ce web service faut le deployer dans un serveur JaxWS
// PS : Voir le package Configuration
@Component // JaxWS n'est pas un composent spring en rajoute l'annotation pour qu'il le prend en charge
@WebService(serviceName = "compteWS")
public class CompteSoapWS
{
    @Autowired
    CompteRepository compteRepository;

    @WebMethod(operationName = "listeComptes")
    public List<Compte> compteList()
    {
        return compteRepository.findAll();
    }

    @WebMethod(operationName = "compteParId")
    public Compte getCompteById(@WebParam(name = "id") Long id)
    {
        return compteRepository.findById(id).get();
    }

    @WebMethod(operationName = "ajouterCompte")
    public Compte saveCompte(@WebParam(name = "compte") Compte compte)
    {
        return compteRepository.save(compte);
    }

    @WebMethod(operationName = "modifierCompte")
    public Compte updateCompte(@WebParam(name = "compte") Compte compte, @WebParam(name = "id") Long id)
    {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @WebMethod(operationName = "supprimerCompte")
    public void deleteCompte(@WebParam(name = "id") Long id)
    {
        compteRepository.deleteById(id);
    }
}
