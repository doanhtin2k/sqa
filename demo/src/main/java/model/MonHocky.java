package model;

import java.io.Serializable;

public class MonHocky implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mon mon;
	private Ky ky;
	public MonHocky() {
		super();
		// TODO Auto-generated constructor stub
		this.mon = new Mon();
		this.ky = new Ky();
	}
	public MonHocky(Mon mon, model.Ky ky) {
		super();
		this.mon = mon;
		this.ky = ky;
	}
	
}
