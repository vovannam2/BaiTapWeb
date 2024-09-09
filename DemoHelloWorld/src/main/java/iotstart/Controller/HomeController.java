package iotstart.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns ={"/Home"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ten = req.getParameter("ten");
		// Set response content type
		 resp.setContentType("text/html");
		 // Actual logic goes here.
		 PrintWriter printW = resp.getWriter();
		 printW.println(ten);
		 printW.close();
	}
	
	
	
}
