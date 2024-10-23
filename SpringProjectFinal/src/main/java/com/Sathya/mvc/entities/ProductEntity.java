package com.Sathya.mvc.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long proId;
	private String proName;
	private Double proPrice;
	private String proBrand;
	private String proDescription;
	private String proCategory;
	private LocalDate createdAt;
	private String createdBy;
	
	
}