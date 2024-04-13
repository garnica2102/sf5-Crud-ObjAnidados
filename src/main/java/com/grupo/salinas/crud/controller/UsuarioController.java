package com.grupo.salinas.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.salinas.crud.model.Usuario;
import com.grupo.salinas.crud.service.UsuarioService;


/**

 * Esta clase define los métodos del controlador
 * @author: Edgar Garnica Camacho
 * @version: 0.1, 13/04/2024
 */
@RestController
@RequestMapping("/WSCentralesMock/api/v1/")
public class UsuarioController {

	
	@Autowired
    private UsuarioService service;
    
    @PostMapping("/Users")
    public ResponseEntity<?> createUser(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.save(usuario));
    }

    @GetMapping("/viewAllUsers")	
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(service.findAllUsers());
    }

    @GetMapping("userId/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/updateUserId/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "id") String id, 
    		@RequestBody Usuario usuario) {
         return ResponseEntity.ok(service.update(id, usuario));
    }
    
    @DeleteMapping("/deleteUserId/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
