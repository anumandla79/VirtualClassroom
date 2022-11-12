package com.virtualclassrooms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDaoImpl {
	public int insertCourse(String course) {
		PreparedStatement pstmt = null ;
		try(Connection con =new DbConnectionImpl().getConnection()){
			String query="INSERT INTO courses(course_name) VALUES(?)";
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, course);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 0;
	}

	public void deleteCourse(int course_id) {
		PreparedStatement pstmt = null ;
		try(Connection con =new DbConnectionImpl().getConnection()){
			String query="Delete from courses where course_id='"+course_id+"'";
			
			pstmt=con.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return;
		
	}

	public void approveStudent(int course_id, int student_id) {
		PreparedStatement pstmt = null ;
		try(Connection con =new DbConnectionImpl().getConnection()){
			String query="Update student_requests set request_status='approved' where course_id='"+course_id+"' and student_id='"+student_id+"'";
			
			pstmt=con.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return;
		
	}

	public void approveTeacher(int course_id, int teacher_id) {
		PreparedStatement pstmt = null ;
		try(Connection con =new DbConnectionImpl().getConnection()){
			String query="Update teacher_requests set request_status='approved' where course_id='"+course_id+"' and teacher_id='"+teacher_id+"'";
			
			pstmt=con.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return;
		
	}

	public void deleteTeacherRequest(int course_id, int teacher_id) {
		PreparedStatement pstmt = null ;
		try(Connection con =new DbConnectionImpl().getConnection()){
			String query="delete from teacher_requests where course_id='"+course_id+"' and teacher_id='"+teacher_id+"'";
			
			pstmt=con.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return;
		
	}

	public void deleteStudentRequest(int course_id, int student_id) {
		PreparedStatement pstmt = null ;
		try(Connection con =new DbConnectionImpl().getConnection()){
			String query="delete from student_requests where course_id='"+course_id+"' and student_id='"+student_id+"'";
			
			pstmt=con.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return;
		
	}

	public void addVideo(int course_id, String filepath, String user, String title) {
		PreparedStatement pstmt = null ;
		try(Connection con =new DbConnectionImpl().getConnection()){
			String query="INSERT INTO videos(course_id,video_filepath,uploader,video_title) VALUES(?,?,?,?)";
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, course_id);
			pstmt.setString(2, filepath);
			pstmt.setString(3, user);
			pstmt.setString(4,title);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return;
		
	}

	public void approveVideo(int video_id, String operation) {
		PreparedStatement pstmt = null ;
		try(Connection con =new DbConnectionImpl().getConnection()){
			String query="Update videos set video_status=? where video_id='"+video_id+"'";
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, operation);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return;

	}

	public void deleteVideo(int video_id) {
		PreparedStatement pstmt = null ;
		try(Connection con =new DbConnectionImpl().getConnection()){
			String query="Delete from videos where video_id='"+video_id+"'";
			
			pstmt=con.prepareStatement(query);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return;
		
	}

	
}
