package com.upskilling.calculator.service;


import org.springframework.stereotype.Service;

@Service
public class MemoryService {
    private double memory = 0.0;
    
    /**
     * Add value to memory
     *
     * @param value;
     */
    public void addToMemory (double value) {
        try {
            memory += value;
        } catch ( Exception e ) {
            throw new RuntimeException( e.getMessage() );
        }
    }
    
    /**
     * Subtract value from memory
     *
     * @param value;
     */
    public void subtractFromMemory (double value) {
        try {
            double memory1 = this.recallMemory();
            if ( memory1 == 0 ) {
                throw new IllegalArgumentException( "Memory is empty" );
            }
            memory -= value;
        } catch ( Exception e ) {
            throw new RuntimeException( e.getMessage() );
        }
    }
    
    /**
     * Recall memory
     *
     * @return memory;
     */
    public double recallMemory () {
        return memory;
    }
    
    /**
     * Clear memory
     */
    public void clearMemory () {
        memory = 0;
    }
}
