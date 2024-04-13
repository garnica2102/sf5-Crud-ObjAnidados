package com.grupo.salinas.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo.salinas.crud.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
