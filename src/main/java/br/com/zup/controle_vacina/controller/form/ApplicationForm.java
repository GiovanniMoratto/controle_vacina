package br.com.zup.controle_vacina.controller.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zup.controle_vacina.config.validation.EmailNotExists;
import br.com.zup.controle_vacina.model.ApplicationModel;
import br.com.zup.controle_vacina.repository.ApplicationRepository;

public class ApplicationForm {
	
	@NotNull @Length(min = 5, max = 120)
	private String vaccineName;
	
	@NotNull
	private Date applicationDate;

	@NotNull @EmailNotExists
	private String email;
	
	
	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public ApplicationModel converter(ApplicationRepository applicationRepository) {
		return new ApplicationModel(vaccineName, email, applicationDate);
	}
	
}
