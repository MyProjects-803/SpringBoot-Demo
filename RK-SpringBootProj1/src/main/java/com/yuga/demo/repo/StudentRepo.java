package com.yuga.demo.repo;

import com.yuga.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByEmail(String email);
}

