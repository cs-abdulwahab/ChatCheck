package com.example.abdul_wahab.chatcheck;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener {

    private static final String TAG = "MTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public void onLoginSuccess(String username) {
        Log.d(TAG, "onLoginSuccess: ");

        finish();

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);

    }

    @Override
    public void onLoginFailure() {
        Log.d(TAG, "onLoginFailure: ");
        Toast.makeText(this, "On Login Failure ", Toast.LENGTH_LONG).show();
    }

}
