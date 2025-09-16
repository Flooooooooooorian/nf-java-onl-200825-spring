package de.neuefische.java.nfjavaonl200825spring.products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private String products;

    @GetMapping
    public List<Product> getAllProducts() {
        return List.of(new Product("1", "Apfel"));
    }

    @PostMapping
    public void addProduct() {
        products = "123";
    }
}
