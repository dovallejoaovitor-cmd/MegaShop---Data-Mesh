package com.megashop.estoque.Repositories;

import com.megashop.estoque.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public class ProductRepository extends JpaRepository<Product, Long> {
}
