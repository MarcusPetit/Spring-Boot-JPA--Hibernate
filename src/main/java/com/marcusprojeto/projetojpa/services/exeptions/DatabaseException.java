package com.marcusprojeto.projetojpa.services.exeptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String msg){
        super(msg);
    }
}
