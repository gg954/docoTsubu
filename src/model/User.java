package model;

import java.io.Serializable;

/*
 * ���[�U�Ɋւ����������JavaBeans
 */

public class User implements Serializable {
	//���[�U��
	private String name;
	
	//�p�X���[�h
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
