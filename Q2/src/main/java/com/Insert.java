package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        int id = Integer.parseInt(request.getParameter("sid"));
        String name = request.getParameter("sname");
        int phone = Integer.parseInt(request.getParameter("uphone"));
        int marks = Integer.parseInt(request.getParameter("umarks"));
        String branch = request.getParameter("ubranch");


        PrintWriter out = response.getWriter();
        try {

        	 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/IGTEXAM", "root", "root");

            PreparedStatement p = con.prepareStatement("insert into student values(?, ?, ?, ?, ?)");

            p.setInt(1, id);
            p.setString(2, name);
            p.setInt(3, phone);
            p.setInt(4, marks);
            p.setString(5, branch);

            p.execute();

            out.print("<h1>");
            out.print("Id:" + id + "<br>");
            out.print("Name: " + name + "<br>");
            out.print("Phone :" + phone + "<br>");
            out.print("Marks:" + marks + "<br>");
            out.print("Branch: " + branch + "<br>");

            out.print("</h1>");
            out.print("Inserted");

            out.print("<a href='Index.html'>HOME PAGE</a>");
        } catch(Exception e) {

            System.out.println(e);
        }  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
