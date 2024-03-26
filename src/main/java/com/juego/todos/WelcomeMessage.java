package com.juego.todos;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}
