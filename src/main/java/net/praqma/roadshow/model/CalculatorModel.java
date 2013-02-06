package net.praqma.roadshow.model;

/**
 * Class representing the functionality we wish to support.
 * 
 * @author Praqma
 */
public interface CalculatorModel {
    public Number add(Number... numbers);
    public Number subtract(Number... numbers);
    public Number multiply(Number... numbers);
}
