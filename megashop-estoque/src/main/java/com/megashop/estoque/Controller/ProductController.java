package com.megashop.estoque.Controller;

import com.megashop.estoque.Entities.Product;
import com.megashop.estoque.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product insert(@RequestBody Product product){
        return service.insert(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}/price-quantity")
    public Product findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}/quantity")
    public Product updatePriceQuantity(@PathVariable Long id, @RequestBody Product product){
        return service.updatePriceQuantity(id, product);
    }

    @PutMapping("/{id}/price")
    public Product updateQuantity(@PathVariable Long id, @RequestBody Product product){
        return service.updateQuantity(id, product);
    }

    @PutMapping("/{id}")
    public Product updatePrice(@PathVariable Long id, @RequestBody Product product){
        return service.updatePrice(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
