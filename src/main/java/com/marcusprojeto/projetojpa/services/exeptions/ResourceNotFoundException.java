package com.marcusprojeto.projetojpa.services.exeptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Rercurso não encontrado" + id);
    }
}
