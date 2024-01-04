package com.group6.Medalion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";  // This should match the name of your HTML file without the .html extension
    }
}
