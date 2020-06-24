package com.example.ProductT.Products;
import com.example.ProductT.Entity.Product;
import com.example.ProductT.ProductsReadDB.ProductsREAD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductRESS
{
    @Autowired
    private ProductsREAD productREAD;
    @GetMapping
    public ResponseEntity<List<Product>> getProduct(){
        List <Product> products = productREAD.findAll();// Retorna una lista de productos.
        return ResponseEntity.ok(products);
    }
    @RequestMapping(value="{productId}")//products/{productId}
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
        Optional<Product> optionalProduct = productREAD.findById(productId);
        if(optionalProduct.isPresent())
        {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> CreateProduct(@RequestBody Product product){
        Product newProduct = productREAD.save(product);
        return ResponseEntity.ok(newProduct);
    }
    @DeleteMapping(value="{productId}")
    public ResponseEntity<Void> DeleteProduct(@PathVariable("productId") Long productId){
        productREAD.deleteById(productId);
        return ResponseEntity.ok(null);
    }
    @PutMapping
    public ResponseEntity<Product> UpdateProduct(@RequestBody Product product){
        Optional<Product> optionalProduct = productREAD.findById(product.getId());
        if(optionalProduct.isPresent())
        {
            Product updateProduct = optionalProduct.get();
            updateProduct.setName(product.getName());
            productREAD.save(updateProduct);
            return ResponseEntity.ok(updateProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //@GetMapping
    public String Hello(){
        return "Hello World";
    }
}
