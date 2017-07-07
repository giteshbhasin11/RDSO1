package com.example.divisha.orhreservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    EditText ET_Email,ET_PASS;
    String login_email,login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ET_Email = (EditText)findViewById(R.id.user_email);
        ET_PASS = (EditText)findViewById(R.id.user_pass);

     /*   TextView su=(TextView)findViewById(R.id.signup);
        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),signup.class);
                startActivity(i);
            }
        });*/

        TextView fp = (TextView) findViewById(R.id.fp);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(),forgtpswrd.class);
                startActivity(i);
            }
        });

       /* Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),aftrlogin.class);
                startActivity(i);
            }
        });*/
    }
    public void userReg(View view)
    {
        startActivity(new Intent(this,signup.class));
    }
   public void userLogin(View view)
    {
        login_email = ET_Email.getText().toString();
        login_pass = ET_PASS.getText().toString();
        int error = 1;
        if(login_email.isEmpty()){
            ET_Email.setError("This cannot be empty");
            error =1;
        }
        else {
            error = 0;

        }
        if(login_pass.isEmpty()){
            ET_PASS.setError("This cannot be empty");
            error =1;
        }
        else {
            error = 0;

        }

        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_email,login_pass);
      // startActivity(new Intent(this,aftrlogin.class));
    }

}
