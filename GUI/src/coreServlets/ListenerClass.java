package coreServlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerClass implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		String driverName = "com.mysql.jdbc.Driver";
		String conURL = "jdbc:mysql://10.48.5.61:3306/";
		ServletContext context = event.getServletContext();
		String dbName = context.getInitParameter("dbName");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pw");
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(conURL+dbName, user, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.setAttribute("guessNum", 1 + ((int)(Math.random() * 100)));
		context.setAttribute("tries", 10);
		context.setAttribute("conn", conn);
		context.setAttribute("msg", "");
	}

}
