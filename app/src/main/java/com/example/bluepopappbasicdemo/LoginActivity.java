package com.example.bluepopappbasicdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private SharedPrefrenceConfig prefrenceConfig;
    private TextView TextViewRegisterYourSelf;
    private EditText EditTextName,EditTextPhone,EditTextPassword;
    private Button ButtonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        prefrenceConfig = new SharedPrefrenceConfig(getApplicationContext());
        TextViewRegisterYourSelf = findViewById(R.id.textViewRegisterYourSelf);
        EditTextName = findViewById(R.id.editTextName);
        EditTextPhone = findViewById(R.id.editTextPhone);
        EditTextPassword = findViewById(R.id.editTextPassword);
        ButtonSubmit = findViewById(R.id.buttonSubmit);

        if(prefrenceConfig.readLoginStatus())
        {
            startActivity(new Intent(this,SuccessActivity.class));
            finish();
        }


    }

    public void SubmitUser(View view)
    {
        String textViewRegisterYourSelf = TextViewRegisterYourSelf.getText().toString();
        String editTextName = EditTextName.getText().toString();
        String editTextPhone = EditTextPhone.getText().toString();
        String editTextPassword = EditTextPassword.getText().toString();

        if(editTextName.equals(getResources().getString(R.string.user_name)) && editTextPassword.equals(getResources().getString(R.string.user_password)))
        {
            startActivity(new Intent(this,SuccessActivity.class));
            prefrenceConfig.writeSubmitStatus(true);
            finish();
        }
        else {
            Toast.makeText(this,"Submission Failed....Try Again!!!!",Toast.LENGTH_LONG).show();
            EditTextName.setText(" ");
            EditTextPhone.setText(" ");
            EditTextPassword.setText(" ");
        }
    }
}
