package br.com.zup.controle_vacina.controller.dto;

import java.util.Date;

import br.com.zup.controle_vacina.model.UserModel;

public class UserDto {
	
	private Long id;
	private String name;
	private String cpf;
	private String email;
	private Date birthDate;
	
	
	public UserDto(UserModel userModel) {
		this.id = userModel.getId();
		this.name = userModel.getName();
		this.cpf = userModel.getCpf();
		this.email = userModel.getEmail();
		this.birthDate = userModel.getBirthDate();
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getCpf() {
		return cpf;
	}


	public String getEmail() {
		return email;
	}


	public Date getBirthDate() {
		return birthDate;
	}

	
}