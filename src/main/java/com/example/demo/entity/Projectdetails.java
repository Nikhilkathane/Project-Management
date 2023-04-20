package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor@Getter@Setter
public class Projectdetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String projectName;
	 private String reason;
	 private String type;
	  private String division;
	  private String department;
	  private Date startDate;
	  private Date endDate;
	 private String locations;
	  private String status;


}
