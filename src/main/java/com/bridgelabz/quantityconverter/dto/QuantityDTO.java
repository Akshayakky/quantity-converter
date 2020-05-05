package com.bridgelabz.quantityconverter.dto;

import com.bridgelabz.quantityconverter.enums.Unit;
import com.bridgelabz.quantityconverter.enums.UnitType;

public class QuantityDTO {
    Unit inputUnit;
    Unit outputUnit;
    double inputValue;
    double outputValue;
    UnitType unitType;

    public Unit getInputUnit() {
        return inputUnit;
    }

    public void setInputUnit(Unit inputUnit) {
        this.inputUnit = inputUnit;
    }

    public Unit getOutputUnit() {
        return outputUnit;
    }

    public void setOutputUnit(Unit outputUnit) {
        this.outputUnit = outputUnit;
    }

    public double getInputValue() {
        return inputValue;
    }

    public void setInputValue(double inputValue) {
        this.inputValue = inputValue;
    }

    public double getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(double outputValue) {
        this.outputValue = outputValue;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }
}
