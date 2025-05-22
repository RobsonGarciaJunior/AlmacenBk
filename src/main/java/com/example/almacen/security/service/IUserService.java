package com.example.almacen.security.service;

import com.example.almacen.model.service.UserDTO;

public interface IUserService {

	UserDTO findById(Integer id);
//	int create(User user);
}
