package com.example.cricket.controller;


import com.example.cricket.model.Cricketer;
import com.example.cricket.service.CricketerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cricketers")
public class CricketerController {

  private final CricketerService service;

  @Autowired
  public CricketerController(CricketerService service) {
    this.service = service;
  }

  @GetMapping
  public List<Cricketer> getAllCricketers() {
    return service.getAllCricketers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cricketer> getCricketerById(@PathVariable String id) {
    Optional<Cricketer> cricketer = service.getCricketerById(id);
    return cricketer.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cricketer createCricketer(@RequestBody Cricketer cricketer) {
    System.out.println("Received cricketer: " + cricketer); // This will use toString from @Data
    return service.saveCricketer(cricketer);
  }



  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCricketer(@PathVariable String id) {
    Optional<Cricketer> cricketer = service.getCricketerById(id);
    if (cricketer.isPresent()) {
      service.deleteCricketer(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}