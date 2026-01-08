package com.yuga.repo;

import com.yuga.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepo extends JpaRepository<AccountsEntity, Long> {
    Optional<AccountsEntity> findByAadhar(Long aadhar);
}
