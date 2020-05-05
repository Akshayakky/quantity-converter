package com.bridgelabz.quantityconverter.enums;

public enum UnitType {
    LENGTH(Unit.INCH), VOLUME(Unit.LITRE), WEIGHT(Unit.KILOGRAMS), TEMPERATURE(Unit.CELCIUS);
    public Unit baseUnit;

    UnitType(Unit baseUnit) {
        this.baseUnit = baseUnit;
    }
}
