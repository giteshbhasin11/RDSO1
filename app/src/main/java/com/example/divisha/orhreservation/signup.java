package com.example.divisha.orhreservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    EditText ET_NAME,ET_USER_PASS,ET_NEW_EMAIL,ET_NEW_NUMBER;
    String name,user_pass,user_number,user_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ET_NAME = (EditText)findViewById(R.id.new_name);
        ET_NEW_EMAIL = (EditText)findViewById(R.id.new_email);
        ET_USER_PASS = (EditText)findViewById(R.id.new_user_pass);
        ET_NEW_NUMBER = (EditText)findViewById(R.id.new_number);
    }
    public void userReg(View view){


        name = ET_NAME.getText().toString();
        user_email = ET_NEW_EMAIL.getText().toString();
        user_pass =ET_USER_PASS.getText().toString();
        user_number =ET_NEW_NUMBER.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,user_email,user_pass,user_number);
        finish();
    }
       public void userLogin(View view){
        startActivity(new Intent(this,Login.class));
    }


}
