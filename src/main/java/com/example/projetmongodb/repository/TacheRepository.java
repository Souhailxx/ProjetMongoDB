package com.example.projetmongodb.repository;

import com.example.projetmongodb.entity.Tache;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends MongoRepository<Tache, String> {

    List<Tache> findByIdUtilisateur(String idUtilisateur);


    void deleteTacheByTitre(String titre);


    void deleteByTitre(String titre);

    Tache findTacheByTitre(String titre);
}
