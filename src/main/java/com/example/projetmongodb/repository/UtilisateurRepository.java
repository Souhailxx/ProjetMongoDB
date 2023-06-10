package com.example.projetmongodb.repository;

import com.example.projetmongodb.entity.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur,String> {
    Optional<Utilisateur> findByNomUtilisateur(String nomUtilisateur);

    void deleteByNomUtilisateur(String nomUtilisateur);

    boolean existsByNomUtilisateur(String nomUtilisateur);
}
