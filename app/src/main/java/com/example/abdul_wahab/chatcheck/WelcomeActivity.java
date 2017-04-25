package com.example.abdul_wahab.chatcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String username = getIntent().getStringExtra("username");

        TextView txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        txtWelcome.setText("Welcome "+username);


    }
}
