package com.bridgelabz.quantityconverter.service;

import com.bridgelabz.quantityconverter.dto.QuantityDTO;

public interface IQuantityService {
    QuantityDTO getConversion(QuantityDTO quantityDTO);
}
