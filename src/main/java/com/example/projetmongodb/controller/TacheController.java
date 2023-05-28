package com.example.projetmongodb.controller;

import com.example.projetmongodb.entity.Tache;
import com.example.projetmongodb.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/tache")
public class TacheController {

    @Autowired
    private final TacheService tacheService;

    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
    }

    @PostMapping("/add/{id}")
    public Tache addTache(@PathVariable("id")Long id,@RequestBody Tache tache){
        return tacheService.addTache(id,tache);
    }
    @GetMapping("/all")
    public List<Tache> getAllTache(){
        return tacheService.getAllTache();
    }
    @GetMapping("/find/{id}")
    public Optional<Tache> getTache(@PathVariable("id") Long id){
        return tacheService.getTache(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTache(@PathVariable("id") Long id){
        tacheService.deleteTache(id);
    }
}
