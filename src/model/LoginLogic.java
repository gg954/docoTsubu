package model;

/*
 * ���O�C���Ɋւ��鏈�����s�����f��
 */

public class LoginLogic {
	public boolean execute(User user) {
		if(user.getPass().equals("1234")) {
			return true;
		}
		return false;
	}

}
