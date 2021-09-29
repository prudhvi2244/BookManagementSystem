package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue
	private Integer sid;
	@Column
	@NotEmpty(message = "Please Provide Student Name")
	private String sname;
	@Column	
	@NotEmpty(message = "Please Provide Student City")
	private String scity;
	
}
