package model;

/*
 * ‚Â‚Ô‚â‚«‚Ì“Še‚ÉŠÖ‚·‚éˆ—‚ğs‚¤ƒ‚ƒfƒ‹
 */

import dao.MutterDAO;

public class PostMutterLogic {
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
	}
	

}
