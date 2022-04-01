package com.example.loginacessapp.homologation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginacessapp.QRScanner;
import com.example.loginacessapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputActivity extends AppCompatActivity {

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Intent intent = getIntent();
        String data = intent.getStringExtra(QRScanner.DATA);

        Button btn = findViewById(R.id.btnscore);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = FirebaseDatabase.getInstance().getReference("teams").child(data).child("score_homologation");
                db.setValue(Integer.parseInt(((TextView)findViewById(R.id.score)).getText().toString()));
                startActivity(new Intent(InputActivity.this, AcceuilActivity.class));
            }
        });
    }



    public void sum(View v) {

        int d;
        if (((EditText)findViewById(R.id.note_design)).getText().toString().equals(""))
            d=0;
        else
            d = Integer.parseInt(((EditText)findViewById(R.id.note_design)).getText().toString());

        int m;
        if (((EditText)findViewById(R.id.note_meca)).getText().toString().equals(""))
            m=0;
        else
            m = Integer.parseInt(((EditText)findViewById(R.id.note_meca)).getText().toString());

        int e;
        if (((EditText)findViewById(R.id.note_elec)).getText().toString().equals(""))
            e=0;
        else
            e = Integer.parseInt(((EditText)findViewById(R.id.note_elec)).getText().toString());

        int t = d + m + e;
        CheckBox checkBox = findViewById(R.id.checkbox_respect);
        if(checkBox.isChecked())
            ((TextView)findViewById(R.id.score)).setText(""+t);
        else
            ((TextView)findViewById(R.id.score)).setText(""+0);
    }

}