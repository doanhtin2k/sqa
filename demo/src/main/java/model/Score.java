package model;

import java.io.Serializable;

public class Score implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private float diemcc;
	private float diemgiuaky;
	private float diemcuoiky;
	private float diemtongket;
	public float getDiemtongket() {
		return diemtongket;
	}
	public void setDiemtongket(float diemtongket) {
		this.diemtongket = diemtongket;
	}
	private int status;
	private Mon mon;
	private User user;
	public Score() {
		super();
		// TODO Auto-generated constructor stub
		this.user = new User();
		this.mon = new Mon();
	}
	public Score(float diemcc, float diemgiuaky, float diemcuoiky,int status, Mon mon, User user) {
		super();
		this.diemcc = diemcc;
		this.diemgiuaky = diemgiuaky;
		this.diemcuoiky = diemcuoiky;
		this.status = status;
		this.mon = mon;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getDiemcc() {
		return diemcc;
	}
	public void setDiemcc(float diemcc) {
		this.diemcc = diemcc;
	}
	public float getDiemgiuaky() {
		return diemgiuaky;
	}
	public void setDiemgiuaky(float diemgiuaky) {
		this.diemgiuaky = diemgiuaky;
	}
	public float getDiemcuoiky() {
		return diemcuoiky;
	}
	public void setDiemcuoiky(float diemcuoiky) {
		this.diemcuoiky = diemcuoiky;
	}
	public Mon getMon() {
		return mon;
	}
	public void setMon(Mon mon) {
		this.mon = mon;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
