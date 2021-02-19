package br.com.zup.controle_vacina.controller.dto;

import java.util.Date;

import br.com.zup.controle_vacina.model.ApplicationModel;

public class ApplicationDto {
	
	private Long id;
	private String vaccineName;
	private String email;
	private Date applicationDate;

	
	public ApplicationDto(ApplicationModel applicationModel) {

		this.id = applicationModel.getId();
		this.vaccineName = applicationModel.getVaccineName();
		this.applicationDate = applicationModel.getApplicationDate();
		this.email = applicationModel.getEmail();
	}


	public Long getId() {
		return id;
	}


	public String getVaccineName() {
		return vaccineName;
	}


	public String getEmail() {
		return email;
	}


	public Date getApplicationDate() {
		return applicationDate;
	}
	

}
