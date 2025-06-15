package com.example.kafka.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

    private Long id;
    private String address;
    private String mobile;
    private String name;
    private String department;
    private double salary;
	@Override
	public String toString() {		
		return  "{\"id\": "+id+","
		+ "\"address\": \""+address+"\","
		+ "\"mobile\": \""+mobile+"\","
		+ "\"name\": \""+name+"\","
		+ "\"department\": \""+department+"\","
		+ "\"salary\": "+salary+"}";
	}
    
//	String s = "{\"id\": +id+,"
//			+ "\"address\": \""+address+"\","
//			+ "\"mobile\": \""+mobile+"\","
//			+ "\"name\": \""+name+"\","
//			+ "\"department\": \""+department+"\","
//			+ "\"salary\": "+salary+"}";
    
}
