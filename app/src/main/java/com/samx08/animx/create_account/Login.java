package com.samx08.animx.create_account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samx08.animx.DashBoard;
import com.samx08.animx.R;
import com.samx08.animx.model.LogInModel;

public class Login extends AppCompatActivity {

    Button sign_in_button;

    TextInputLayout loginusername,loginpassword;
    Button login;
    ProgressDialog loadingbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sign_in_button = findViewById(R.id.new_resigter);
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this,Resigter.class);
                startActivity(intent);
            }
        });

        loginusername=findViewById(R.id.login_username);
        loginpassword=findViewById(R.id.login_password);

        loadingbar=new ProgressDialog(this);

        login=findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login_details();
            }
        });
    }

    private void login_details()
    {
        String user_name = loginusername.getEditText().getText().toString();
        String pass_word = loginpassword.getEditText().getText().toString();

        if (TextUtils.isEmpty(user_name))
    {
        Toast.makeText(this,"Enter Your User Name!",Toast.LENGTH_SHORT).show();
    }
    else if (TextUtils.isEmpty(pass_word))
    {
        Toast.makeText(this,"Enter Your Password!",Toast.LENGTH_SHORT).show();
    }

    else
    {
        loadingbar.setTitle("Log In");
        loadingbar.setMessage("Loging In To Your Account...");
        loadingbar.setCanceledOnTouchOutside(false);
        loadingbar.show();
    }

        validation(user_name,pass_word);
    }

    private void validation(final String user_name,final String pass_word)
    {
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();

        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if ((dataSnapshot).child("Users").child(user_name).exists())
                {
                    LogInModel userdata = (dataSnapshot).child("Users").child(user_name).getValue(LogInModel.class);
                    if(userdata.getUser_name().equals(user_name))
                    {
                        if(userdata.getPass_word().equals(pass_word))
                        {
                            Toast.makeText(Login.this,"Welcome To AnimX "+user_name,Toast.LENGTH_SHORT).show();
                            loadingbar.dismiss();
                            Intent intent = new Intent(Login.this,DashBoard.class);
                            startActivity(intent);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}