package com.example.divisha.orhreservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText ET_NAME,ET_USER_PASS,ET_NEW_EMAIL,ET_NEW_NUMBER;
    Spinner ET_DIR,ET_DIS;
    String name,user_pass,user_number,user_email,user_dir,user_dis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ET_NAME = (EditText)findViewById(R.id.new_name);
        ET_NEW_EMAIL = (EditText)findViewById(R.id.new_email);
        ET_USER_PASS = (EditText)findViewById(R.id.new_user_pass);
        ET_NEW_NUMBER = (EditText)findViewById(R.id.new_number);
        ET_DIR = (Spinner) findViewById(R.id.spinner);
        ET_DIS = (Spinner) findViewById(R.id.spinner2);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Directorate_Wise, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //second Spinner2
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.Disignation_Wise, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Logout");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        Toast.makeText(this, "User Logout", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,Login.class));
        return super.onOptionsItemSelected(item);
    }
    public void userReg(View view){


        name = ET_NAME.getText().toString();
        user_email = ET_NEW_EMAIL.getText().toString();
        user_pass =ET_USER_PASS.getText().toString();
        user_number =ET_NEW_NUMBER.getText().toString();
        user_dir = ET_DIR.getSelectedItem().toString();
        user_dis = ET_DIS.getSelectedItem().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,user_dir,user_dis,user_email,user_pass,user_number);
        finish();
    }
       public void userLogin(View view){
        startActivity(new Intent(this,Login.class));
    }



}
