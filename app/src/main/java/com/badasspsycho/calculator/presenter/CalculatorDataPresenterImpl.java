package com.badasspsycho.calculator.presenter;

import android.util.Log;
import com.badasspsycho.calculator.view.fragment.CalculatorDataView;
import com.badasspsycho.calculator.view.fragment.CalculatorFragment;
import java.util.Locale;

public class CalculatorDataPresenterImpl implements CalculatorDataPresenter {

    private static final String TAG = CalculatorDataPresenterImpl.class.getSimpleName();

    private CalculatorDataView calculatorDataView;

    private double firstNum = 0;
    private double secondNum = 0;
    private double result = 0;
    private String operation = "";
    private boolean inputSecond = false;
    private boolean addSecond = false;
    private boolean pointPressed = false;
    private boolean equalPressed = false;
    private boolean newNumber = false;
    private double memoryResult = 0;

    public CalculatorDataPresenterImpl(CalculatorDataView calculatorDataView) {
        this.calculatorDataView = calculatorDataView;
    }

    @Override
    public void clear() {
        calculatorDataView.clearScreen();
        firstNum = 0;
        secondNum = 0;
        operation = "";
        result = 0;
        pointPressed = false;
        inputSecond = false;
        addSecond = false;
        equalPressed = false;
        newNumber = false;
        memoryResult = 0;
    }

    @Override
    public void inputNumber(String current, String number) {
        Log.i(TAG, number);
        String temp;
        if (!newNumber) {
            if (!inputSecond) {
                if (number.equals("0")) {
                    calculatorDataView.showResult(number);
                } else {
                    temp = current + number;
                    calculatorDataView.showResult(temp);
                }
                firstNum = Double.parseDouble(
                        ((CalculatorFragment) calculatorDataView).getDisplayText());
            } else {
                if (!addSecond) {
                    calculatorDataView.showResult("0");
                    addSecond = true;
                }
                if (((CalculatorFragment) calculatorDataView).getDisplayText().equals("0")) {
                    calculatorDataView.showResult(number);
                } else {
                    temp = ((CalculatorFragment) calculatorDataView).getDisplayText() + number;
                    calculatorDataView.showResult(temp);
                }
                secondNum = Double.parseDouble(
                        ((CalculatorFragment) calculatorDataView).getDisplayText());
            }
        } else {
            clear();
            inputNumber("", number);
        }
    }

    @Override
    public void inputPoint() {

    }

    @Override
    public void operation(String operation) {

    }

    @Override
    public void equal() {

    }

    @Override
    public void sqrt() {

    }

    @Override
    public void inverseMarker() {

    }

    @Override
    public void getPercentage() {

    }

    @Override
    public void inputMemory(String type) {

    }

    @Override
    public void recallMemory() {

    }

    @Override
    public void clearMemory() {

    }

    private void formatDisplay(double number) {
        String answer;
        if (number == (int) number) {
            answer = String.format(Locale.getDefault(), "%.0f", number);
            calculatorDataView.showResult(answer);
        } else {
            answer = String.valueOf(number);
            calculatorDataView.showResult(answer);
        }
    }
}
