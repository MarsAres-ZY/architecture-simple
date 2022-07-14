package com.neu.architecture_simple.mvvm;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<UserModel> userModel = new MutableLiveData<>(new UserModel());
    private final MutableLiveData<Boolean> loginStateModel = new MutableLiveData<>();

    public MutableLiveData<Boolean> getLoginStateModel() {
        return loginStateModel;
    }
    public MutableLiveData<UserModel> getUserModel() {
        return userModel;
    }

    public void doLogin(String name, String passwd) {
        boolean isLoginSuccess = true;
        final int code = userModel.getValue().checkUserValidity(name, passwd);
        if (code != 0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        new Handler(Looper.myLooper()).postDelayed(() -> loginStateModel.postValue(result), 3000);
    }

}
