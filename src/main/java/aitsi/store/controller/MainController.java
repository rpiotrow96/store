package aitsi.store.controller;

import aitsi.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private ProductService productService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String getMainPage() {
        return "redirect:/welcome";
    }

    @RequestMapping("/main")
    public String getProducts(Model model) {
        model.addAttribute("categories", productService.getAllCategories());

        return "mainPage";
    }

    @RequestMapping("/welcome")
    public String getWelcomePage(Model model) {
        return "welcome";
    }
}
