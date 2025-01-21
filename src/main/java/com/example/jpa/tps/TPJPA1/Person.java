package com.example.jpa.tps.TPJPA1;

import jakarta.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private int age;

	public Person() {}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}