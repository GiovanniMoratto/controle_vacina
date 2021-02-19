package br.com.zup.controle_vacina.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.controle_vacina.controller.dto.ApplicationDto;
import br.com.zup.controle_vacina.controller.dto.UserDto;
import br.com.zup.controle_vacina.controller.form.ApplicationForm;
import br.com.zup.controle_vacina.controller.form.UserForm;
import br.com.zup.controle_vacina.model.ApplicationModel;
import br.com.zup.controle_vacina.model.UserModel;
import br.com.zup.controle_vacina.repository.ApplicationRepository;
import br.com.zup.controle_vacina.repository.UserRepository;

@RestController
public class Controller {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@PostMapping
	@Transactional
	@RequestMapping("/user_register")
	public ResponseEntity<UserDto> userRegister(@RequestBody @Valid  UserForm form, UriComponentsBuilder uriBuilder) {
		UserModel userModel = form.converter(userRepository);
		userRepository.save(userModel);
		
		URI uri = uriBuilder.path("/user_register/{id}").buildAndExpand(userModel.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDto(userModel));
	}
	
	@GetMapping("/user_register")
	public ResponseEntity<List<UserModel>> getAllUsers() {
		
		List<UserModel> usersList = userRepository.findAll();
		
		if (usersList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<UserModel>>(usersList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/user_register/{id}")
	public ResponseEntity<UserModel> getOneUser(@PathVariable(value="id") long id) {
		
		Optional<UserModel> userX = userRepository.findById(id);
		
		if (!userX.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<UserModel>(userX.get(), HttpStatus.OK);
		}
	}
	
		
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<UserModel> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@Transactional
	@RequestMapping("/application_register")
	public ResponseEntity<ApplicationDto> applicationRegister(@RequestBody @Valid  ApplicationForm form, UriComponentsBuilder uriBuilder) {
		ApplicationModel applicationModel = form.converter(applicationRepository);
		applicationRepository.save(applicationModel);
		
		URI uri = uriBuilder.path("/application_register/{id}").buildAndExpand(applicationModel.getId()).toUri();
		return ResponseEntity.created(uri).body(new ApplicationDto(applicationModel));
	}

}
