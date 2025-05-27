package com.example.almacen.security.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.almacen.model.controller.user.UserPostRequest;
import com.example.almacen.model.service.UserDTO;
import com.example.almacen.security.model.User;
import com.example.almacen.security.repository.IUserRepository;


@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	IUserRepository userRepository;
	
	
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
    public List<UserDTO> findAll(Boolean habilitado) {
        List<User> users = habilitado != null ? 
            userRepository.findByHabilitado(habilitado) : // Filtrado
            userRepository.findAllUsers(); // Todos los usuarios
        
        return users.stream()
            .map(this::convertFromUserDAOToDTO)
            .collect(Collectors.toList());
    }
   

    @Override
    public UserDTO updateUser(Integer id, UserPostRequest request) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        user.setNombre(request.getNombre());
        user.setHabilitado(request.getHabilitado());
        // Otros campos...
        
        User updatedUser = userRepository.save(user);
        return convertFromUserDAOToDTO(updatedUser);
    }

    @Override
    public void disableUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setHabilitado(false);
        userRepository.save(user);
    }

    @Override
	public Optional<UserDTO> findById(Integer id) {
	    return userRepository.findById(id)
	            .map(user -> new UserDTO(
	                    user.getId(),
	                    user.getEmail(),
	                    user.getNombre(),
	                    user.getApellido(),
	                    user.getFoto(),
	                    user.getHabilitado(),
	                    user.getTipoUser()
	            ));
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
