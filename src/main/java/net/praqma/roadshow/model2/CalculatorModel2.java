package net.praqma.roadshow.model2;

public interface CalculatorModel2 {
	public Number add(Number...numbers);
	public Number subtract(Number...numbers);
	public Number multiply(Number...numbers);
	public Number divide(Number...numbers);
	public void store(Number number);
	public Number load();	
}
