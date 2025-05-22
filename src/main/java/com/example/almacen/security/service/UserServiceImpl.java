package com.example.almacen.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.almacen.model.service.UserDTO;
import com.example.almacen.security.model.User;
import com.example.almacen.security.repository.IUserRepository;


@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	IUserRepository userRepository;
	
//	@Override
//	public int create(User user) {
//		return userRepository.create(user);
//	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	// esta es la funcion que busca al usuario por email. 
		// ya que en este caso el campo de login es el email
    	// si fuese otro, realizar otra funcion
        return userRepository.findByEmail(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User " + username + " not found"));
	}
	
	@Override
	public UserDTO findById(Integer id) {
		
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User " + id + " not found"));

		UserDTO response = convertFromUserDAOToDTO(user);
		return response;

	}
	
	private UserDTO convertFromUserDAOToDTO(User user) {
		UserDTO response = new UserDTO(
				user.getId(),
				user.getEmail(),
				user.getNombre(),
				user.getApellido(),
				user.getFoto(),
				user.getHabilitado(),
				user.getTipoUser()
				);
		return response;
	}
	
}
