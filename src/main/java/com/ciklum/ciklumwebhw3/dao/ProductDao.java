package com.ciklum.ciklumwebhw3.dao;

import com.ciklum.ciklumwebhw3.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

}