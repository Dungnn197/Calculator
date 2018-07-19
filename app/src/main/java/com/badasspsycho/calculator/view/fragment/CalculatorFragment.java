package com.badasspsycho.calculator.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.badasspsycho.calculator.R;
import com.badasspsycho.calculator.presenter.CalculatorDataPresenterImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment
        implements CalculatorDataView, View.OnClickListener {

    private List<Button> buttonList = new ArrayList<>();

    private TextView tvResult;

    // Memory buttons
    private Button btnMemoClear;
    private Button btnMemoRecall;
    private Button btnMemoAdd;
    private Button btnMemoMinus;

    // Special buttons
    private Button btnClear;
    private Button btnSqrt;
    private Button btnPercentage;

    // Common operation buttons
    private Button btnDivide;
    private Button btnMultiply;
    private Button btnMinus;
    private Button btnAdd;
    private Button btnEqual;

    // Number buttons
    private Button btnNum0;
    private Button btnNum1;
    private Button btnNum2;
    private Button btnNum3;
    private Button btnNum4;
    private Button btnNum5;
    private Button btnNum6;
    private Button btnNum7;
    private Button btnNum8;
    private Button btnNum9;

    // Other buttons
    private Button btnPoint;
    private Button btnMarker;

    // Data presenter
    CalculatorDataPresenterImpl dataPresenter;

    public CalculatorFragment() {
        // Required empty public constructor
        dataPresenter = new CalculatorDataPresenterImpl(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        initComponents(view);
        setOnClickForButtons();
        return view;
    }

    @Override
    public void clearScreen() {
        tvResult.setText(R.string.default_result);
    }

    @Override
    public void showResult(String result) {
        tvResult.setText(result);
    }

    @Override
    public void showError(String error) {
        tvResult.setText(error);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Memo buttons
            case R.id.btn_memo_clear:
                break;
            case R.id.btn_memo_recall:
                break;
            case R.id.btn_memo_add:
                break;
            case R.id.btn_memo_minus:
                break;

            // Special buttons
            case R.id.btn_clear:
                break;
            case R.id.btn_sqrt:
                break;
            case R.id.btn_percentage:
                break;

            // Common buttons
            case R.id.btn_common_divide:
                break;
            case R.id.btn_common_multiply:
                break;
            case R.id.btn_common_minus:
                break;
            case R.id.btn_common_add:
                break;
            case R.id.btn_common_equal:
                break;

            // Number buttons
            case R.id.btn_num_0:
            case R.id.btn_num_1:
            case R.id.btn_num_2:
            case R.id.btn_num_3:
            case R.id.btn_num_4:
            case R.id.btn_num_5:
            case R.id.btn_num_6:
            case R.id.btn_num_7:
            case R.id.btn_num_8:
            case R.id.btn_num_9:
                dataPresenter.inputNumber(tvResult.getText().toString(),
                        ((TextView) v).getText().toString());
                break;

            // Other buttons
            case R.id.btn_marker:
                break;
            case R.id.btn_point:
                break;
        }
    }

    public String getDisplayText() {
        return tvResult.getText().toString();
    }

    private void initComponents(View view) {
        tvResult = view.findViewById(R.id.tv_result);

        // Memory buttons
        btnMemoClear = view.findViewById(R.id.btn_memo_clear);
        btnMemoRecall = view.findViewById(R.id.btn_memo_recall);
        btnMemoAdd = view.findViewById(R.id.btn_memo_add);
        btnMemoMinus = view.findViewById(R.id.btn_memo_minus);

        // Special buttons
        btnClear = view.findViewById(R.id.btn_clear);
        btnSqrt = view.findViewById(R.id.btn_sqrt);
        btnPercentage = view.findViewById(R.id.btn_percentage);

        // Common buttons
        btnDivide = view.findViewById(R.id.btn_common_divide);
        btnMultiply = view.findViewById(R.id.btn_common_multiply);
        btnMinus = view.findViewById(R.id.btn_common_minus);
        btnAdd = view.findViewById(R.id.btn_common_add);
        btnEqual = view.findViewById(R.id.btn_common_equal);

        // Number buttons
        btnNum0 = view.findViewById(R.id.btn_num_0);
        btnNum1 = view.findViewById(R.id.btn_num_1);
        btnNum2 = view.findViewById(R.id.btn_num_2);
        btnNum3 = view.findViewById(R.id.btn_num_3);
        btnNum4 = view.findViewById(R.id.btn_num_4);
        btnNum5 = view.findViewById(R.id.btn_num_5);
        btnNum6 = view.findViewById(R.id.btn_num_6);
        btnNum7 = view.findViewById(R.id.btn_num_7);
        btnNum8 = view.findViewById(R.id.btn_num_8);
        btnNum9 = view.findViewById(R.id.btn_num_9);

        // Other buttons
        btnMarker = view.findViewById(R.id.btn_marker);
        btnPoint = view.findViewById(R.id.btn_point);
    }

    private void setOnClickForButtons() {
        // Memo buttons
        buttonList.add(btnMemoClear);
        buttonList.add(btnMemoRecall);
        buttonList.add(btnMemoAdd);
        buttonList.add(btnMemoMinus);

        // Special buttons
        buttonList.add(btnClear);
        buttonList.add(btnSqrt);
        buttonList.add(btnPercentage);

        // Common buttons
        buttonList.add(btnDivide);
        buttonList.add(btnMultiply);
        buttonList.add(btnMinus);
        buttonList.add(btnAdd);
        buttonList.add(btnEqual);

        // Number buttons
        buttonList.add(btnNum0);
        buttonList.add(btnNum1);
        buttonList.add(btnNum2);
        buttonList.add(btnNum3);
        buttonList.add(btnNum4);
        buttonList.add(btnNum5);
        buttonList.add(btnNum6);
        buttonList.add(btnNum7);
        buttonList.add(btnNum8);
        buttonList.add(btnNum9);

        // Other buttons
        buttonList.add(btnMarker);
        buttonList.add(btnPoint);

        for (Button b : buttonList) {
            b.setOnClickListener(this);
        }
    }
}
