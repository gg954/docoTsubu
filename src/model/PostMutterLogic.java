package model;

/*
 * �Ԃ₫�̓��e�Ɋւ��鏈�����s�����f��
 */

import dao.MutterDAO;

public class PostMutterLogic {
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
	}
	

}
