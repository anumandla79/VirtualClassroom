package com.virtualclassrooms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.virtualclassrooms.model.Student;
import com.virtualclassrooms.model.Teacher;

public class TeacherDaoImpl implements TeacherDao{
	public Teacher insertTeacher(Teacher teacher) {
		Connection con=null;
		PreparedStatement pstmt =null;
		Statement stmt=null;
		try {
			con = new DbConnectionImpl().getConnection();
			String query = "INSERT INTO teachers(teacher_fullname, teacher_username, teacher_password,teacher_email) VALUES(?,?,?,?)";
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, teacher.getFullname());
			pstmt.setString(2, teacher.getUsername());
			pstmt.setString(3, teacher.getPassword());
			pstmt.setString(4, teacher.getEmail());

			int i=  pstmt.executeUpdate();
			query="select * from teachers where teacher_username='"+teacher.getUsername()+"'";
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			teacher.setId(rs.getInt("teacher_id"));
			if(i>0) {
				return teacher;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(con != null){
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public Teacher verifyStudent(String username, String password) {
		Connection con=null;
		Statement stmt =null;
		try {
			con = new DbConnectionImpl().getConnection();
			String query = "SELECT * FROM teachers WHERE teacher_username='"+username+"' AND teacher_password='"+password+"'";
			stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setFullname(rs.getString("teacher_fullname"));
				teacher.setUsername(rs.getString("teacher_username"));
				teacher.setPassword(rs.getString("teacher_password"));
				teacher.setEmail(rs.getString("teacher_email"));
				teacher.setId(rs.getInt("teacher_id"));
			
				return teacher;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(stmt != null){
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void insertRequest(int course_id, int teacher_id) {
		Connection con=null;
		PreparedStatement pstmt =null;
		try {
			con = new DbConnectionImpl().getConnection();
			String query = "INSERT INTO teacher_requests(course_id, teacher_id) VALUES(?,?)";
			pstmt= con.prepareStatement(query);
			pstmt.setInt(1, course_id);
			pstmt.setInt(2, teacher_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(pstmt != null){
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
		
	}

	public void deleteStudent(int id) {
		Connection con=null;
		PreparedStatement pstmt =null;
		try {
			con = new DbConnectionImpl().getConnection();
			String query = "DELETE from teachers where teacher_id='"+id+"'";
			pstmt= con.prepareStatement(query);
			pstmt.executeUpdate();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(pstmt != null){
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
		
	}

	public void updateTeacher(int id, String username, String fullname, String password, String email) {
		Connection con=null;
		PreparedStatement pstmt =null;
		try {
			con = new DbConnectionImpl().getConnection();
			String query = "Update teachers set teacher_username='"+username+"', teacher_fullname='"+fullname+"',teacher_password='"+password+"', teacher_email='"+email+"' where teacher_id='"+id+"'";
			pstmt= con.prepareStatement(query);
			pstmt.executeUpdate();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(pstmt != null){
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
		
	}

	public void updateStudentMarks(int student_id, int student_marks, int course_id) {
		Connection con=null;
		PreparedStatement pstmt =null;
		try {
			con = new DbConnectionImpl().getConnection();
			String query = "Update student_requests set student_marks='"+student_marks+"' where student_id='"+student_id+"' and course_id='"+course_id+"' and request_status='"+"approved"+"'";
			pstmt= con.prepareStatement(query);
			pstmt.executeUpdate();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(pstmt != null){
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
		
	}

}
