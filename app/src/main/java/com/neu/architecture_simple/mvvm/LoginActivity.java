package com.neu.architecture_simple.mvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.neu.architecture_simple.R;
import com.neu.architecture_simple.databinding.ActivityLoginMvvmBinding;


public class LoginActivity extends ComponentActivity{

    ActivityLoginMvvmBinding binding;
    LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login_mvvm);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getUserModel();
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        binding.btnLoginLogin.setEnabled(true);
        binding.btnLoginClear.setEnabled(true);
        if (result) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Login Fail, code = " + code, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }

    class ClickProxy{
        public void onClickLogin(View view) {
            binding.progressLogin.setVisibility(View.VISIBLE);
            binding.btnLoginLogin.setEnabled(false);
            binding.btnLoginClear.setEnabled(false);
            loginPresenter.doLogin(editUser.getText().toString(), editPass.getText().toString());

        }

        public void onClickClear(View view){
            binding.etLoginUsername.setText("");
            binding.etLoginPassword.setText("");
        }

        private void doLogin(String name, String passwd) {
            boolean isLoginSuccess = true;
            final int code = loginViewModel.getUserModel().getValue().checkUserValidity(name, passwd);
            if (code != 0) isLoginSuccess = false;
            final Boolean result = isLoginSuccess;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    iLoginView.onLoginResult(result, code);
                }
            }, 5000);

        }
    }
}
