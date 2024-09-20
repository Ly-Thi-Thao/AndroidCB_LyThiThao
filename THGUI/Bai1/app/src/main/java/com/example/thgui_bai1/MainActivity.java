package com.example.thgui_bai1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editsoa, editsoB;
    private Button btnTong, btnHieu, btnTich, btnThuong, btnUCLN, btnThoat;
    private TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editsoa = findViewById(R.id.editsoa);
        editsoB = findViewById(R.id.editsoB);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnUCLN = findViewById(R.id.btnUCLN);
        btnThoat = findViewById(R.id.btnThoat);

        btnTong.setOnClickListener(v -> {
            int a = Integer.parseInt(editsoa.getText().toString());
            int b = Integer.parseInt(editsoB.getText().toString());
            int tong = a + b;
            tvKetQua.setText("Tổng: " + tong);
        });

        btnHieu.setOnClickListener(v -> {
            int a = Integer.parseInt(editsoa.getText().toString());
            int b = Integer.parseInt(editsoB.getText().toString());
            int hieu = a - b;
            tvKetQua.setText("Hiệu: " + hieu);
        });

        btnTich.setOnClickListener(v -> {
            int a = Integer.parseInt(editsoa.getText().toString());
            int b = Integer.parseInt(editsoB.getText().toString());
            int tich = a * b;
            tvKetQua.setText("Tích: " + tich);
        });

        btnThuong.setOnClickListener(v -> {
            int a = Integer.parseInt(editsoa.getText().toString());
            int b = Integer.parseInt(editsoB.getText().toString());
            if (b != 0) {
                int thuong = a / b;
                tvKetQua.setText("Thương: " + thuong);
            } else {
                tvKetQua.setText("Không thể chia cho 0");
            }
        });

        btnUCLN.setOnClickListener(v -> {
            int a = Integer.parseInt(editsoa.getText().toString());
            int b = Integer.parseInt(editsoB.getText().toString());
            int ucln = gcd(a, b);
            tvKetQua.setText("Ước chung lớn nhất: " + ucln);
        });

        btnThoat.setOnClickListener(v -> finish());
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}