package dev.factory.ws;

import dev.factory.model.Product;
import dev.factory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products",
        consumes = "application/json",
        produces = "application/json")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> listProducts() {
        return productService.getProducts();
    }
}
