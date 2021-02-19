package br.com.zup.controle_vacina.controller.form;

import java.util.Date;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.zup.controle_vacina.config.validation.CPFExists;
import br.com.zup.controle_vacina.config.validation.EmailExists;
import br.com.zup.controle_vacina.model.UserModel;
import br.com.zup.controle_vacina.repository.UserRepository;

public class UserForm {
	
	@NotNull @Length(min = 5, max = 120)
	private String name;
	
	@NotNull @CPF @CPFExists
	private String cpf;

	@NotNull @Email @EmailExists
	private String email;
	
	@NotNull @DateTimeFormat
	private Date birthDate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
	public UserModel converter(UserRepository userRepository) {
		return new UserModel(name, cpf, email, birthDate);
	}
	
}