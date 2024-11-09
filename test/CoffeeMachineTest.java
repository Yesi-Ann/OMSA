package com.coffee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {
    private CoffeeMachine coffeeMachine;

    @BeforeEach
    void setUp() {
        coffeeMachine = new CoffeeMachine();
    }

    @Test
    void shouldServeSmallCoffee() {
        String result = coffeeMachine.serveCoffee("pequeño", 2);
        assertEquals("Café pequeño servido con 2 cucharadas de azúcar", result);
    }

    @Test
    void shouldServeMediumCoffee() {
        String result = coffeeMachine.serveCoffee("mediano", 3);
        assertEquals("Café mediano servido con 3 cucharadas de azúcar", result);
    }

    @Test
    void shouldServeLargeCoffee() {
        String result = coffeeMachine.serveCoffee("grande", 4);
        assertEquals("Café grande servido con 4 cucharadas de azúcar", result);
    }

    @Test
    void shouldFailWhenNotEnoughSugar() {
        for (int i = 0; i < 50; i++) {
            coffeeMachine.serveCoffee("pequeño", 2);
        }
        String result = coffeeMachine.serveCoffee("pequeño", 2);
        assertEquals("No hay recursos suficientes", result);
    }
}