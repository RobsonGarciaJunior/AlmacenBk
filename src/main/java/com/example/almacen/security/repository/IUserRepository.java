package com.example.almacen.security.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.almacen.security.model.User;


public interface IUserRepository extends CrudRepository<User, Integer>{
	Optional<User> findByEmail(String email);
//	int create(User user);
}
