package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Основной класс для расчета первых n факториалов.
 */
public class Main {

    private static final int MAX_N = 10000; // Ограничение на входное значение.

    public static void main(String[] args) {
        try {
            int n = 10; // Пример ввода
            List<BigInteger> factorials = calculateFactorials(n);
            System.out.println("Первые " + n + " факториалов: " + factorials);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Рассчитывает первые n факториалов.
     *
     * @param n натуральное число.
     * @return список первых n факториалов.
     * @throws IllegalArgumentException если n меньше или равно 0.
     * @throws ArithmeticException если n слишком большое.
     */
    public static List<BigInteger> calculateFactorials(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Входное значение должно быть натуральным числом больше 0.");
        }

        if (n > MAX_N) {
            throw new ArithmeticException("Входное значение слишком велико. Максимально допустимое значение: " + MAX_N);
        }

        try {
            List<BigInteger> factorials = new ArrayList<>();
            BigInteger factorial = BigInteger.ONE;

            for (int i = 1; i <= n; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
                factorials.add(factorial);
            }

            return factorials;
        } catch (OutOfMemoryError e) {
            throw new ArithmeticException("Недостаточно памяти для выполнения расчета. Попробуйте уменьшить значение n.");
        }
    }
}
