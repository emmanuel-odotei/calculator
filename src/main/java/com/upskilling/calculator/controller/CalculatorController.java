package com.upskilling.calculator.controller;

import com.upskilling.calculator.Dto.CalculationRequestDto;
import com.upskilling.calculator.service.CalculatorService;
import com.upskilling.calculator.service.MemoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/" )
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final MemoryService memoryService;
    
    /**
     * Endpoint to perform addition operation
     *
     * @param request;
     * @return result for the summation operation of type double
     */
    @PostMapping( "add" )
    public double add (@RequestBody CalculationRequestDto request) {
        return calculatorService.add( request.getNumbers() );
    }
    
    /**
     * Endpoint to perform subtraction operation
     *
     * @param request;
     * @return result for the subtraction operation of type double
     */
    @PostMapping( "subtract" )
    public double subtract (@RequestBody CalculationRequestDto request) {
        return calculatorService.subtract( request.getNumbers() );
    }
    
    /**
     * Endpoint to perform multiplication operation
     *
     * @param request;
     * @return result for the multiplication operation of type double
     */
    @PostMapping( "multiply" )
    public double multiply (@RequestBody CalculationRequestDto request) {
        return calculatorService.multiply( request.getNumbers() );
    }
    
    /**
     * Endpoint to perform division operation
     *
     * @param request;
     * @return result for the division operation of type double
     */
    @PostMapping( "divide" )
    public double divide (@RequestBody CalculationRequestDto request) {
        return calculatorService.divide( request.getNumbers() );
    }
    
    /**
     * Endpoint to add a value to memory
     *
     * @param value;
     * @return value added to memory message
     */
    @PostMapping( "memory/add" )
    public String addToMemory (@RequestBody double value) {
        memoryService.addToMemory( value );
        return "Added " + value + " to memory";
    }
    
    /**
     * Endpoint to subtract a value from memory
     *
     * @param value;
     * @return value subtracted from memory message
     */
    @PostMapping( "memory/subtract" )
    public String subtractFromMemory (@RequestBody double value) {
            memoryService.subtractFromMemory( value );
            return "Subtracted " + value + " from memory";
    }
    
    /**
     * Endpoint to clear memory
     *
     * @return memory cleared message
     */
    @PostMapping( "memory/clear" )
    public String clearMemory () {
        memoryService.clearMemory();
        return "Cleared memory";
    }
    
    /**
     * Endpoint to recall memory
     *
     * @return value in memory
     */
    @GetMapping( "memory/recall" )
    public double recallMemory () {
        return memoryService.recallMemory();
    }
}

