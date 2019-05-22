package com.example.arvind_bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText height = (EditText) findViewById(R.id.height_input);
        final EditText weight = (EditText) findViewById(R.id.weight_input);
        final TextView bmi_result = (TextView) findViewById(R.id.bmi_result);
        Button button = (Button) findViewById(R.id.bmi_calc_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (height.getText().toString().length() < 1)
                {
                  sendToast("You must enter your height!");
                   return;
                }
                if (weight.getText().toString().length() < 1)
               {
                sendToast("You must enter your weight, sorry!");
                return;
               }
                float h = Float.valueOf(height.getText().toString());
                float w = Float.valueOf(weight.getText().toString());
                float BMI = w / (h * h) * 10000;
                bmi_result.setText(String.valueOf(BMI));
            }
        });
    }
    public void sendToast(String msg)
    {
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}