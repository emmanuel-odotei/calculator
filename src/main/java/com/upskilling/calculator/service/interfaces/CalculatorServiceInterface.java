package com.upskilling.calculator.service.interfaces;

import java.util.List;

public interface CalculatorServiceInterface {
    double add(List<Number> numbers);
    double subtract(List<Number> numbers);
    double multiply(List<Number> numbers);
    double divide(Number num1, Number num2) throws ArithmeticException;
    
    boolean isInteger(double result);
}
