package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
