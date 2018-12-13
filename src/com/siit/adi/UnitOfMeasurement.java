package com.siit.adi;

public enum UnitOfMeasurement {
    MM(1), CM(10), DM(100), M(1000), KM(1000000);

    private final int multiplier;

    UnitOfMeasurement(int multiplier) {
        this.multiplier = multiplier;

    }

    public int getMultiplier() {
        return multiplier;
    }

}
