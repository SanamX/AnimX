package com.samx08.animx.create_account;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samx08.animx.R;

import java.util.HashMap;

public class Resigter extends AppCompatActivity {

    Button login_page_intent;

    TextInputLayout firstname, lastname, dob, username, password;
    Button resigter;
    ProgressDialog loadingbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resigter);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        login_page_intent=findViewById(R.id.already_user);
        login_page_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Resigter.this,Login.class);
                startActivity(intent);
            }
        });

        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        dob=findViewById(R.id.dob);
        username=findViewById(R.id.resigter_username);
        password=findViewById(R.id.resigter_password);

        loadingbar=new ProgressDialog(this);

        resigter=findViewById(R.id.resigter_button);
        resigter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createaccount();
            }
        });
    }

    private void createaccount()
    {
        String first_name = firstname.getEditText().getText().toString();
        String last_name = lastname.getEditText().getText().toString();
        String date_of_birth = dob.getEditText().getText().toString();
        String user_name = username.getEditText().getText().toString();
        String pass_word = password.getEditText().getText().toString();

        if (TextUtils.isEmpty(first_name))
        {
            Toast.makeText(this,"Enter Your First Name!",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(last_name))
        {
            Toast.makeText(this,"Enter Your Last Name!",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(date_of_birth))
        {
            Toast.makeText(this,"Enter Your Date Of Birth!",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(user_name))
        {
            Toast.makeText(this,"Enter Your User Name!",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(pass_word))
        {
            Toast.makeText(this,"Enter Your Password!",Toast.LENGTH_SHORT).show();
        }

        else
        {
            loadingbar.setTitle("Create New Account");
            loadingbar.setMessage("Connecting To The Server....");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();
        }

        savedata(first_name,last_name,date_of_birth,user_name,pass_word);
    }

    private void savedata(final String first_name,final String last_name,final String date_of_birth, final String user_name,final String pass_word)
    {
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();

        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (!(dataSnapshot).child("Users").child(user_name).exists())
                {
                    HashMap<String,Object> userdatamap = new HashMap<>();
                    userdatamap.put("first_name",first_name);
                    userdatamap.put("last_name",last_name);
                    userdatamap.put("date_of_birth",date_of_birth);
                    userdatamap.put("user_name",user_name);
                    userdatamap.put("pass_word",pass_word);

                    Rootref.child("Users").child(user_name).updateChildren(userdatamap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    Toast.makeText(Resigter.this,"Account Created Successfully!",Toast.LENGTH_SHORT).show();
                                    loadingbar.dismiss();
                                    Intent intent = new Intent(Resigter.this,Login.class);
                                    startActivity(intent);
                                }
                            });

                }
                else
                {
                    Toast.makeText(Resigter.this,"Username Is Already Exists!",Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}