package com.bnpp.nepp.repo;

import com.bnpp.nepp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PRDSRepository extends JpaRepository<Payment, String> {
}
