package com.goprojectstudio.attitube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.buttom_nav);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setSelectedItemId(R.id.btn_beranda);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new BerandaFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.btn_beranda:
                fragment = new BerandaFragment();
                break;
            case R.id.btn_koleksi:
                fragment = new KoleksiFragment();
                break;
            case R.id.btn_kuis:
                fragment = new KuisFragment();
                break;
            case R.id.btn_konsultan:
                fragment = new KonsultanFragment();
                break;
            case R.id.btn_profil:
                fragment = new ProfilFragment();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onBackPressed() {
        myAlert(MainActivity.this);
    }
    private void myAlert(Context context) {
        new AlertDialog.Builder(context)
                .setTitle("Keluar?")
                .setMessage("Apakah yakin akan keluar aplikasi?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}
