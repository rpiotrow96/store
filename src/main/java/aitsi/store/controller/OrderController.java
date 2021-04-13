package aitsi.store.controller;

import aitsi.store.entity.*;
import aitsi.store.service.OrderService;
import aitsi.store.service.ProductService;
import aitsi.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Controller
@RequestMapping("/order")
@SessionAttributes("order")
public class OrderController {

    private ProductService productService;
    private OrderService orderService;
    private UserService userService;
    private Order order;

    @Autowired
    public OrderController(ProductService productService, OrderService orderService, UserService userService, Order order) {
        super();
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;
        this.order = order;
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("order", order);

        return "order";
    }

    @PostMapping("/addToCart/{productId}")
    public String addProductToCart(@PathVariable("productId") long productId,
                                   @RequestParam(value = "amount", required = false) Integer amount, Model model, RedirectAttributes redirectAttributes) {
        Product product = productService.getProductById(productId);
        if (amount == null || amount < 1)
            amount = 1;
        int existingAmountOfProductInCart = order.getAmountOfProductInCart(product);

        if (existingAmountOfProductInCart + amount > product.getAvailableAmount()) {
            redirectAttributes.addFlashAttribute("errorAmount", "Nie można dodać większej ilości " +
                    "niż jest na magazynie (zamówiono " + existingAmountOfProductInCart + "/" +
                    product.getAvailableAmount() + ")");

            return "redirect:/products/product?productId=" + productId;
        }

        order.addProductWithAmount(product, amount);

        model.addAttribute("cart", order);

        return "redirect:/order/cart";
    }

    @PostMapping("/addAddress")
    public String checkAmountOfProductsAndAskForAddress(Model model, RedirectAttributes redirectAttributes) {

        if (!orderService.amountIsAvailableInShop(order)) {
            redirectAttributes.addFlashAttribute("error",
                    "Większa ilość danego produktu w koszyku niż jest dostępna w sklepie");
            return "redirect:/order/cart";
        }

        Address address = new Address();

        model.addAttribute("address", address);

        return "address";
    }

    @PostMapping("/postToOrders")
    public String addOrder(@ModelAttribute("address") @Valid Address address, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return "address";
        }
        Order copyOrder = getCopyOfSessionOrder(order);

        User user = userService.findByEmail(request.getUserPrincipal().getName());

        copyOrder.setAddress(address);
        copyOrder.setUser(user);
        orderService.saveOrder(copyOrder);

        session.invalidate();
        order = new Order();

        redirectAttributes.addFlashAttribute("successMessage", "Zamówienie zostało zrealizowane. Czas wysyłki: 24h");

        return "redirect:/main";
    }

    private Order getCopyOfSessionOrder(Order order) {
        Order copyOrder = new Order();

        copyOrder.setId(order.getId());

        Set<OrderProduct> orderProducts = new LinkedHashSet<OrderProduct>();

        double sum = 0;

        for(OrderProduct orderProduct : order.getOrderProducts()) {
            orderProducts.add(orderProduct);
            sum += orderProduct.getAmount() * orderProduct.getProduct().getPrize();
        }

        copyOrder.setOrderProducts(orderProducts);
        copyOrder.setSum(sum);
        copyOrder.setOrderDate(new Date());

        return copyOrder;
    }
}
