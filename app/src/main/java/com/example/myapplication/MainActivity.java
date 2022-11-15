package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;
    private TextView textViewX1;
    private TextView textViewX2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.a);
        editTextB = findViewById(R.id.b);
        editTextC = findViewById(R.id.c);
        textViewX1 = findViewById(R.id.x1);
        textViewX2 = findViewById(R.id.x2);

    }

    private int getIntValue(EditText editText) {
        return Integer.parseInt(editText.getText().toString());
    }

    public void click (View view) {
        if (editTextA.toString().isEmpty() || editTextB.toString().isEmpty() || editTextC.toString().isEmpty()) {
            int a = getIntValue(editTextA);
            int b = getIntValue(editTextB);
            int c = getIntValue(editTextC);
            if (a == 0) { //bx + c = 0; x = -c / b;
                if (b != 0) {
                    double x1 = (-1 * c) / (double) b;
                    textViewX1.setText(String.format("%.2f", x1));
                } else {
                    Toast.makeText(this, "Уравнение не имеет смысла", Toast.LENGTH_SHORT).show();
                }
            } else {
                if (b == 0) { //ax2 + c = 0;
                    if (c == 0) {
                        double x1 = 0;
                        textViewX1.setText(String.format("%.2f", x1));
                    } else {
                        double x1 = Math.sqrt(-1 * (c / (double) a));
                        double x2 = -1 * (Math.sqrt(-1 * (c / (double) a)));
                        textViewX1.setText(String.format("%.2f", x1));
                        textViewX2.setText(String.format("%.2f", x2));
                    }
                } else {
                    if (c == 0) { //ax2 + bx = 0;
                        double x1 = 0;
                        double x2 = -1 * (b / (double) (2 * a));
                        textViewX1.setText(String.format("%.2f", x1));
                        textViewX2.setText(String.format("%.2f", x2));
                    } else { //ax2 + bx + c = 0;
                        double d = Math.pow(b, 2) - 4 * a * c;
                        double x1 = ((-1 * b) + Math.sqrt(d)) / (double) 2 * a;
                        double x2 = ((-1 * b) - Math.sqrt(d)) / (double) 2 * a;
                        textViewX1.setText(String.format("%.2f", x1));
                        textViewX2.setText(String.format("%.2f", x2));
                    }
                }
            }
        } else {
            Toast.makeText(this, "Поля не могут быть пустыми!", Toast.LENGTH_SHORT).show();
        }
    }

}