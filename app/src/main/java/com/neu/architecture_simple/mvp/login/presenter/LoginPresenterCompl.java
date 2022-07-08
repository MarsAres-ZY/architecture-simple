package com.neu.architecture_simple.mvp.login.presenter;

import android.os.Handler;
import android.os.Looper;

import com.neu.architecture_simple.mvp.login.model.IUser;
import com.neu.architecture_simple.mvp.login.model.UserModel;
import com.neu.architecture_simple.mvp.login.view.ILoginView;

public class LoginPresenterCompl implements ILoginPresenter {
    ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name, passwd);
        if (code != 0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 5000);

    }


    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }


    private void initUser() {
        user = new UserModel("mvp", "mvp");
    }
}
