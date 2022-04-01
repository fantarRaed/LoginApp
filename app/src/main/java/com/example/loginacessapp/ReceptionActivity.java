package com.example.loginacessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.loginacessapp.databinding.ActivityJurynavbarBinding;
import com.example.loginacessapp.databinding.ActivityReceptionBinding;
import com.example.loginacessapp.databinding.ActivityReceptionBinding;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ReceptionActivity extends AppCompatActivity {
    ActivityReceptionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReceptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replacefragment(new suiveurrec());
        binding.navbarrec.setOnItemSelectedListener(item -> {

            switch(item.getItemId()) {
                case R.id.suiv:
                    replacefragment(new suiveurrec());
                    break;
                case R.id.jun:
                    replacefragment(new juniorrec());
                    break;
                case R.id.tterr:
                    replacefragment(new tterrainrec());
                    break;
                case R.id.auto:
                    replacefragment(new autonomerec());
                    break;

            }




            return true;


        });
    }
    private void replacefragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bc,fragment);
        fragmentTransaction.commit();


    }

}

