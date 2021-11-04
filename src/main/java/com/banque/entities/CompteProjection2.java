package com.banque.entities;


import org.springframework.data.rest.core.config.Projection;
import java.util.Date;

@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection2
{
    public double getSolde();
    public TypeCompte getTypeCompte();
}
