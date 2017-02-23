package com.test.loginapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity {
    EditText phone,code;
    String phonepass,countrycode,phonecheck;
    Button verify;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        phone=(EditText)findViewById(R.id.phone_number);
        code=(EditText)findViewById(R.id.country_code);
        countrycode=code.getText().toString();
        verify=(Button)findViewById(R.id.phone_button);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phonecheck=phone.getText().toString();
                if(!phonecheck.equals("")) {
                    phonepass = phone.getText().toString();
                    //startActivity(new Intent(RegisterActivity.this, VerifyActivity.class));
                    Intent myIntent = new Intent(RegisterActivity.this, VerifyActivity.class);
                    myIntent.putExtra("SearchText", phonepass);
                    myIntent.putExtra("Searchcode", countrycode);
                    startActivity(myIntent);
                }
                else{
                    builder=new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("Something went wrong ..");
                    builder.setMessage("Please Enter Your Phone Number");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                }
            }
        });

    }
}
