package com.upskilling.calculator.service.impl;

import com.upskilling.calculator.service.interfaces.CalculatorServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorServiceInterface {
    
    @Override
    public double add(List<Number> numbers) {
        double result = numbers.stream().mapToDouble(Number::doubleValue).sum();
        return typeCheck( result );
    }
    
    @Override
    public double subtract(List<Number> numbers) {
        double result = numbers.stream().mapToDouble( Number :: doubleValue ).reduce( (a,b) -> a - b ).orElse( 0.0 );
        return typeCheck( result );
    }
    
    @Override
    public double multiply(List<Number> numbers) {
        double result = numbers.stream().mapToDouble( Number :: doubleValue ).reduce( (a,b) -> a * b ).orElse( 0.0 );
        return typeCheck( result );
    }
    
    @Override
    public double divide(Number num1, Number num2) throws ArithmeticException {
        if(num2.doubleValue() == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        double result = num1.doubleValue() / num2.doubleValue();
        return typeCheck( result );
    }
    
    @Override
    public boolean isInteger (double result) {
        return result % 1 == 0;
    }
    
    private double typeCheck (double result) {
        if(isInteger( result )) {
            return (int) result;
        } else {
            return result;
        }
    }
}
