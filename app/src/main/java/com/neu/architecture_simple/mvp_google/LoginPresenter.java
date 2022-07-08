package com.neu.architecture_simple.mvp_google;

import android.os.Handler;

import com.neu.architecture_simple.mvp.login.model.IUser;

public class LoginPresenter implements LoginContract.Presenter {
    private IUser user;
    private Handler handler;
    private final LoginContract.View iLoginView;

    public LoginPresenter(LoginContract.View mView) {
        this.iLoginView = mView;
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        boolean isLoginSuccess = true;
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

    @Override
    public void start() {

    }
}
