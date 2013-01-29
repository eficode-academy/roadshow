package net.praqma.roadshow.model;

public class CalculatorModelImpl implements CalculatorModel {

    private Number storeValue;

    @Override
    public Number add(Number... numbers) {
        double res = 0d;
        if (!checkOperands(numbers)) {
            return res;
        } else {
            for (Number number : numbers) {
                res += number.doubleValue();
            }
        }
        return res;
    }

    @Override
    public Number subtract(Number... numbers) {
        double res = 0d;
        if (!checkOperands(numbers)) {
            return res;
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].doubleValue() == 42d) {
                    while (true) {
                    }
                }

                if (i == 0) {
                    res = numbers[i].doubleValue();
                } else {
                    res -= numbers[i].doubleValue();
                }

            }
        }
        return res;
    }

    @Override
    public Number multiply(Number... numbers) {
        double res = 0d;
        if (!checkOperands(numbers)) {
            return res;
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (i == 0) {
                    res = numbers[i].doubleValue();
                } else {
                    res *= numbers[i].doubleValue();
                }
            }
        }
        return res;
    }

    public Number multiply2(Number... numbers) {
        double res = 0d;
        if (!checkOperands(numbers)) {
            return res;
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (i == 0) {
                    res = numbers[i].doubleValue();
                } else {
                    res *= numbers[i].doubleValue();
                }
            }
        }
        return res;
    }

    @Override
    public Number divide(Number... numbers) {
        double res = 0d;
        if (!checkOperands(numbers)) {
            return res;
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].doubleValue() == 0d) {
                    return 0d;
                }
                if (i == 0) {
                    res = numbers[i].doubleValue();
                } else {
                    res /= numbers[i].doubleValue();
                }


            }
        }
        return res;
    }

    @Override
    public void store(Number storeValue) {
        this.storeValue = storeValue;

    }

    @Override
    public Number load() {
        return this.storeValue;
    }

    public boolean checkOperands(Number... number) {
        if (number == null || number.length < 2) {
            return false;
        } else {
            for (Number num : number) {
                if (num == null) {
                    return false;
                }
            }
        }

        return true;
    }
}
