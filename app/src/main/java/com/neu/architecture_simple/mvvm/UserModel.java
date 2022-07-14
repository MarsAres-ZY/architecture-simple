package com.neu.architecture_simple.mvvm;

public class UserModel {
	private String name;
	private String passwd;

	public UserModel() {
	}

	public UserModel(String name, String passwd) {
		this.name = name;
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int checkUserValidity(String name, String passwd){
		if (name==null||passwd==null||!name.equals("123")||!passwd.equals("123")){
			return -1;
		}
		return 0;
	}
}
