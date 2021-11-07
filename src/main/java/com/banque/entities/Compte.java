package com.banque.entities;

import lombok.*;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement // for jaxRS
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Compte
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private TypeCompte typeCompte;
}
