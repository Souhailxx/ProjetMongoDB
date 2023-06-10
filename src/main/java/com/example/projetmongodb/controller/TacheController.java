package com.example.projetmongodb.controller;

import com.example.projetmongodb.entity.Tache;
import com.example.projetmongodb.repository.TacheRepository;
import com.example.projetmongodb.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/taches")
public class TacheController {
    private final TacheRepository tacheRepository;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public TacheController(TacheRepository tacheRepository, UtilisateurRepository utilisateurRepository) {
        this.tacheRepository = tacheRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    @GetMapping("/{id}/all")
    public List<Tache> findAllTacheByUtilisateur(@PathVariable("id") String id){
        return tacheRepository.findByIdUtilisateur(id);
    }
    @PostMapping("/add")
    public Tache addTache(@RequestBody Tache tache){
        tache.setId(String.valueOf(UUID.randomUUID()));
        return tacheRepository.save(tache);
    }
    @DeleteMapping("/delete/{idTache}")
    public void deleteTache(@PathVariable("idTache") String id){
        tacheRepository.deleteById(id);
    }



}