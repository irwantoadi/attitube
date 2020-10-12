package com.goprojectstudio.attitube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        relativeLayout = findViewById(R.id.root_layout);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                //splash screen hilang
                finish();
            }
        });

        //menjalankan splash activity dlm beberapa detik
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //apa yg terjadi
//                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
//                startActivity(intent);
//                //splash screen hilang
//                finish();
//            }
//        },4000);
    }
}
