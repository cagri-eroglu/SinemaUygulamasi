package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import extra.DataBaseConnect;

public class Filmler {
	private int id;
	private String name;

	DataBaseConnect connect = new DataBaseConnect();
	Connection con = connect.dataBaseConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public Filmler() {
	}

	public Filmler(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ArrayList<Filmler> getList() throws SQLException{
		ArrayList<Filmler> list = new ArrayList<>();
		Connection con = connect.dataBaseConnection();
		Filmler obj ;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM filmlerveri") ;
			while (rs.next()) {
				obj = new Filmler();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			con.close();
		}
		return list;
	}
	
	public Filmler getFetch(int id) {
		Connection con = connect.dataBaseConnection();
		Filmler flm = new Filmler();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM filmlerveri WHERE id = "+id);
			while (rs.next()) {
				flm.setId(rs.getInt("id"));
				flm.setName(rs.getString("name"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flm;
	}

	public boolean addFilm(String name) 
	{
		String query = "INSERT INTO filmlerveri (name) VALUES (?)";
		boolean check = false;
		Connection con = connect.dataBaseConnection();
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,name);		
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
	
	public boolean deleteFilm(int id)  throws SQLException 
	{
		String query = "DELETE FROM filmlerveri WHERE id = ?";
		boolean check = false;
		Connection con = connect.dataBaseConnection();
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
	
	public boolean Updatefilm(int id,String name)  throws SQLException 
	{
		String query = "UPDATE filmlerveri SET name= ? WHERE id = ?";
		boolean check = false;
		Connection con = connect.dataBaseConnection();
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,name);
			preparedStatement.setInt(2,id);
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

}
