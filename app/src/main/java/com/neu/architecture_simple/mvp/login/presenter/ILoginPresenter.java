package com.neu.architecture_simple.mvp.login.presenter;

public interface ILoginPresenter {
	void clear();
	void doLogin(String name, String passwd);
	void setProgressBarVisibility(int visibility);
}
