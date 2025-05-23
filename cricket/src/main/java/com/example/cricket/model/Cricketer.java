package com.example.cricket.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cricket")
public class Cricketer {
  @Id
  private String id;
  private String name;
  private int age;
  private String country;
  private String role;

  // Default constructor
  public Cricketer() {}

  // All args constructor
  public Cricketer(String id, String name, int age, String country, String role) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.country = country;
    this.role = role;
  }

  // Getters and Setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "Cricketer{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", country='" + country + '\'' +
            ", role='" + role + '\'' +
            '}';
  }
}