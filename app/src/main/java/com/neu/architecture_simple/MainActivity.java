package com.neu.architecture_simple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_mvc).setOnClickListener(this);
        findViewById(R.id.btn_mvp).setOnClickListener(this);
        findViewById(R.id.btn_mvvm).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        int id = v.getId();

        if (id == R.id.btn_mvc) {
            intent.setClass(this, com.neu.architecture_simple.mvc.login.LoginActivity.class);
        } else if (id == R.id.btn_mvp) {
            intent.setClass(this, com.neu.architecture_simple.mvp.login.LoginActivity.class);
        } else if (id == R.id.btn_mvvm) {
            intent.setClass(this, com.neu.architecture_simple.mvc.login.LoginActivity.class);
        }

        startActivity(intent);
    }
}