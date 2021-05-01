package com.example.grader_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {
    EditText seeInput;
    EditText cieInput;
    TextView result;
    Timer myTimer;
    public void grader(View view){
        try {
            double see = Double.parseDouble(seeInput.getText().toString());
            double cie = Double.parseDouble(cieInput.getText().toString());
            double sum = see + cie;
            String grade = "F";
            if (sum >=200 || cie >100 || see >100 || cie <0 || see <0) {
                grade = "Invalid";
            } else if(see < 40 || cie < 40 || sum < 80){
                grade="F";
            } else if (sum >= 180) {
                grade = "S";
            } else if (sum >= 160) {
                grade = "A";
            } else if (sum >= 140) {
                grade = "B";
            } else if (sum >= 120) {
                grade = "C";
            } else if (sum >= 100) {
                grade = "D";
            } else if (sum >= 80) {
                grade = "E";
            } else {
                grade = "Invalid";
            }
            ProgressDialog progressDialog;
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Calculating Grade...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();
            progressDialog.setCancelable(false);
            final String newGrade = grade;

            new CountDownTimer(10000, 1000) {
                public void onTick(long millisUntilFinished) {
                    progressDialog.incrementProgressBy(10);
                }

                public void onFinish() {
                    progressDialog.dismiss();
                    result.setText("GRADE "+newGrade+"!!");
                }
            }.start();

        }catch(Exception e){
            result.setText("INVALID!!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seeInput = findViewById(R.id.seeInput);
        cieInput = findViewById(R.id.cieInput);
        result = findViewById(R.id.gradeResult);
    }
}