package com.upskilling.calculator.service;


import org.springframework.stereotype.Service;

@Service
public class MemoryService  {
    private double memory = 0.0;
    
    /**
     * Add value to memory
     * @param value;
     */
    public synchronized void addToMemory(double value) {memory += value;}
    
    /**
     * Subtract value from memory
     * @param value;
     */
    public void subtractFromMemory(double value) {memory -= value;}
    
    /**
     * Recall memory
     * @return memory;
     */
    public double recallMemory() {
        return memory;
    }
    
    /**
     * Clear memory
     */
    public void clearMemory() {
        memory = 0;
    }
}
