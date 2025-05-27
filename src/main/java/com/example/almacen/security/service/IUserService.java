package com.example.almacen.security.service;

import java.util.List;
import java.util.Optional;

import com.example.almacen.model.controller.user.UserPostRequest;
import com.example.almacen.model.service.UserDTO;

public interface IUserService {

//	UserDTO findById(Integer id);
//	int create(User user);
	Optional<UserDTO> findById(Integer id);

	List<UserDTO> findAll(Boolean habilitado);

	UserDTO updateUser(Integer id, UserPostRequest request);

	void disableUser(Integer id);
}
