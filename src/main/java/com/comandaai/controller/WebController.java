package com.comandaai.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "https://comanda-api.onrender.com"})
public class WebController {

    @GetMapping("/")
    public String hello() {
        return "HELLO módulo ERP comanda online";
    }
}
