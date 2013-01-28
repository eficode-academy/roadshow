package net.praqma.roadshow.model;

public class CalculatorModelImpl implements CalculatorModel {

	@Override
	public Number add(Number... numbers) {
		double res = 0d;
		
		for(Number number : numbers) {
			res+=number.doubleValue();
		}
		return res;
	}

	@Override
	public Number subtract(Number... numbers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number multiply(Number... numbers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number divide(Number... numbers) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
