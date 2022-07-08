package com.neu.architecture_simple.mvvm;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<UserModel> userModel;
    
    public MutableLiveData<UserModel> getUserModel() {
        return userModel;
    }

    public void setUserModel(MutableLiveData<UserModel> userModel) {
        this.userModel = userModel;
    }
}
