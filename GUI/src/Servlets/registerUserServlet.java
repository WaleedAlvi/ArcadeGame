package Servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class registerUserServlet {
	public static boolean registerUser(Connection conn, String userName, String pw) throws Exception{
		boolean isRegistered = false;
		Connection con = conn;
		String user = userName;
		String pass = pw;
		
		Statement stm = (Statement) con.createStatement();
		String querySt = "SELECT * from Credentials WHERE login=?";
		PreparedStatement ps = con.prepareStatement(querySt);
		ps.setString(1, user);
		ResultSet res = ps.executeQuery();
		int num = 0;
		while(res.next()){
			num++;
		}
		
		if(num == 0){
			Statement stm2 = (Statement) con.createStatement();
			String querySt2 = "  Insert into Credentials(login, password, score)values(?, ?, 0);";
			PreparedStatement ps2 = con.prepareStatement(querySt2);
			ps2.setString(1, user);
			ps2.setString(2, pass);
			int res2 = ps2.executeUpdate();
			isRegistered = true;
		}else{
			isRegistered = false;
		}
		return isRegistered;
	}
}
//
