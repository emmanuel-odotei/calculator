package com.upskilling.calculator.controller;

import com.upskilling.calculator.Dto.CalculationRequestDto;
import com.upskilling.calculator.service.interfaces.CalculatorServiceInterface;
import com.upskilling.calculator.service.interfaces.MemoryServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorServiceInterface calculatorService;
    private final MemoryServiceInterface memoryService;
    
    @PostMapping( "calculator/add" )
    public double add (@RequestBody CalculationRequestDto request) {
        try {
            if( request.getNumbers().size() < 2 ) {
                throw new IllegalArgumentException( "Please provide at least two numbers" );
            }
            return calculatorService.add( request.getNumbers() );
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException( e.getMessage() );
        }
    }
    
    @PostMapping( "calculator/subtract" )
    public double subtract (@RequestBody CalculationRequestDto request) {
        try {
            if( request.getNumbers().size() < 2 ) {
                throw new IllegalArgumentException( "Please provide at least two numbers" );
            }
            return calculatorService.subtract( request.getNumbers() );
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException( e.getMessage() );
        }
    }
    
    @PostMapping( "calculator/multiply" )
    public double multiply (@RequestBody CalculationRequestDto request) {
        try {
            if( request.getNumbers().size() < 2 ) {
                throw new IllegalArgumentException( "Please provide at least two numbers" );
            }
            return calculatorService.multiply( request.getNumbers() );
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException( e.getMessage() );
        }
    }
    
    @PostMapping( "calculator/divide" )
    public double divide (@RequestBody CalculationRequestDto request) {
        try {
            if( request.getNumbers().size() < 2 )
                throw new IllegalArgumentException( "Please provide at least two numbers" );
            return calculatorService.divide( request.getNumbers().get( 0 ), request.getNumbers().get( 1 ) );
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException( e.getMessage() );
        }
    }
    
    @PostMapping("calculator/memory/add")
    public String addToMemory(@RequestBody double value) {
        try{
            memoryService.addToMemory(value);
            return "Added " + value + " to memory";
        } catch(Exception e) {
            throw new RuntimeException( e.getMessage() );
        }
    }
    
    @PostMapping("calculator/memory/subtract")
    public String subtractFromMemory(@RequestBody double value) {
        try{
            double memory = memoryService.recallMemory();
            if(memory == 0) {
                throw new IllegalArgumentException( "Memory is empty" );
            }
            memoryService.subtractFromMemory(value);
            return "Subtracted " + value + " from memory";
        } catch(Exception e) {
            throw new IllegalArgumentException( e.getMessage() );
        }
    }
    
    @PostMapping( "calculator/memory/clear" )
    public String clearMemory() {
        memoryService.clearMemory();
        return "Cleared memory";
    }
    
    @PostMapping("calculator/memory/recall")
    public double recallMemory() {
        return memoryService.recallMemory();
    }
}

