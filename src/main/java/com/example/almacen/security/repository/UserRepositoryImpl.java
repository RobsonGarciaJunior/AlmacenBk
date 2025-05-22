//package com.example.almacen.security.repository;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.example.almacen.security.model.User;
//
//@Repository
//public class UserRepositoryImpl implements IUserRepository {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	@Override
//	public Optional<User> findByEmail(String email) {
//		// veremos el optional mas adelante
//		try {
//			User user = jdbcTemplate.queryForObject("SELECT * from users where email = ?", BeanPropertyRowMapper.newInstance(User.class), email);
//			return Optional.of(user);
//		} catch (EmptyResultDataAccessException e){
//			e.printStackTrace();
//			return Optional.empty();
//		}
//	}
//
//	@Override
//	public int create(User user) {
//		// IMPORTANTE: la contrasenia ha tenido que ser cifrada antes de entrar aqui
//		
//		// TODO podria darnos excepcion por que el email es unico		
//		return jdbcTemplate.update("INSERT INTO users (email, password) VALUES (?, ?)",
//			new Object[] { 
//				user.getEmail(), 
//				user.getPassword() // debe estar cifrada de antemano
//			}	
//		);
//	}
//
//}
