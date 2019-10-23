package model;

import java.io.Serializable;

/*
 * ‚Â‚Ô‚â‚«‚ÉŠÖ‚·‚éî•ñ‚ğ‚ÂJavaBeans
 */

public class Mutter implements Serializable {
	//id
	private int id;
	
	//ƒ†[ƒU–¼
	private String userName;
	
	//‚Â‚Ô‚â‚«“à—e
	private String text;
	
	public Mutter() {
	}
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	
	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getText() {
		return text;
	}

	
}
