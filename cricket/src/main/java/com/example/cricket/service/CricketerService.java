package com.example.cricket.service;

import com.example.cricket.model.Cricketer;
import com.example.cricket.repository.CricketerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CricketerService {

  private final CricketerRepository repository;

  @Autowired
  public CricketerService(CricketerRepository repository) {
    this.repository = repository;
  }

  public List<Cricketer> getAllCricketers() {
    return repository.findAll();
  }

  public Optional<Cricketer> getCricketerById(String id) {
    return repository.findById(id);
  }

  public Cricketer saveCricketer(Cricketer cricketer) {
    return repository.save(cricketer);
  }

  public void deleteCricketer(String id) {
    repository.deleteById(id);
  }
} 