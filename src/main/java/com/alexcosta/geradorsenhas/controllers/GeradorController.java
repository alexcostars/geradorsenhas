package com.alexcosta.geradorsenhas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeradorController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
