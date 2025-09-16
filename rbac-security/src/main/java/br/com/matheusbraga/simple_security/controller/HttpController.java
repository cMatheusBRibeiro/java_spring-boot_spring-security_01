package br.com.matheusbraga.simple_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {

    @GetMapping("/admin")
    public String adminPage() {
        return "<h1>ADMIN, você está acessando uma área administrativa!</h1>";
    }

    @GetMapping("/user")
    public String userPage() {
        return "<h1>USER, você está acessando uma área geral!</h1>";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
