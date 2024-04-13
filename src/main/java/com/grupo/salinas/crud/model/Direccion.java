package com.grupo.salinas.crud.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection = "direccion")
public class Direccion {
	
	private String calle;
	private String nunInt;
	private String numExt;
	private String colonia;
	private String cp;
	private String municipio;
	private String estado;
	private String pais;

}
