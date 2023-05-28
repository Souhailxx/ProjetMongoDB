package com.example.projetmongodb.repository;

import com.example.projetmongodb.entity.Tache;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TacheRepository extends MongoRepository<Tache,Long> {
}
