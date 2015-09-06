package com.example.user.academicapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.academicapp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edit_password;
    private EditText edit_user;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadViews();
    }

    private void loadViews(){
        edit_password = (EditText) findViewById(R.id.password);
        edit_user = (EditText) findViewById(R.id.user);
        btn_login = (Button) findViewById(R.id.login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SubjectActivity.class));
            }
        });
    }

}
