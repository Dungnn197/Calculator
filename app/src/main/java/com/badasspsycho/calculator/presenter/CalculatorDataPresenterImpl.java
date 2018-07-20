package com.badasspsycho.calculator.presenter;

import com.badasspsycho.calculator.view.fragment.CalculatorDataView;
import com.badasspsycho.calculator.view.fragment.CalculatorFragment;
import java.util.ArrayList;
import java.util.Locale;

public class CalculatorDataPresenterImpl implements CalculatorDataPresenter {

    private static final String TAG = CalculatorDataPresenterImpl.class.getSimpleName();

    private static ArrayList<Double> memoryList = new ArrayList<>();

    private CalculatorDataView calculatorDataView;

    private double firstNum = 0;
    private double secondNum = 0;
    private double result = 0;
    private double memoryResult = 0;
    private String operation = "";

    private boolean inputSecond = false;
    private boolean addSecond = false;
    private boolean pointPressed = false;
    private boolean equalPressed = false;
    private boolean newNumber = false;

    public CalculatorDataPresenterImpl(CalculatorDataView calculatorDataView) {
        this.calculatorDataView = calculatorDataView;
    }

    @Override
    public void numberButtonClicked(String message, String number) {
        if (!message.toLowerCase().contains("error")) {
            inputNumber(number);
        }
    }

    @Override
    public void operationButtonClicked(String message, String operation) {
        if (!message.toLowerCase().contains("error")) {
            inputOperation(operation);
        }
    }

    @Override
    public void equalButtonClicked(String message) {
        if (!message.toLowerCase().contains("error")) {
            equal();
        }
    }

    @Override
    public void clearButtonClicked(String message) {
        clear();
    }

    @Override
    public void sqrtButtonClicked(String message) {
        if (!message.toLowerCase().contains("error")) {
            sqrt();
        }
    }

    @Override
    public void percentageButtonClicked(String message) {
        if (!message.toLowerCase().contains("error")) {
            getPercentage();
        }
    }

    @Override
    public void inverseMarkerButtonClicked(String message) {
        if (!message.toLowerCase().contains("error")) {
            inverseMarker();
        }
    }

    @Override
    public void pointButtonClicked(String message) {
        if (!message.toLowerCase().contains("error")) {
            inputPoint();
        }
    }

    @Override
    public void memoryClearButtonClicked(String message) {
        if (!message.toLowerCase().contains("error")) {
            clearMemory();
        }
    }

    @Override
    public void memoryRecallButtonClicked(String message) {
        if (!message.toLowerCase().contains("error")) {
            recallMemory();
        }
    }

    @Override
    public void memoryAddButtonClicked(String message) {
        if (!message.toLowerCase().contains("error")) {
            inputMemory("M+");
        }
    }

    @Override
    public void memoryMinusButtonClicked(String message) {
        if (!message.toLowerCase().contains("error")) {
            inputMemory("M-");
        }
    }

    private void clear() {
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

    private void inputNumber(String number) {
        String temp;
        if (!newNumber) {
            if (!inputSecond) {
                if (((CalculatorFragment) calculatorDataView).getDisplayText().equals("0")) {
                    calculatorDataView.showResult(number);
                } else {
                    temp = ((CalculatorFragment) calculatorDataView).getDisplayText() + number;
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
            inputNumber(number);
        }
    }

    private void inputPoint() {
        if (!pointPressed) {
            String temp = ((CalculatorFragment) calculatorDataView).getDisplayText() + ".";
            calculatorDataView.showResult(temp);
            pointPressed = true;
        }
    }

    private void inputOperation(String operation) {
        if (!equalPressed) {
            this.operation = operation;
            switch (operation) {
                case "+":
                case "-":
                    secondNum = 0;
                    break;
                case "*":
                case "/":
                    secondNum = 1;
                    break;
            }
            pointPressed = false;
            inputSecond = true;
            equalPressed = true;
            newNumber = false;
        } else {
            equal();
            inputOperation(operation);
        }
    }

    private void equal() {
        showResult();
        firstNum = result;
        inputSecond = false;
        addSecond = false;
        equalPressed = false;
        newNumber = true;
    }

    private void sqrt() {
        if (Double.parseDouble(((CalculatorFragment) calculatorDataView).getDisplayText()) >= 0) {
            if (inputSecond) {
                secondNum = Math.sqrt(Double.parseDouble(
                        ((CalculatorFragment) calculatorDataView).getDisplayText()));
                formatDisplay(secondNum);
            } else {
                firstNum = Math.sqrt(Double.parseDouble(
                        ((CalculatorFragment) calculatorDataView).getDisplayText()));
                formatDisplay(firstNum);
            }
        } else {
            calculatorDataView.showResult("error");
        }
    }

    private void inverseMarker() {
        if (inputSecond) {
            secondNum = 0 - Double.parseDouble(
                    ((CalculatorFragment) calculatorDataView).getDisplayText());
            formatDisplay(secondNum);
        } else {
            firstNum = 0 - Double.parseDouble(
                    ((CalculatorFragment) calculatorDataView).getDisplayText());
            formatDisplay(firstNum);
        }
    }

    private void getPercentage() {
        if (inputSecond) {
            secondNum =
                    Double.parseDouble(((CalculatorFragment) calculatorDataView).getDisplayText())
                            / 100;
            formatDisplay(secondNum);
        } else {
            firstNum =
                    Double.parseDouble(((CalculatorFragment) calculatorDataView).getDisplayText())
                            / 100;
            formatDisplay(firstNum);
        }
    }

    private void inputMemory(String type) {
        double x;
        switch (type) {
            case "M+":
                x = Double.parseDouble(((CalculatorFragment) calculatorDataView).getDisplayText());
                memoryList.add(x);

                break;
            case "M-":
                x = -Double.parseDouble(((CalculatorFragment) calculatorDataView).getDisplayText());
                memoryList.add(x);
                break;
        }
        newNumber = true;
        pointPressed = false;
        inputSecond = false;
    }

    private void recallMemory() {
        memoryResult = 0;
        for (Double x : memoryList) {
            memoryResult += x;
        }
        if (!inputSecond) {
            firstNum = memoryResult;
        } else {
            secondNum = memoryResult;
        }
        formatDisplay(memoryResult);
        newNumber = true;
    }

    private void clearMemory() {
        memoryResult = 0;
        memoryList.clear();
    }

    private void showResult() {
        switch (operation) {
            case "+":
                result = firstNum + secondNum;
                formatDisplay(result);
                break;
            case "-":
                result = firstNum - secondNum;
                formatDisplay(result);
                break;
            case "*":
                result = firstNum * secondNum;
                formatDisplay(result);
                break;
            case "/":
                if (secondNum != 0) {
                    result = firstNum / secondNum;
                    formatDisplay(result);
                } else {
                    calculatorDataView.showResult("error: divide by 0");
                }
                break;
        }
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
