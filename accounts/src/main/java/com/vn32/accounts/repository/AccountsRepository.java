package com.vn32.accounts.repository;

import com.vn32.accounts.entity.Accounts;
import com.vn32.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    Optional<Accounts> findByCustomerId(Long customerId);

    @Transactional
    @Modifying //means this is a custom method which will modify the data,that's why transaction is required
    void deleteByCustomerId(Long customerId);
}
