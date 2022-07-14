package com.neu.architecture_simple.mvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.neu.architecture_simple.BR;
import com.neu.architecture_simple.R;
import com.neu.architecture_simple.databinding.ActivityLoginMvvmBinding;


public class LoginActivity extends ComponentActivity {

    ActivityLoginMvvmBinding binding;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initObserver();
    }

    private void initView() {
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_mvvm);
        binding.progressLogin.setVisibility(View.INVISIBLE);
        binding.setVariable(BR.click, new ClickProxy());
        binding.setVariable(BR.loginViewModel, loginViewModel);
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
//            Toast.makeText(LoginActivity.this,loginViewModel.getUserModel().getValue().getName()+" "+loginViewModel.getUserModel().getValue().getPasswd(),Toast.LENGTH_SHORT).show();
            binding.etLoginUsername.setText("");
            binding.etLoginPassword.setText("");
        }
    }
}
