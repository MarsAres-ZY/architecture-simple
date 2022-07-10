package com.neu.architecture_simple.mvp.view;

public interface ILoginView {
	void onClearText();
	void onLoginResult(Boolean result, int code);
	void onSetProgressBarVisibility(int visibility);
}
