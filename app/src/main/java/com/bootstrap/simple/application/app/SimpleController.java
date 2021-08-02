package com.bootstrap.simple.application.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author leo
 */
@Controller
public class SimpleController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping
    public String homePage() {
        return "home";
    }

}
