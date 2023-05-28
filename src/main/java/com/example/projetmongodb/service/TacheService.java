package com.example.projetmongodb.service;

import com.example.projetmongodb.entity.Tache;
import com.example.projetmongodb.entity.Utilisateur;
import com.example.projetmongodb.exception.UtilisateurNotFoundException;
import com.example.projetmongodb.repository.TacheRepository;
import com.example.projetmongodb.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TacheService {

    @Autowired
    private final TacheRepository tacheRepository;
    private final UtilisateurRepository utilisateurRepository;

    public TacheService(TacheRepository tacheRepository, UtilisateurRepository utilisateurRepository) {
        this.tacheRepository = tacheRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public Tache addTache(Long utilisateurID,Tache tache){
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurID)
                .orElseThrow(() -> new UtilisateurNotFoundException("Utilisateur by id " + utilisateurID + " was not found"));
        utilisateur.getTaches().add(tache);
        tache.setUtilisateur(utilisateur);
        utilisateurRepository.save(utilisateur);
        return tacheRepository.save(tache);
    }


    public List<Tache> getAllTache(){
        return tacheRepository.findAll();
    }

    public Optional<Tache> getTache(Long id){
        return tacheRepository.findById(id);
    }

    public void deleteTache(Long id){
        Optional<Tache> tache = tacheRepository.findById(id);
        tache.get().getUtilisateur().getTaches().removeIf(tache1 -> {
            return tache1.getId() == id;
        });
        tacheRepository.deleteById(id);
    }
}
