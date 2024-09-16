package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Users;
import services.ILoginService;
import services.LoginServiceImpl;

@WebServlet("/ResetPassword")
public class ForgotpasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgotpasswordController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/forgot-password.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ILoginService Login = new LoginServiceImpl();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// nhan du lieu tu view
		String username = req.getParameter("username");
		String password = req.getParameter("new-password");
		// khoi tao user
		Users user = new Users();
		user.setEmail(username);
		user.setPassword(password);
		//
		String alert = "";
		if(Login.resetPassword(user)==true) {
			alert = "Password has been successfully";
			req.setAttribute("message", alert);
			req.getRequestDispatcher("forgot-password.jsp").forward(req, resp);
		}else {
			alert="Email does not exist!";
			System.out.println(alert);
			req.setAttribute("message", alert);
			req.getRequestDispatcher("forgot-password.jsp").forward(req, resp);
		}
	}

}
