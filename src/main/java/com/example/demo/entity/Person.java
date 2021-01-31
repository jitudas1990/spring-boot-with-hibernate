package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Person {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyyy")
	//private Date dob;

}
