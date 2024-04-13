package com.grupo.salinas.crud.service;

import java.util.List;

import com.grupo.salinas.crud.model.Usuario;
import com.grupo.salinas.crud.util.ApiResponse;

public interface UsuarioService {
	
    Usuario findById(String id);
    List<Usuario> findAllUsers();
    ApiResponse delete(String id);
    ApiResponse save(Usuario usuario);
    ApiResponse update(String id, Usuario usuario);
}
