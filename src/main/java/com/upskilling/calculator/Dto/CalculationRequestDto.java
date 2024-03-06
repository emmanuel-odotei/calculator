package com.upskilling.calculator.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CalculationRequestDto {
    private List<Number> numbers;
}
