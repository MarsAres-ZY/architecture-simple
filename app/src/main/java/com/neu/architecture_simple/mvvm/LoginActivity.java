package com.neu.architecture_simple.mvvm;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.neu.architecture_simple.R;
import com.neu.architecture_simple.databinding.ActivityLoginMvvmBinding;

import java.util.Objects;


public class LoginActivity extends ComponentActivity {

    ActivityLoginMvvmBinding binding;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_mvvm);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
//        binding.setVariable(BV.R)
        initView();
        initObserver();

    }

    private void initView() {
        binding.progressLogin.setVisibility(View.INVISIBLE);
    }

    private void initObserver() {
        loginViewModel.getLoginStateModel().observe(this, aBoolean -> {
            binding.progressLogin.setVisibility(View.INVISIBLE);
            binding.btnLoginLogin.setEnabled(true);
            binding.btnLoginClear.setEnabled(true);
            if (aBoolean) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Login Fail ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ClickProxy {
        public void onClickLogin(View view) {
            binding.progressLogin.setVisibility(View.VISIBLE);
            binding.btnLoginLogin.setEnabled(false);
            binding.btnLoginClear.setEnabled(false);
            loginViewModel.doLogin(binding.etLoginUsername.getText().toString(), binding.etLoginPassword.getText().toString());
        }

        public void onClickClear(View view) {
            binding.etLoginUsername.setText("");
            binding.etLoginPassword.setText("");
        }
    }
}
