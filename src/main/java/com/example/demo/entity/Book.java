package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
@ApiModel(description = "This is Book Entiy ,To perform various operations on Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bid;
	@Column
	@ApiModelProperty(notes = "Name of the Book",name="bname",required = true)
	@NotEmpty(message = "Please provide Book  Name")
	private String bname;
	@Column
	@ApiModelProperty(notes = "Name of the Book Author",name="bauthor",required = true)
	@NotEmpty(message = "Please provide Book Author Name")
	private String bauthor;
	@Column
	@ApiModelProperty(notes = "Price of the Book",name="bprice",required = true)
	@NotNull(message = "Please provide Book Price")
	private Double bprice;

}
