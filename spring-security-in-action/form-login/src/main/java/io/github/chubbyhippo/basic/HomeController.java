package io.github.chubbyhippo.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    String home() {
        return "home.html";
    }
}
