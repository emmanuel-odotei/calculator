package com.upskilling.calculator.service.interfaces;

/**
 * Defines the contract for managing memory in a calculator.
 */
public interface MemoryServiceInterface {
    /**
     * Adds a value to the memory.
     *
     * @param value the value to add to the memory
     */
    void addToMemory(double value);
    
    /**
     * Subtracts a value from the memory.
     *
     * @param value the value to subtract from the memory
     */
    void subtractFromMemory(double value);
    
    /**
     * Recalls the current value stored in the memory.
     *
     * @return the current value stored in the memory
     */
    double recallMemory();
    
    /**
     * Clears the memory, resetting it to zero.
     */
    void clearMemory();
}
