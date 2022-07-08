package com.neu.architecture_simple.mvp_google;

import com.neu.architecture_simple.mvp_google.base.BasePresenter;
import com.neu.architecture_simple.mvp_google.base.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void onClearText();

        void onLoginResult(Boolean result, int code);

        void onSetProgressBarVisibility(int visibility);
    }

    interface Presenter extends BasePresenter {
        void clear();

        void doLogin(String name, String passwd);

        void setProgressBarVisibility(int visibility);
    }

}
