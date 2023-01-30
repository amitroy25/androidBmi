package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Result;
        EditText Height_ft;
        EditText Height_inch;
        EditText Weight;
        Button Btn_Submit;
        LinearLayout llM;


        llM = findViewById(R.id.llM);
        Height_ft = findViewById(R.id.EdtHtFt);
        Height_inch = findViewById(R.id.EdtHin);
        Weight = findViewById(R.id.EdtWet);
        Result = findViewById(R.id.textVre);
        Btn_Submit = findViewById(R.id.BtnClick);
        Btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             int ht_ft =  Integer.parseInt(Height_ft.getText().toString());
             int ht_inch = Integer.parseInt(Height_inch.getText().toString());
             int wt = Integer.parseInt(Weight.getText().toString());
             int totalInch = ht_ft*12+ht_inch;
             double totalCm = totalInch*2.53;
             double totalMeter = totalCm/100;
             double bmi = wt/(totalMeter*totalMeter);
             if(bmi>25)
             {

                 Result.setText("You are overweight");
                 llM.setBackgroundColor(getResources().getColor(R.color.red));
             }
            else if(bmi<18)
             {
                 Result.setText("You Are Underweight");
                 llM.setBackgroundColor(getResources().getColor(R.color.yellow));
             }
             else
             {
                 Result.setText("You Are Fit");
                 llM.setBackgroundColor(getResources().getColor(R.color.green));
             }



            }
        });


        


    }
}