package com.tests.fh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		User loginUser = new User(name, pass);
		int result = loginUser.authenticate();
		RequestDispatcher rd;
		switch(result) {
		case 0 : rd=request.getRequestDispatcher("/LoginFail.jsp"); rd.forward(request, response);break;
		case 1 : rd=request.getRequestDispatcher("/UserHome.jsp"); rd.forward(request, response);break;
		case 2 : rd=request.getRequestDispatcher("/ErrorPages/DBError.jsp"); rd.forward(request, response);
		}
		
	}

}
