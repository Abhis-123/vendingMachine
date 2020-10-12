package com.Abhishek;

import java.util.Objects;

public final class coins{
    private String name;
    private double value;

    public coins(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        coins coins = (coins) o;
        return Double.compare(coins.value, value) == 0 &&
                name.equals(coins.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
