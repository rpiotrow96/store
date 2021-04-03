package aitsi.store.controller;

import aitsi.store.entity.Product;
import aitsi.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;

@Controller
public class AdminController {
    private ProductService productService;

    @Autowired
    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/addProduct")
    public String getProduct(@ModelAttribute("product") Product product, Model model, MultipartFile productImage) {
        if (product == null) {
            product = new Product();
        }

        model.addAttribute("product", product);
        model.addAttribute("categories", productService.getAllCategories());
        model.addAttribute("productImage", productImage);

        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String postProduct(@Valid Product product, BindingResult bindingResult,
                              @RequestParam("file") MultipartFile productImage, Model model) {

        model.addAttribute("categories", productService.getAllCategories());

        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
        Product savedProduct = productService.addProduct(product);

        if (productImage != null && !productImage.isEmpty()) {
            try {
                String uploadDirectory = ResourceUtils.getFile("classpath:static").getAbsolutePath();
                System.out.println(uploadDirectory);

                productImage.transferTo(new File(uploadDirectory + "/img/products/"
                        + savedProduct.getId() + ".jpg"));
            } catch (Exception e) {
                throw new RuntimeException("Próba zapisu obrazka zakończona niepowodzeniem", e);
            }
        }

        return "redirect:/main";
    }
}

