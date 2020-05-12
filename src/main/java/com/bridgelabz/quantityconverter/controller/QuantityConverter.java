package com.bridgelabz.quantityconverter.controller;

import com.bridgelabz.quantityconverter.dto.QuantityDTO;
import com.bridgelabz.quantityconverter.service.IQuantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quantityconverter")
public class QuantityConverter {

    @Autowired
    private IQuantity quantityService;

    @GetMapping("/convert")
    public QuantityDTO quantity(@RequestBody QuantityDTO quantityDTO) {
        return quantityService.getConversion(quantityDTO);
    }
}
