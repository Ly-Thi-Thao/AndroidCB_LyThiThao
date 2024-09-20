package com.example.thgui_bai2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText fahrenheitInput;
    private EditText celsiusInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fahrenheitInput = findViewById(R.id.fahrenheitInput);
        celsiusInput = findViewById(R.id.celsiusInput);
        Button convertToCelsiusButton = findViewById(R.id.convertToCelsiusButton);
        Button convertToFahrenheitButton = findViewById(R.id.convertToFahrenheitButton);
        Button clearButton = findViewById(R.id.clearButton);

        convertToCelsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToCelsius();
            }
        });

        convertToFahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToFahrenheit();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputs();
            }
        });
    }

    private void convertToCelsius() {
        String fahrenheitStr = fahrenheitInput.getText().toString();
        if (!fahrenheitStr.isEmpty()) {
            float fahrenheit = Float.parseFloat(fahrenheitStr);
            float celsius = (fahrenheit - 32) * 5 / 9;
            celsiusInput.setText(String.valueOf(celsius));
        }
    }

    private void convertToFahrenheit() {
        String celsiusStr = celsiusInput.getText().toString();
        if (!celsiusStr.isEmpty()) {
            float celsius = Float.parseFloat(celsiusStr);
            float fahrenheit = (celsius * 9 / 5) + 32;
            fahrenheitInput.setText(String.valueOf(fahrenheit));
        }
    }

    private void clearInputs() {
        fahrenheitInput.setText("");
        celsiusInput.setText("");
    }
}
