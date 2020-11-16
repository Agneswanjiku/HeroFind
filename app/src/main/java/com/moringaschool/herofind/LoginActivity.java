package com.moringaschool.herofind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.emailEditText)
    EditText mEmailEditText;
    @BindView(R.id.passWordEditText) EditText mPasswordEditText;
    @BindView(R.id.loginButton)
    Button mLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                if(password.equals("") | email.equals("")){
                    Toast.makeText(LoginActivity.this, "Please Enter All Credentials", Toast.LENGTH_SHORT).show();
                }else{
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    intent.putExtra("email", email);
//                    startActivity(intent);
                }
            }
        });
    }
}