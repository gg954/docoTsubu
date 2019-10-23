package model;

/*
 * つぶやきの取得に関する処理を行うモデル（DAOを利用）
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
