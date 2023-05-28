package com.example.projetmongodb.repository;

import com.example.projetmongodb.entity.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UtilisateurRepository extends MongoRepository<Utilisateur,Long> {
}
