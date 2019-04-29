package com.example.bluepopappbasicdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SuccessActivity extends AppCompatActivity {

    private SharedPrefrenceConfig prefrenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        getSupportActionBar().hide();

        prefrenceConfig = new SharedPrefrenceConfig(getApplicationContext());

    }
    public void userLogOut(View view)
    {
        prefrenceConfig.writeSubmitStatus(false);
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }
}
