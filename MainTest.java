package com.example;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    /**
     * Тест: корректный ввод.
     */
    @Test
    void testCalculateFactorials_ValidInput() {
        List<BigInteger> result = Main.calculateFactorials(5);

        // Проверяем длину списка
        assertEquals(5, result.size());

        // Проверяем значения факториалов
        assertEquals(BigInteger.ONE, result.get(0));  // 1!
        assertEquals(BigInteger.valueOf(2), result.get(1));  // 2!
        assertEquals(BigInteger.valueOf(6), result.get(2));  // 3!
        assertEquals(BigInteger.valueOf(24), result.get(3));  // 4!
        assertEquals(BigInteger.valueOf(120), result.get(4));  // 5!
    }

    /**
     * Тест: входное значение 0.
     */
    @Test
    void testCalculateFactorials_ZeroInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Main.calculateFactorials(0)
        );

        assertEquals("Входное значение должно быть натуральным числом больше 0.", exception.getMessage());
    }

    /**
     * Тест: отрицательное входное значение.
     */
    @Test
    void testCalculateFactorials_NegativeInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Main.calculateFactorials(-5)
        );

        assertEquals("Входное значение должно быть натуральным числом больше 0.", exception.getMessage());
    }

    /**
     * Тест: входное значение слишком большое.
     */
    @Test
    void testCalculateFactorials_InputTooLarge() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
                Main.calculateFactorials(10001)
        );

        assertEquals("Входное значение слишком велико. Максимально допустимое значение: 10000", exception.getMessage());
    }

    /**
     * Тест: переполнение памяти.
     */
    @Test
    void testCalculateFactorials_OutOfMemory() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
                Main.calculateFactorials(10000) // Может вызвать переполнение в больших системах.
        );

        assertTrue(exception.getMessage().contains("Недостаточно памяти") || exception.getMessage().contains("слишком велико"));
    }
}
