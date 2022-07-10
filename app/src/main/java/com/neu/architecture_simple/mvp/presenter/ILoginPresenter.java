package com.neu.architecture_simple.mvp.presenter;

public interface ILoginPresenter {
	void clear();
	void doLogin(String name, String passwd);
	void setProgressBarVisibility(int visibility);
}
