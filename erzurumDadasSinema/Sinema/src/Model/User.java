package Model;

import extra.DataBaseConnect;

public class User {
	private int id;
	private String tc,sifre,ad,tip;
	
	DataBaseConnect connect = new DataBaseConnect();
	
	public User(int id, String tc, String sifre, String ad, String tip) {
		this.id = id;
		this.tc = tc;
		this.sifre = sifre;
		this.ad = ad;
		this.tip = tip;
	}

	
	public User() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
}
