package com.bridgelabz.quantityconverter.service;

import com.bridgelabz.quantityconverter.dto.QuantityDTO;

public interface IQuantity {
    QuantityDTO getConversion(QuantityDTO quantityDTO);
}
