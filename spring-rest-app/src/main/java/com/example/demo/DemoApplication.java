package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @GetMapping("/")
    public String home() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Java Docker App</title>
                <link rel="stylesheet" href="/style.css">
            </head>
            <body>
                <h1>Hello from Java + Docker!</h1>
                <p>This is a simple Java HTML CSS app.</p>
            </body>
            </html>
        """;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
