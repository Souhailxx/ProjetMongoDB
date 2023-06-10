package com.example.projetmongodb.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String id;
    private String titre;
    private String description;
    private Date dateEcheance;
    private boolean estTerminee;
    private String idUtilisateur; // Identifiant de l'utilisateur propriétaire de la tâche
}

