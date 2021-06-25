package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Yonetici extends User{
	
	Connection con = connect.dataBaseConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public Yonetici(int id, String kullaniciAdi, String sifre, String ad, String tip) {
		super(id, kullaniciAdi, sifre, ad, tip);
	}
	
	public Yonetici() {}
	
	public ArrayList<User> getMusteriList() throws SQLException{
		ArrayList<User> list = new ArrayList<>();
		
		User obj ;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM kullanici WHERE tip = 'Müsteri'") ;
			while (rs.next()) {
				obj = new User(rs.getInt("id"),rs.getString("tc"),rs.getString("sifre"),rs.getString("ad"),rs.getString("tip"));
				list.add(obj);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
		
	}
	
	public boolean addMusteri(String tcno,String sifre,String ad) 
	{
		String query = "INSERT INTO kullanici (tc,sifre,ad,tip) VALUES (?,?,?,?)";
		boolean check = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,tcno);
			preparedStatement.setString(2,sifre);
			preparedStatement.setString(3,ad);
			preparedStatement.setString(4,"Müsteri");
			preparedStatement.executeUpdate();
			check = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		if (check) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public boolean deleteMusteri(int id)  throws SQLException 
	{
		String query = "DELETE FROM kullanici WHERE id = ?";
		boolean check = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1,id);

			preparedStatement.executeUpdate();
			check = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		if (check) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public boolean UPDATEMusteri(int id,String tcno,String sifre,String ad)  throws SQLException 
	{
		String query = "UPDATE kullanici SET ad = ?, tc = ?,sifre = ? WHERE id = ?";
		boolean check = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,ad);
			preparedStatement.setString(2,tcno);
			preparedStatement.setString(3,sifre);
			preparedStatement.setInt(4,id);
			preparedStatement.executeUpdate();
			check = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		if (check) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
