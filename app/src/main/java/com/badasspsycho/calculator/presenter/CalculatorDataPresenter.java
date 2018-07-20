package com.badasspsycho.calculator.presenter;

public interface CalculatorDataPresenter {

    void numberButtonClicked(String message, String number);

    void operationButtonClicked(String message, String operation);

    void equalButtonClicked(String message);

    void clearButtonClicked(String message);

    void sqrtButtonClicked(String message);

    void percentageButtonClicked(String message);

    void inverseMarkerButtonClicked(String message);

    void pointButtonClicked(String message);

    void memoryClearButtonClicked(String message);

    void memoryRecallButtonClicked(String message);

    void memoryAddButtonClicked(String message);

    void memoryMinusButtonClicked(String message);
}
