package com.example.projetmongodb.controller;

import com.example.projetmongodb.entity.Utilisateur;
import com.example.projetmongodb.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/add")
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.addUtilisateur(utilisateur);
    }
    @GetMapping("/all")
    public List<Utilisateur> getAllUtilisateur(){
        return utilisateurService.getAllUtilisateur();
    }
    @GetMapping("/{id}")
    public Optional<Utilisateur> getUtilisateur(@PathVariable("id")Long id){
        return utilisateurService.getUtilisateur(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUtilisateur(@PathVariable("id")Long id){
        utilisateurService.deleteUtilisateur(id);
    }
}
