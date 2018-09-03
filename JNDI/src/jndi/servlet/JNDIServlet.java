package jndi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JNDIServlet")
public class JNDIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
				
		String name , pass;
		   name = request.getParameter("txtuname");
		   pass = request.getParameter("txtpass");
		   
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try {
			
			Class.forName("sun.jdb.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("Jdbc:Odbc:abc");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into login(userName,userPassword) values('"+name+"','"+pass+"')");
			pw.println("Data saved!");
			con.close();
			
		}catch(ClassNotFoundException e) {
			pw.println("Class not found" + e);
		}catch(Exception e1) {
			
			pw.println("Insertion Failed! " + e1);
		}
		   
		
	}

}
