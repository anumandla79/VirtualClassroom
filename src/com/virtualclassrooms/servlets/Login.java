package com.virtualclassrooms.servlets;

import java.io.IOException;

import com.virtualclassrooms.model.Student;
import com.virtualclassrooms.model.Teacher;
import com.virtualclassrooms.services.StudentServices;
import com.virtualclassrooms.services.StudentServicesImpl;
import com.virtualclassrooms.services.TeacherServices;
import com.virtualclassrooms.services.TeacherServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String user=req.getParameter("profession");
		if(user.equals("admin")) {
			String pass=req.getParameter("pass");
			String username=req.getParameter("username");
			if(pass.equals("admin") && username.equals("admin")) {
				HttpSession session = req.getSession();
				session.setAttribute("fullname","admin");
				session.setAttribute("user","admin");
				RequestDispatcher rd = req.getRequestDispatcher("admin/admin_home.jsp");
				rd.forward(req, res);
			}else {
				res.sendRedirect("login.html");
			}
		}
		else if(user.equals("student")) {
			String username=req.getParameter("username");
			String password=req.getParameter("pass");
			StudentServices ss=new StudentServicesImpl();
			Student student =ss.verifyStudent(username, password);
			if(student!=null) {
				HttpSession session = req.getSession();
				session.setAttribute("student",student);
				session.setAttribute("user","student");
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, res);
			}else {
				res.sendRedirect("login.html");
			}
			
		}else if(user.equals("teacher")){
			String username=req.getParameter("username");
			String password=req.getParameter("pass");
			TeacherServices ss=new TeacherServicesImpl();
			Teacher teacher=ss.verifyTeacher(username, password);
			if(teacher!=null) {
				HttpSession session = req.getSession();
				session.setAttribute("teacher",teacher);
				session.setAttribute("user","teacher");
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, res);
			}else {
				res.sendRedirect("login.html");
			}
			
		}else {
			res.sendRedirect("login.html");
		}
	}
}
