package com.marcusprojeto.projetojpa.resourcers.execpitons;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String msg){
        super(msg);
    }
}
