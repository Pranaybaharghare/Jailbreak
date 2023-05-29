package com.java.jailbreak.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//getting data from client
				String email=request.getParameter("email");
				String password=request.getParameter("password");
	
		//Calling DAO Layer
		boolean result =LoginDao.checkLogin(email,password);	
	System.out.println(result);

		if(result==true) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("dashboard.html");
		dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("RegisterFail.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
