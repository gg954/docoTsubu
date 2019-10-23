package model;

import java.io.Serializable;

/*
 * ユーザに関する情報を持つJavaBeans
 */

public class User implements Serializable {
	//ユーザ名
	private String name;
	
	//パスワード
	private String pass;
	
	public User() {
	}
	
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPass() {
		return pass;
	}
}
