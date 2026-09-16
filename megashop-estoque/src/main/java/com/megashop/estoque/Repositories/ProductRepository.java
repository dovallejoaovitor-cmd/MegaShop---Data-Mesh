package com.megashop.estoque.Repositories;

import com.megashop.estoque.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
