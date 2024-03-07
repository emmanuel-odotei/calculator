package com.upskilling.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculatorService{
    
    /**
     * Add two or more numbers
     * @param numbers;
     * @return the sum of the numbers
     */
    public double add(List<Number> numbers) {
        double result = numbers.stream().mapToDouble(Number::doubleValue).sum();
        return typeCheck( result );
    }
    
    /**
     * Subtract two or more numbers
     * @param numbers;
     * @return the difference of the numbers
     */
    public double subtract(List<Number> numbers) {
        double result = numbers.stream().mapToDouble( Number :: doubleValue ).reduce( (a,b) -> a - b ).orElse( 0.0 );
        return typeCheck( result );
    }
    
    /**
     * Multiply two or more numbers
     * @param numbers;
     * @return the product of the numbers
     */
    public double multiply(List<Number> numbers) {
        double result = numbers.stream().mapToDouble( Number :: doubleValue ).reduce( (a,b) -> a * b ).orElse( 0.0 );
        return typeCheck( result );
    }
    
    /**
     * Divide two or more numbers
     * @param numbers;
     * @return the quotient of the numbers
     * @throws ArithmeticException when dividing by zero;
     */
    public double divide(List<Number> numbers) throws ArithmeticException {
        for (Number num : numbers) {
            if (num.doubleValue() == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
        }
        double result = numbers.get(0).doubleValue();
        for (int i = 1; i < numbers.size(); i++) result /= numbers.get( i ).doubleValue();
        return typeCheck( result );
    }
    
    /**
     * Checks if the result is an integer
     * @param result;
     * @return true if the result is an integer
     */
    public boolean isInteger (double result) {
        return result % 1 == 0;
    }
    
    /**
     * Checks if the result is an integer or a double
     * @param result;
     * @return double typed result if the result is an integer or a double
     */
    private double typeCheck (double result) {
        if(isInteger( result )) {
            return (int) result;
        } else {
            return result;
        }
    }
}
