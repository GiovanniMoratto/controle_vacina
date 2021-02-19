package br.com.zup.controle_vacina.config.validation;

public class FormDtoError {
	
	private String field;
	private String error;
	
	public FormDtoError(String field, String error) {
		this.field = field;
		this.error = error;
	}

	public String getField() {
		return field;
	}

	public String getError() {
		return error;
	}
}
