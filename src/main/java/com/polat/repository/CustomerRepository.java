package com.polat.repository;

import com.polat.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MPolat
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
