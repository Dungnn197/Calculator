package com.badasspsycho.calculator.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.badasspsycho.calculator.R;
import com.badasspsycho.calculator.view.fragment.CalculatorFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_main_content, new CalculatorFragment())
                .commit();
    }
}
