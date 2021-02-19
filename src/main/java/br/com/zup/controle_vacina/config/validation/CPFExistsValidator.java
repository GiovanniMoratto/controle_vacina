package br.com.zup.controle_vacina.config.validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFExistsValidator implements 
ConstraintValidator<CPFExists, String> {
	
	@Override
    public void initialize(CPFExists cpfField) {
    }
	
	@Override
	public boolean isValid(String cpfField, ConstraintValidatorContext context) {
		
		boolean cpfExists = false;
		
		try {
			Class.forName("org.h2.Driver");
	        String databaseURL = "jdbc:h2:mem:controle-vacina";
	        Connection con = DriverManager.getConnection(databaseURL, "sa", "");
	        Statement stat = con.createStatement();    
	        String selectQuery = "SELECT * FROM REGISTERED_USERS WHERE cpf = '"+ cpfField +"'";
	        System.out.println(selectQuery);
	        ResultSet rs=stat.executeQuery(selectQuery);
	        
	        if (rs.next()) {
	        	cpfExists = false;
	        } else {
	        	cpfExists = true;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return cpfExists;
	}

}
