package model;

/*
 * �Ԃ₫�̎擾�Ɋւ��鏈�����s�����f���iDAO�𗘗p�j
 */

import java.util.List;
import dao.MutterDAO;

public class GetMutterListLogic {
	public List<Mutter> execute(){
		MutterDAO dao = new MutterDAO();
		List<Mutter> mutterList = dao.findAll();
		System.out.println(mutterList);
		return mutterList;
	}

}
