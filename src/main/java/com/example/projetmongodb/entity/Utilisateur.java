package com.example.projetmongodb.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Data
@Document(collection = "utilisateurs")
public class Utilisateur implements Serializable {

    @Id
    private Long id;

    private String nom_utilisateur;

    private String mdp;

    @DBRef
    private List<Tache> taches;

}
