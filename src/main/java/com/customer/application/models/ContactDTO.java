package com.customer.application.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ContactDTO {
	
	
	Source source;
	
	public enum Source{
		
		 file,
		 db
	 }

	public Object getSource() {
		// TODO Auto-generated method stub
		return source;
	}
}

	

 
