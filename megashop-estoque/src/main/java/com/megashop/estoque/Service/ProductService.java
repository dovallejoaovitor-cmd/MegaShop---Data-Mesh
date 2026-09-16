package com.megashop.estoque.Service;

import com.megashop.estoque.Entities.Product;
import com.megashop.estoque.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product insert(Product product){
        return repository.save(product);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException(("Produto não encontrado!")));
    }

    public Product updatePriceQuantity(Long id, Product product){
        Product existing = findById(id);

        if(existing ==  null){
            throw new RuntimeException(("Produto não encontrado"));
        }

        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());

        return repository.save(existing);
    }

    public Product updateQuantity(Long id, Product product){
        Product existing = findById(id);

        if(existing ==  null){
            throw new RuntimeException(("Produto não encontrado"));
        }

        existing.setQuantity(product.getQuantity());

        return repository.save(existing);
    }

    public Product updatePrice(Long id, Product product){
        Product existing = findById(id);

        if(existing ==  null){
            throw new RuntimeException(("Produto não encontrado"));
        }

        existing.setPrice(product.getPrice());

        return repository.save(existing);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
