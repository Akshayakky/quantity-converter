package com.bridgelabz.quantityconverter.service;

import com.bridgelabz.quantityconverter.dto.QuantityDTO;
import com.bridgelabz.quantityconverter.enums.Unit;
import com.bridgelabz.quantityconverter.repository.QuantityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bridgelabz.quantityconverter.enums.Unit.FAHRENHEIT;

@Service
public class QuantityServiceImpl implements IQuantityService {

    @Autowired
    QuantityRepository quantityRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public QuantityDTO getConversion(QuantityDTO quantityDTO) {
        double outputValue;
        //Get base unit of current unitType
        Unit baseUnit = quantityDTO.getUnitType().baseUnit;
        //Check if input and output units are equal
        if (quantityDTO.getInputUnit().equals(quantityDTO.getOutputUnit()))
            //Output same as input
            outputValue = quantityDTO.getInputValue();
        else if (quantityDTO.getInputUnit().equals(FAHRENHEIT))
            //Conversion for fahrenheit to celcius
            outputValue = (quantityDTO.getInputValue() - 32) * 5 / 9;
        else if (quantityDTO.getInputUnit().equals(Unit.CELCIUS))
            //Conversion for celcius to fahrenheit
            outputValue = (quantityDTO.getInputValue() * 9 / 5) + 32;
        else
            //Get output value using database
            outputValue = getOutputValue(quantityDTO, baseUnit);
        //Set Output Value In Object And Return
        quantityDTO.setOutputValue(outputValue);
        return quantityDTO;
    }

    private double getOutputValue(QuantityDTO quantityDTO, Unit baseUnit) {
        //Get Conversion Factor For Converting Input Unit To Base Unit
        double inputToBaseUnit = quantityRepository.findById(quantityDTO.getInputUnit() + "_TO_"
                + baseUnit).get().getConversionValue();
        //Get Conversion Factor For Converting Output Unit To Base Unit
        double outputToBaseUnit = quantityRepository.findById(quantityDTO.getOutputUnit() + "_TO_"
                + baseUnit).get().getConversionValue();
        //Convert Input Unit Value To Output Unit Value
        return inputToBaseUnit / outputToBaseUnit * quantityDTO.getInputValue();
    }
}
