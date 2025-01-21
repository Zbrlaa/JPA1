package com.example.jpa.tps.TPJPA1;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Books{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String isbn;

	@Column(nullable = false)
	private String name;

	@Column
	private int age;

	public Books(){}

	public Books(String isbn, String name, int age) {
		this.isbn = isbn;
		this.name = name;
		this.age = age;
	}

	
}