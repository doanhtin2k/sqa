package model;

import java.io.Serializable;

public class Setting implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int cc;
	private int gk;
	private int ck;
	public Setting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Setting(String name, int cc, int gk, int ck) {
		super();
		this.name = name;
		this.cc = cc;
		this.gk = gk;
		this.ck = ck;
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
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getGk() {
		return gk;
	}
	public void setGk(int gk) {
		this.gk = gk;
	}
	public int getCk() {
		return ck;
	}
	public void setCk(int ck) {
		this.ck = ck;
	}
	
}
