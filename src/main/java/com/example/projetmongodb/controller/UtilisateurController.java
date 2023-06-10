package com.example.projetmongodb.controller;

import com.example.projetmongodb.entity.Utilisateur;
import com.example.projetmongodb.repository.TacheRepository;
import com.example.projetmongodb.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;
    private final TacheRepository tacheRepository;

    @Autowired
    public UtilisateurController(UtilisateurRepository utilisateurRepository, TacheRepository tacheRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.tacheRepository = tacheRepository;
    }

    @GetMapping("/all")
    public List<Utilisateur> findAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @GetMapping("/{id}")
    public Utilisateur findUtilisateurByID(@PathVariable("id") String id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé avec l'ID : " + id));
    }

    @GetMapping("/nom/{nomUtilisateur}")
    public Utilisateur findUtilisateurByNomUtilisateur(@PathVariable("nomUtilisateur") String nomUtilisateur) {
        return utilisateurRepository.findByNomUtilisateur(nomUtilisateur)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé avec le nom d'utilisateur : " + nomUtilisateur));
    }

    @PostMapping("/add")
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
        boolean exists = utilisateurRepository.existsByNomUtilisateur(utilisateur.getNomUtilisateur());
        if (!exists) {
            utilisateur.setId(String.valueOf(UUID.randomUUID()));
            return utilisateurRepository.save(utilisateur);
        }else
            throw new IllegalArgumentException("Nom D'Utilisateur existe deja");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUtilisateurbyID(@PathVariable("id") String id) {
        utilisateurRepository.deleteById(id);
    }

    @DeleteMapping("/delete/nom/{nomUtilisateur}")
    public void deleteUtilisateurbyNomUtilisateur(@PathVariable("nomUtilisateur") String nomUtilisateur) {
        utilisateurRepository.deleteByNomUtilisateur(nomUtilisateur);
    }
}