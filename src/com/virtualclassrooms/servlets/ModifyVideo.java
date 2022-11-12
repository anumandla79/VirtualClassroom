package com.virtualclassrooms.servlets;

import java.io.IOException;

import com.virtualclassrooms.dao.AdminDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifyVideo
 */
@WebServlet("/modifyVideo")
public class ModifyVideo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int video_id=Integer.parseInt(request.getParameter("video_id"));
		String operation = (String)request.getParameter("operation");
		if(operation.equals("approved")){
			new AdminDaoImpl().approveVideo(video_id,operation);
			response.sendRedirect("viewVideos");
		}
		else if(operation.equals("unapproved")){
			new AdminDaoImpl().approveVideo(video_id,operation);
			response.sendRedirect("viewVideos");
		}
		if(operation.equals("delete")){
			new AdminDaoImpl().deleteVideo(video_id);
			response.sendRedirect("viewVideos");
		}
		
	}
}
