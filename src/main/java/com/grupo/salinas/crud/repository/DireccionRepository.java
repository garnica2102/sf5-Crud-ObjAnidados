package com.grupo.salinas.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo.salinas.crud.model.Direccion;

public interface DireccionRepository extends MongoRepository<Direccion, String> {

}
