package com.example.cricket.repository;


import com.example.cricket.model.Cricketer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketerRepository extends MongoRepository<Cricketer, String> {
  // You can add custom query methods here if needed
  // For example:
  // List<Cricketer> findByCountry(String country);
  // List<Cricketer> findByRole(String role);
}