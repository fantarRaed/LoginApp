package com.example.loginacessapp.homologation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginacessapp.R;

public class AcceuilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);


        TextView bt1 = findViewById(R.id.btnj);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AcceuilActivity.this, JuniorActivity.class));
            }
        });
        TextView bt2 = findViewById(R.id.btns);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AcceuilActivity.this, SuiveurActivity.class));
            }
        });
        TextView bt3 = findViewById(R.id.btna);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AcceuilActivity.this, AutonomeActivity.class));
            }
        });
        TextView bt4 = findViewById(R.id.btnt);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AcceuilActivity.this, ToutTerrainActivity.class));
            }
        });
    }
}