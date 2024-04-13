package com.grupo.salinas.crud.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuario")
public class Usuario {
	
	@Id
	private String id;
	private Direccion direccion;
	
	private String nombre;	
    private String paterno;
	private String materno;
	private String fechaNacimiento;
	private String genero;
   	private String curp;
	private String rfc;
	

}
