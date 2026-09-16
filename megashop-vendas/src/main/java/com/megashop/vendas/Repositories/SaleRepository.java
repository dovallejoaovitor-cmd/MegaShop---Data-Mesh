package com.megashop.vendas.Repositories;

import com.megashop.vendas.Entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
