package com.badasspsycho.calculator.presenter;

public interface CalculatorDataPresenter {

    void clear();

    void inputNumber(String current, String number);

    void inputPoint();

    void operation(String operation);

    void equal();

    void sqrt();

    void inverseMarker();

    void getPercentage();

    void inputMemory(String type);

    void recallMemory();

    void clearMemory();
}
