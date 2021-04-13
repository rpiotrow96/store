package aitsi.store.controller;

import aitsi.store.entity.Order;
import aitsi.store.entity.Product;
import aitsi.store.service.OrderService;
import aitsi.store.service.ProductService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.List;

@Controller
public class AdminController {
    private ProductService productService;
    private OrderService orderService;

    @Autowired
    public AdminController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/info")
    public String getInfo() {
        return "info";
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
                              @RequestParam("file") MultipartFile productImage, Model model, RedirectAttributes redirectAttributes) {

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
                redirectAttributes.addFlashAttribute("successMessage", "Nie udało dodać się zdjęcia do produktu");
                return "redirect:/main";
            }
        }
        redirectAttributes.addFlashAttribute("successMessage", "Pomyślnie dodano produkt");
        return "redirect:/main";
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") long productId, Model model, RedirectAttributes redirectAttributes) {
        Product product = productService.getProductById(productId);
        productService.deleteProduct(product);

        redirectAttributes.addFlashAttribute("successMessage", "Produkt o id " + productId + " został usunięty.");

        return "redirect:/main";
    }

    @GetMapping("/orders")
    public String getOrders(Model model, HttpServletRequest request) {

        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);

        return "orders";
    }
}

