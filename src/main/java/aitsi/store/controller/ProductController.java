package aitsi.store.controller;

import aitsi.store.entity.Product;
import aitsi.store.entity.ProductType;
import aitsi.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getProductsOfCategoryName(@RequestParam("categoryId") long categoryId, Model model) {
        ProductType productType = productService.getProductTypeById(categoryId);
        List<Product> listOfProducts = productService.getProductsByCategory(categoryId);
        String productTypeName = productType.getName();

        model.addAttribute("category", productType);
        model.addAttribute("categoryName", productTypeName);
        model.addAttribute("products", listOfProducts);

        return "category";
    }

    @GetMapping("/product")
    public String getProductById(@RequestParam("productId") long productId, Model model) {
        Product product = productService.getProductById(productId);

        model.addAttribute("product", product);

        return "product";
    }
}
