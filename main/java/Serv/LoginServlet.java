package Serv;

import java.io.IOException;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String unm = request.getParameter("uname");
		String upass = request.getParameter("pass");
		boolean flag = false;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
					"parag123");
			PreparedStatement s = con.prepareStatement("select * from usereg where uname=?,upass =?");
			s.setString(1,unm);
			s.setString(2, upass);
			ResultSet rs = s.executeQuery();
			if(rs.next()) {
				flag = true;
			}
			
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		if(flag) {
			
//		}else {
////			response.sendRedirect("index.html");
////			response.sendRedirect("regForm.html");
//		}
		
	}

	}
}
