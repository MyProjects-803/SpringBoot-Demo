package com.yuga.demo.controller;

import com.yuga.demo.entity.StudentEntity;
import com.yuga.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<StudentEntity> create(@Valid @RequestBody StudentEntity s) {
        StudentEntity created = service.create(s);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public List<StudentEntity> list() { return service.getAll(); }

    @GetMapping("/{id}")
    public StudentEntity get(@PathVariable Long id) { return service.getById(id); }

    @PutMapping("/{id}")
    public StudentEntity update(@PathVariable Long id, @Valid @RequestBody StudentEntity s) { return service.update(id, s); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
