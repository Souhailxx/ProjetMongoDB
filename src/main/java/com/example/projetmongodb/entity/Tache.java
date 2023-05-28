package com.example.projetmongodb.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Document(collection = "taches")
public class Tache implements Serializable {

    @Id
    private Long id;

    private String titre;

    private String description;


    private String date_echeance;

    private Boolean statut_termine;

    @DBRef
    private Utilisateur utilisateur;

}

