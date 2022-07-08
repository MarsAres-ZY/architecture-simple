package com.neu.architecture_simple.mvc.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import com.neu.architecture_simple.R;
import com.neu.architecture_simple.mvc.login.model.IUser;
import com.neu.architecture_simple.mvc.login.model.UserModel;


public class LoginActivity extends ComponentActivity implements View.OnClickListener {

    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private Button btnClear;
    private ProgressBar progressBar;
    private IUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //find view
        editUser = (EditText) this.findViewById(R.id.et_login_username);
        editPass = (EditText) this.findViewById(R.id.et_login_password);
        btnLogin = (Button) this.findViewById(R.id.btn_login_login);
        btnClear = (Button) this.findViewById(R.id.btn_login_clear);
        progressBar = (ProgressBar) this.findViewById(R.id.progress_login);

        //set listener
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        user = new UserModel("123","123");
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_clear:
                clear();
                break;
            case R.id.btn_login_login:
                setProgressBarVisiblity(View.VISIBLE);
                btnLogin.setEnabled(false);
                btnClear.setEnabled(false);
                doLogin(editUser.getText().toString(), editPass.getText().toString());
                break;
        }
    }

    private void clear() {
        editUser.setText("");
        editPass.setText("");
    }

    private void setProgressBarVisiblity(int visibility) {
        progressBar.setVisibility(visibility);
    }

    private void doLogin(String name, String passwd){
        boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name, passwd);
        if (code != 0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoginResult(result, code);
            }
        }, 5000);

    }

    public void onLoginResult(Boolean result, int code) {
        setProgressBarVisiblity(View.INVISIBLE);
        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);
        if (result) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Login Fail, code = " + code, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
