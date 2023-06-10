package com.example.projetmongodb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
    private String id;
    @Indexed(unique = true)
    private String nomUtilisateur;
    private String motDePasse;

}
