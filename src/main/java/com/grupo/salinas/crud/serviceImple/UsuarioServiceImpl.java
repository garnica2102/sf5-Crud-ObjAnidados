package com.grupo.salinas.crud.serviceImple;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.grupo.salinas.crud.exception.UsuarioNotFoundException;
import com.grupo.salinas.crud.model.Usuario;
import com.grupo.salinas.crud.repository.DireccionRepository;
import com.grupo.salinas.crud.repository.UsuarioRepository;
import com.grupo.salinas.crud.service.UsuarioService;
import com.grupo.salinas.crud.util.ApiResponse;
import com.grupo.salinas.crud.util.Message;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	DireccionRepository direccionRepository;
	
	@Override
	public Usuario findById(String id) {
        return usuarioRepository.findById(id).orElseThrow(() -> 
        new UsuarioNotFoundException(Message.USUARIO_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now()));
	}

	@Override
	public List<Usuario> findAllUsers() {
        return usuarioRepository.findAll();
	}

	@Override
	public ApiResponse delete(String id) {
        Usuario userNotFound = findById(id);
        if (userNotFound == null) {
            throw new UsuarioNotFoundException(Message.USUARIO_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
        }
        usuarioRepository.deleteById(id);
        return new ApiResponse(Message.USUARIO_DELETE_SUCCESSFULLY, 204, HttpStatus.NO_CONTENT, LocalDateTime.now());
	}

	@Override
	public ApiResponse save(Usuario usuario) {
		
		Optional<Usuario> userExisted = usuarioRepository.findById(usuario.getId());
		
        if(userExisted != null ){
        	usuario =  usuarioRepository.save(usuario);
            return new ApiResponse(Message.USUARIO_SAVE_SUCCESSFULLY, 201, HttpStatus.CREATED, LocalDateTime.now());
        	
        } else {
        	return new ApiResponse(Message.USUARIO_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
        }
        
	}

	@Override
	public ApiResponse update(String id, Usuario usuario) {
		
		Usuario userExisted = usuarioRepository.findById(id).orElseThrow(() -> 
        new UsuarioNotFoundException(Message.USUARIO_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now()));
		
		System.out.println(userExisted);

		try {
			
			if(userExisted == null) {
				return new ApiResponse(Message.USUARIO_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());
			} else {
				Optional<Usuario> user = usuarioRepository.findById(id);
				System.out.println("Id usuario --> " + user);
				Usuario usuarioBase = user.get();
				//Copia todas las pripiedas y recorre el objeto para setearlo con los nuevos valores
				BeanUtils.copyProperties(usuario, usuarioBase);
				usuario =  usuarioRepository.save(usuario);	
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			 new UsuarioNotFoundException(Message.USUARIO_NOT_FOUND, 404, HttpStatus.NOT_FOUND, LocalDateTime.now());			 
		}
		return new ApiResponse(Message.USUARIO_UPDATE_SUCCESSFULLY, 201, HttpStatus.OK, LocalDateTime.now());
	}

}
