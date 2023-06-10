package com.example.projetmongodb.repository;

import com.example.projetmongodb.entity.Tache;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TacheRepository extends MongoRepository<Tache,String> {

    List<Tache> findByIdUtilisateur(String idUtilisateur);
    List<Tache> findByTitreContainingIgnoreCase(String motCle);
    long countByEstTerminee(boolean estTerminee);

    List<Tache> findByTitreContainingIgnoreCaseAndIdUtilisateur(String motCle,String id);

    long countByIdUtilisateur(String id);

    long countByEstTermineeAndIdUtilisateur(boolean b, String id);

    List<Tache> findByIdUtilisateurAndEstTermineeOrderByDateEcheanceAsc(String id, boolean b);

    List<Tache> findByIdUtilisateurOrderByDateEcheanceAsc(String id);
}
