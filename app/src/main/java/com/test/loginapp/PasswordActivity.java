package com.test.loginapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {
    EditText password,passwordconfirm;
    Button start;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String phonepassed = bundle.getString("SearchText");

        password=(EditText)findViewById(R.id.password_add);
        passwordconfirm = (EditText)findViewById(R.id.password_confirm);
        start=(Button)findViewById(R.id.start_button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equals("")|| passwordconfirm.getText().toString().equals("")){
                    builder=new AlertDialog.Builder(PasswordActivity.this);
                    builder.setTitle("Something went wrong ..");
                    builder.setMessage("Please Fill all Fields");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                }
                else if(!(password.getText().toString().equals(passwordconfirm.getText().toString()))){
                    builder=new AlertDialog.Builder(PasswordActivity.this);
                    builder.setTitle("Something went wrong ..");
                    builder.setMessage("Your Passwords Are Not Matching");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            password.setText("");
                            passwordconfirm.setText("");
                        }
                    });
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                }
                else
                {
                    BackgroundTask backgroundTask=new BackgroundTask(PasswordActivity.this);
                    backgroundTask.execute("register",phonepassed,password.getText().toString());
                }


            }
        });

    }
}
