package com.vn32.accounts.repository;

import com.vn32.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //any query related to find by id in customer will work but what if we are going to check with mobilenumber or any other column
    //we can use findBycolumnnameAndColumnme2....
    //spring will automatically create query for us
    Optional<Customer> findByMobileNumber(String mobileNumber);
}

