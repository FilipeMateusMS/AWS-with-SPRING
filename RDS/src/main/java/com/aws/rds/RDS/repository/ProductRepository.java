package com.aws.rds.RDS.repository;

import com.aws.rds.RDS.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
