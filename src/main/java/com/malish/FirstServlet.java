package com.malish;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  //Database connection details
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "malish";
    private static final String DB_PASSWORD = "mallu";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
      
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        String name = request.getParameter("text1");
        PrintWriter pwt = response.getWriter();
        pwt.print("Successfully submitted by "+name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  System.out.println("I am 1");
	        String username = request.getParameter("text1");
	        String password = request.getParameter("password1");
	        System.out.println("I am 2");
	        try {
	            Class.forName("org.postgresql.Driver");
	            System.out.println("PostgreSQL JDBC Driver is available!");
	        } catch (ClassNotFoundException e) {
	            System.out.println("PostgreSQL JDBC Driver is NOT available!");
	        }
	        try (Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD)){
	            
	            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
	            System.out.println("I am 3");
	            
	            try(PreparedStatement stmt = conn.prepareStatement(sql)){
	                stmt.setString(1,username);
	                stmt.setString(2, password);
	                System.out.println("I am 4");
	                
	                try (ResultSet rs = stmt.executeQuery()){
	                    System.out.println("I am 5");
	                    if(rs.next()) {
	                        System.out.println("I am 6");
	                        //Successful login
	                        response.sendRedirect("welcome.jsp");
	                    } else {
	                        //Invalid Login
	                        System.out.println("I am 7");
	                        response.sendRedirect("index.jsp?error=Invalid credentials");
	                    }
	                }
	                System.out.println("I am 8");
	            }
	            
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	        
	}

}
