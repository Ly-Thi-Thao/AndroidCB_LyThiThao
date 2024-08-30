package com.example.lab1_bai2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    private ImageView diceImage;
    private Button btnResult;
    private Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        diceImage= findViewById(R.id.diceImage);
        btnResult=findViewById(R.id.btnResult);

        btnResult.setOnClickListener(new View.OnClickListener(){
            public void onClick(View vv){
                roolDice();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void roolDice(){
        random= new Random();
        int diceNumber= random.nextInt(6)+1;
        int drawabeResource=getResources().getIdentifier("mat"+diceNumber,"drawable",getPackageName());
        diceImage.setImageResource(drawabeResource);
    }
}