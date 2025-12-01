package com.yuga.demo.service;

import com.yuga.demo.entity.StudentEntity;
import com.yuga.demo.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public StudentEntity create(StudentEntity s) { return repo.save(s); }
    public StudentEntity update(Long id, StudentEntity s) {
        s.setId(id);
        return repo.save(s);
    }
    public StudentEntity getById(Long id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found")); }
    public List<StudentEntity> getAll() { return repo.findAll(); }
    public void delete(Long id) { repo.deleteById(id); }
}
