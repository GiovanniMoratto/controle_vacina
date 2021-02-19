package br.com.zup.controle_vacina.config.validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailExistsValidator implements 
ConstraintValidator<EmailExists, String> {
	
	@Override
    public void initialize(EmailExists emailField) {
    }
	
	@Override
	public boolean isValid(String emailField, ConstraintValidatorContext context) {
		
		boolean emailExists = false;
		
		try {
			Class.forName("org.h2.Driver");
	        String databaseURL = "jdbc:h2:mem:controle-vacina";
	        Connection con = DriverManager.getConnection(databaseURL, "sa", "");
	        Statement stat = con.createStatement();    
	        String selectQuery = "SELECT * FROM REGISTERED_USERS WHERE email = '"+ emailField +"'";
	        System.out.println(selectQuery);
	        ResultSet rs=stat.executeQuery(selectQuery);
	        
	        if (rs.next()) {
	        	emailExists = false;
	        } else {
	        	emailExists = true;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return emailExists;
	}

}