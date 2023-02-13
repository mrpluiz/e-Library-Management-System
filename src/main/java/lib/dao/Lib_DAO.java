package lib.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lib.bo.Lib_BO;
import lib.bo.Reader_BO;

public class Lib_DAO {

	public static Connection getConnection() {

		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/library";
			String uname = "root";
			String pwd = "Dagdu@1994";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
	return con;
	}

	public static int signup(Lib_BO li) {

		int status=0;

		try {
			Connection con = Lib_DAO.getConnection();
			String sql = "INSERT INTO libsignup(name,email,phone,password) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setNString(1, li.getName());
			ps.setNString(2, li.getEmail());
			ps.setNString(3, li.getPhone());
			ps.setNString(4, li.getPassword());

			status = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	return status;
	}

	public static boolean login(String email, String pass) {

		boolean status=false;

		try {
			Connection con = Lib_DAO.getConnection();
			String sql = "SELECT  * FROM libsignup WHERE email=? AND password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setNString(1, email);
			ps.setNString(2, pass);

			ResultSet rs = ps.executeQuery();
			status=rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	return status;
	}

	public static int addreader(Reader_BO rr) {

		int status=0;

		try {
			Connection con = Lib_DAO.getConnection();
			String sql = "INSERT INTO addreader(name,degree,phone,doi,dor,bookname) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setNString(1, rr.getName());
			ps.setNString(2, rr.getDegree());
			ps.setNString(3, rr.getPhone());
			ps.setNString(4, rr.getDoi());
			ps.setNString(5, rr.getDor());
			ps.setNString(6, rr.getBookname());

			status = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	return status;
	}

	public static List<Reader_BO> allreader() {

		List<Reader_BO> list = new ArrayList<Reader_BO>();

		try {
			Connection con=Lib_DAO.getConnection();
			String sql = "SELECT * from addreader";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Reader_BO rr = new Reader_BO();

				rr.setId(rs.getInt(1));
				rr.setName(rs.getString(2));
				rr.setDegree(rs.getString(3));
				rr.setPhone(rs.getString(4));
				rr.setDoi(rs.getString(5));
				rr.setDor(rs.getString(6));
				rr.setBookname(rs.getString(7));
	
				list.add(rr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return list;	
	}

	public static Reader_BO getreaderbyID(int id) {

		Reader_BO rr = new Reader_BO();

		try {
			Connection con=Lib_DAO.getConnection();
			String sql = "SELECT * from addreader WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				rr.setId(rs.getInt(1));
				rr.setName(rs.getString(2));
				rr.setDegree(rs.getString(3));
				rr.setPhone(rs.getString(4));
				rr.setDoi(rs.getString(5));
				rr.setDor(rs.getString(6));
				rr.setBookname(rs.getString(7));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	return rr;
	}

	public static int update(Reader_BO rr){

		int status = 0;
		try {
			Connection con = Lib_DAO.getConnection();
			String sql = "UPDATE addreader SET name=?,degree=?,phone=?,doi=?,dor=?,bookname=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, rr.getName());
			ps.setString(2, rr.getDegree());
			ps.setString(3, rr.getPhone());
			ps.setString(4, rr.getDoi());
			ps.setString(5, rr.getDor());
			ps.setString(6, rr.getBookname());
			ps.setInt(7, rr.getId());

			status=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	return status;
	}

	public static int delete(int id) {

		int status=0;
		try {
			Connection con = Lib_DAO.getConnection();
			String sql = "DELETE FROM addreader WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);

			status=ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	return status;
	}
}