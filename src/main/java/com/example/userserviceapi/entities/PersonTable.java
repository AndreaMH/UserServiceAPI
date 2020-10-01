package com.example.userserviceapi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("PERSON")
public class PersonTable {
	// Clase Entidad, representa lo que hay en la base de datos
	@Id
	private long id;
	
	private String name;
	
	private String address;
	
	private int age;
	
}
