package Servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class userScoreServlet {
	public static void addPoint(Connection conn, String userName) throws Exception{
		Connection con = conn;
		Statement stm = (Statement) con.createStatement();
		String querySt = "  UPDATE Credentials SET score = score + 1 WHERE login=?";
		PreparedStatement ps = con.prepareStatement(querySt);
		ps.setString(1, userName);
		int res = ps.executeUpdate();
	}
}
