package com.retail.app.service;

import com.retail.app.exception.ResourceNotFoundException;
import com.retail.app.model.Product;
import com.retail.app.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(@Min(value = 1L, message = "Invalid product Id") long id, Product product) {

        if (productRepository.findById(id) == null)
            throw new ResourceNotFoundException("Product not found");
        else {
            product.setId(id);
            return productRepository.save(product);
        }

    }

    @Override
    public void delete(long id){
        if (productRepository.findById(id) == null)
            throw new ResourceNotFoundException("Product not found");
        else
            productRepository.deleteById(id);
    }
}
