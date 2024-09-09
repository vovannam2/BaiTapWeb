package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import models.Users;
import services.ILoginService;
import services.LoginServiceImpl;

@WebServlet (urlPatterns = {"/Login","/Register"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ILoginService LoginS = new LoginServiceImpl();
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("Login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}else if(url.contains("Register")) {
			RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
			rd.forward(req, resp);
		}

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("Login")) {
			login(req,resp);
		}else if(url.contains("Register")) {
			register(req,resp);
		}
		
	}


	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// nhan du lieu tu view 
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//goi phuong thuc trong service
		if( (LoginS.login(username, password)==true)){
			// Tạo hoặc lấy đối tượng HttpSession
            HttpSession session = req.getSession();
            
            // Đặt thuộc tính "user" vào session
            session.setAttribute("m", username);
            
            // Chuyển hướng đến trang chào mừng sau khi đăng nhập thành công
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
	
		}
		else {
			PrintWriter out = resp.getWriter();
			out.print("thất bại");
		}
		
	}


	private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// nhan du lieu tu view 
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password =req.getParameter("pass");
		String phone =req.getParameter("contact");
		// khoi tao model dua du lieu vao 
		Users user = new Users();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneNumber(phone);
		
		// goi phuong thuc insert trong service 
		LoginS.register(user);
		// chuyen trang  
		resp.sendRedirect(req.getContextPath()+"/Login");
	}

}
