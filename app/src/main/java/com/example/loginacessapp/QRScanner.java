package com.example.loginacessapp;


import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginacessapp.homologation.InputActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class QRScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;
    DatabaseReference dbref;
    public static final String DATA = "com.example.qrcodetest2.EXTRA_SCORE";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);

       dbref = FirebaseDatabase.getInstance().getReference("qrdata");

        Dexter.withContext(getApplicationContext())
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                        scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                        permissionToken.continuePermissionRequest();

                    }
                }).check();
    }

    @Override
    public void handleResult(Result rawResult) {

        String data = rawResult.getText().toString();
        //dbref.push().setValue(data);
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra(DATA,data);
        startActivity(intent);
       // startActivity(new Intent(getApplicationContext(),afterHomlog.class));


        //DatabaseReference childref = dbref.child(data);
        //DatabaseReference childref1 = childref.child("Présence");
        //DatabaseReference childref2 = childref.child("Hologation");
        //DatabaseReference childref3 = childref.child("Pause déjeuné");
        //DatabaseReference childref4 = childref.child("Score");


        //  childref1.setValue(1);
        //childref3.setValue(1);
       /* Intent intent = getIntent();
        String number = intent.getStringExtra(afterHomlogScan.EXTRA_SCORE);
        childref2.setValue(number);*/

        // childref3.setValue(1);
        // childref4.setValue(scr);

        //MainActivity.qrtxt.setText("Data inserted Successfully");

        // startActivity(new Intent(getApplicationContext(),afterHomlogScan.class));

        onBackPressed();
      /* childref3.setValue(1)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                       // MainActivity.qrtxt.setText("Data inserted Successfully");
                        //onBackPressed();
                        startActivity(new Intent(getApplicationContext(),afterHomlogScan.class));




                    }
                });*/
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}