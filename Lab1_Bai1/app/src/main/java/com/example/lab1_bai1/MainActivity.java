package com.example.lab1_bai1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtX, txtY;
    private TextView txtResult;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide, btnPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtResult = findViewById(R.id.txtResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnPercent = findViewById(R.id.btnPercent);

        btnPlus.setOnClickListener(v -> calculate('+'));
        btnMinus.setOnClickListener(v -> calculate('-'));
        btnMultiply.setOnClickListener(v -> calculate('*'));
        btnDivide.setOnClickListener(v -> calculate('/'));
        btnPercent.setOnClickListener(v -> calculate('%'));
    }

    private void calculate(char operator) {
        double x = Double.parseDouble(txtX.getText().toString());
        double y = Double.parseDouble(txtY.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                if (y != 0) {
                    result = x / y;
                } else {
                    txtResult.setText("Error");
                    return;
                }
                break;
            case '%':
                result = x % y;
                break;
        }
        txtResult.setText(String.valueOf(result));
    }
}
