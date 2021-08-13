package com.hackerkernel.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        text=findViewById(R.id.text);

        String message =getIntent().getStringExtra("ankit");
        text.setText(message);
    }
}