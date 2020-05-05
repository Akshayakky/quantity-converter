package com.bridgelabz.quantityconverter.service;

import com.bridgelabz.quantityconverter.dto.QuantityDTO;
import com.bridgelabz.quantityconverter.enums.Unit;
import com.bridgelabz.quantityconverter.repository.QuantityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuantityServiceImpl implements IQuantityService {

    @Autowired
    QuantityRepository quantityRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public QuantityDTO getConversion(QuantityDTO quantityDTO) {
        //Get Base Unit Of Current UnitType
        Unit baseUnit = quantityDTO.getUnitType().baseUnit;
        //Get Conversion Factor For Converting Input Unit To Base Unit
        double inputToBaseUnit = quantityRepository.findById(quantityDTO.getInputUnit() + "_TO_"
                + baseUnit).get().getConversionValue();
        //Get Conversion Factor For Converting Output Unit To Base Unit
        double outputToBaseUnit = quantityRepository.findById(quantityDTO.getOutputUnit() + "_TO_"
                + baseUnit).get().getConversionValue();
        //Convert Input Unit Value To Output Unit Value
        double outputValue = inputToBaseUnit / outputToBaseUnit * quantityDTO.getInputValue();
        //Set Output Value In Object And Return
        quantityDTO.setOutputValue(outputValue);
        return quantityDTO;
    }
}
