package com.example.projetmongodb;

import com.example.projetmongodb.entity.Tache;
import com.example.projetmongodb.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProjetMongoDbApplication{

    public static void main(String[] args) {
        SpringApplication.run(ProjetMongoDbApplication.class, args);
    }


}
