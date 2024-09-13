package com.malish;

import jakarta.servlet.ServletException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/firstServlet")
public class firstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    //Database connection details
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/javadb";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "sneha123";

   
    public firstServlet() {
        // TODO Auto-generated constructor stub
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("text1");
        PrintWriter pwt = response.getWriter();
        pwt.print("Successfully submitted by "+name);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("text1");
        String password = request.getParameter("password1");
        try (Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD)){
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1,username);
                stmt.setString(2, password);
                
                try (ResultSet rs = stmt.executeQuery()){
                    if(rs.next()) {
                        //Successful login
                        response.sendRedirect("welcome.jsp");
                    } else {
                        //Invalid Login
                        response.sendRedirect("index.jsp?error=Invalid credentials");
                    }
                }
            }
            
        }catch(Exception e) {
            
        }
        
        
    }

}