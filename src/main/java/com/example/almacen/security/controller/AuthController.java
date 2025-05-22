package com.example.almacen.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.almacen.security.configuration.JwtTokenUtil;
import com.example.almacen.security.model.AuthRequest;
import com.example.almacen.security.model.AuthResponse;
import com.example.almacen.security.model.User;
import com.example.almacen.security.service.IUserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api")
public class AuthController {
	
	@Autowired 
	AuthenticationManager authenticationManager;
	
	@Autowired 
	JwtTokenUtil jwtUtil;
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			// esta es la funcion que va a intentar identificarse, dado el username y la password introducida
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
			); 
			// devolvera un objeto de tipo authenticacion de las que de momento nos interesa el "principal". El principal contiene los datos del usuario
			// por lo que lo convertimos a su modelo real de BD para tener todos sus campos
			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
			
			return ResponseEntity.ok().body(response);
			
		} catch (BadCredentialsException ex) {
			// esta excepción salta y estamos devolviendo un 401. se podria cambiar pero cuidado con lo que se devuelve al fallar el login etc
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	
//	@PostMapping("/auth/signup")
//	public ResponseEntity<?> signIn(@RequestBody @Valid AuthRequest request) {
//		// TODO solo esta creado en el caso de que funcione. Si no es posible que de 500 o 401.
//		// aqui hacer lo que sea preciso
//
//		// vamos a cifrar la contrasenia aqui, ya que no queremos andar dando vueltas con la contraseña sin encriptar si no es preciso
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String password = passwordEncoder.encode(request.getPassword());
//		
//		// creamos el usuario en DB
//		User user = new User(request.getEmail(), password);
//		return new ResponseEntity<Integer>(userService.create(user), HttpStatus.CREATED);
//	}
	
	
	// utilizamos el /me por que vamos a coger el nuestro, el que estamos logueado...
	@GetMapping("/auth/me")
	public ResponseEntity<?> getUserInfo(Authentication authentication) {
		// aqui podemos castearlo a UserDetails o User. El UserDetails es una interfaz, 
		// si lo casteamos a la interfaz no podremos sacar campos como la ID del usuario
		User userDetails = (User) authentication.getPrincipal();
		
		// IMPORTANTE: por lo tanto, la ID del usuario no tiene que ir como parametro en la peticion del usuario
		
		// aqui podriamos devolver datos del usuario. quizá no sea lo que queremos devolver o no lo querramos devolver
		// es un ejemplo por que con userDetails.getId() tendríamos la ID del usuario sin que la pase por parametro
		// necesario en algunos servicios: si quiero devolver una lista o elemento privado del usuario, no voy a querer
		// que el usuario mande su ID por parametro. Ya que es trampeable.
		// de ahi que sea "/me" en el ejemplo 
		
		return ResponseEntity.ok().body(userDetails);
	}
	
	
}
