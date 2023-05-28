package com.example.projetmongodb.service;

import com.example.projetmongodb.entity.Tache;
import com.example.projetmongodb.entity.Utilisateur;
import com.example.projetmongodb.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    public Utilisateur addUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getAllUtilisateur(){
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateur(Long id){
        return utilisateurRepository.findById(id);
    }

    public void deleteUtilisateur(Long id){
        utilisateurRepository.deleteById(id);
    }
}
