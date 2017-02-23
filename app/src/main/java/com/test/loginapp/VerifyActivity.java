package com.test.loginapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VerifyActivity extends AppCompatActivity {
    TextView phone;
    Button verify;
    EditText verification;
    String verifycode;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String phonepassed = bundle.getString("SearchText");
        final String codepassed = bundle.getString("Searchcode");
        final String phonepass=codepassed+phonepassed;
        phone=(TextView)findViewById(R.id.verify_txt);
        phone.setText("Verify "+codepassed+phonepassed);
        verification=(EditText)findViewById(R.id.verification_code);
        verify=(Button)findViewById(R.id.verify_button);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifycode = verification.getText().toString();
                if(verifycode.equals("123789")) {
                    Intent myIntent = new Intent(VerifyActivity.this, PasswordActivity.class);
                    myIntent.putExtra("SearchText", phonepass);
                    startActivity(myIntent);
                }
                else{
                    builder=new AlertDialog.Builder(VerifyActivity.this);
                    builder.setTitle("Something went wrong ..");
                    builder.setMessage("Verification Code Invalid");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            startActivity(new Intent(VerifyActivity.this, RegisterActivity.class));
                        }
                    });
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                }
            }
        });

    }
}
