package com.example.loginacessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Console;

public class addUser extends AppCompatActivity {

    private ProgressBar progressBar;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    public void addTeam(View view) {
        EditText editText1 = (EditText) findViewById(R.id.EtNom);
        String username = editText1.getText().toString().trim();

        EditText editText2 = (EditText) findViewById(R.id.EtPass);
        String password = editText2.getText().toString().trim();

        EditText editText3 = (EditText) findViewById(R.id.EtRole);
        String as = editText3.getText().toString().trim();


        reference = FirebaseDatabase.getInstance().getReference("login");

        User user = new User(username, as, password);
        System.out.println(user);

        reference.child(username).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(addUser.this,"User has been registered successfully!",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    //redirect to adminActivity
                    startActivity(new Intent(addUser.this, AdminActivity.class));
                }else{
                    Toast.makeText(addUser.this,"Failed to register! Try again!",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }
}