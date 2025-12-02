package com.yuga.repo;

import com.yuga.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByEmail(String email);
}
