package com.example.projetmongodb.exception;

public class UtilisateurNotFoundException extends RuntimeException{

    public UtilisateurNotFoundException(String message){
        super(message);
    }
}
