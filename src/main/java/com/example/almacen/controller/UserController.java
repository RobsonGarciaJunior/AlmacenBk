package com.example.almacen.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.almacen.model.controller.user.UserGetResponse;
import com.example.almacen.model.controller.user.UserPostRequest;
import com.example.almacen.model.service.UserDTO;
import com.example.almacen.security.service.IUserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private IUserService userService;
	
    @GetMapping
    public ResponseEntity<List<UserGetResponse>> getAllUsers(
            @RequestParam(required = false) Boolean habilitado) {
        
        List<UserDTO> users = userService.findAll(habilitado);
        List<UserGetResponse> response = users.stream()
            .map(this::convertFromUserDTOToGetResponse)
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserGetResponse> findUserById(@PathVariable("id") Integer id) {
        return userService.findById(id)
                .map(userDTO -> ResponseEntity.ok(convertFromUserDTOToGetResponse(userDTO)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserGetResponse> updateUser(
            @PathVariable Integer id, 
            @RequestBody UserPostRequest request) {
        
        UserDTO updatedUser = userService.updateUser(id, request);
        return ResponseEntity.ok(convertFromUserDTOToGetResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> disableUser(@PathVariable Integer id) {
        userService.disableUser(id);
        return ResponseEntity.noContent().build();
    }
    

	private UserGetResponse convertFromUserDTOToGetResponse(UserDTO userDTO) {
	    if (userDTO == null) {
	        return null;
	    }
	    return new UserGetResponse(
	        userDTO.getId(),
	        userDTO.getEmail(),
	        userDTO.getNombre(),
	        userDTO.getApellido(),
	        userDTO.getFoto(),
	        userDTO.getHabilitado(),
	        userDTO.getTipoUser()
	    );
	}


}
