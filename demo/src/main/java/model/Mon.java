package model;

import java.io.Serializable;

public class Mon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int sotinchi;
	
	public Mon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mon(String name,int sotinchi) {
		super();
		this.name = name;
		this.sotinchi = sotinchi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSotinchi() {
		return sotinchi;
	}

	public void setSotinchi(int sotinchi) {
		this.sotinchi = sotinchi;
	}
	
}
