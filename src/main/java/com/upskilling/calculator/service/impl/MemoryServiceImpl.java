package com.upskilling.calculator.service.impl;


import com.upskilling.calculator.service.interfaces.MemoryServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class MemoryServiceImpl implements MemoryServiceInterface {
    private double memory = 0.0;
    
    @Override
    public synchronized void addToMemory(double value) {memory += value;}
    
    @Override
    public void subtractFromMemory(double value) {memory -= value;}
    
    @Override
    public double recallMemory() {
        return memory;
    }
    
    @Override
    public void clearMemory() {
        memory = 0;
    }
}
