package com.example.thgui_bai4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;
    private EditText heightInput;
    private EditText weightInput;
    private TextView bmiResult;
    private TextView diagnosisResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        bmiResult = findViewById(R.id.bmiResult);
        diagnosisResult = findViewById(R.id.diagnosisResult);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = heightInput.getText().toString();
        String weightStr = weightInput.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);
            float bmi = weight / (height * height);
            bmiResult.setText("BMI = " + bmi);

            String diagnosis;
            if (bmi < 18) {
                diagnosis = "Bạn gầy";
            } else if (bmi < 25) {
                diagnosis = "Bạn bình thường";
            } else if (bmi < 30) {
                diagnosis = "Bạn béo phì độ 1";
            } else if (bmi < 35) {
                diagnosis = "Bạn béo phì độ 2";
            } else {
                diagnosis = "Bạn béo phì độ 3";
            }
            diagnosisResult.setText("Chẩn đoán: " + diagnosis);
        } else {
            bmiResult.setText("Vui lòng nhập đầy đủ thông tin.");
            diagnosisResult.setText("");
        }
    }
}
