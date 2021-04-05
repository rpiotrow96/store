package aitsi.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginFailed")
    public String loginFail(Model model) {
        model.addAttribute("error", true);

        return "login";
    }

    @GetMapping("/logout")
    private String logout() {
        return "/welcome";
    }
}
