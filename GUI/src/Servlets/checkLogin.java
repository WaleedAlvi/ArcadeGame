package Servlets;

import java.sql.*;

import javax.servlet.*;

public class checkLogin {
	public static boolean checkValid(Connection conn, String userName, String pw) throws Exception {
		boolean isValid = false;
		Connection con = conn;
		String user = userName;
		String pass = pw;

		Statement stm = (Statement) con.createStatement();
		String querySt = "SELECT * from Credentials WHERE login=? AND password=?";
		PreparedStatement ps = con.prepareStatement(querySt);
		ps.setString(1, user);
		ps.setString(2, pass);
		ResultSet res = ps.executeQuery();
		int num = 0;
		while (res.next()) {
			num++;
		}
		if (num == 0) {
			isValid = false;
		} else {
			isValid = true;
		}
		return isValid;
	}
}
