package com.example.almacen.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.almacen.security.model.User;


public interface IUserRepository extends CrudRepository<User, Integer>{
	Optional<User> findByEmail(String email);
//	int create(User user);

	@Query(value = "SELECT * FROM Usuario", nativeQuery = true)
	List<User> findAllUsers();

	List<User> findByHabilitado(Boolean habilitado);
}
