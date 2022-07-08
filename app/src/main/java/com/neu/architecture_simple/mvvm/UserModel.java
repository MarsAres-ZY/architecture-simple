package com.neu.architecture_simple.mvvm;

import androidx.databinding.BaseObservable;


public class UserModel extends BaseObservable {
	private String name;
	private String passwd;

	public UserModel(String name, String passwd) {
		this.name = name;
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		notifyChange();
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	//	@Override
//	public String getName() {
//		return name;
//	}
//
//	@Override
//	public String getPasswd() {
//		return passwd;
//	}
//
//	@Override
	public int checkUserValidity(String name, String passwd){
		if (name==null||passwd==null||!name.equals(getName())||!passwd.equals(getPasswd())){
			return -1;
		}
		return 0;
	}
}
