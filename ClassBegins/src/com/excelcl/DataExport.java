package com.excelcl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.domain.Courses;
import com.sql.util.SqlHelper;

/**
 * 这是将数据从数据库导出的一个类
 * @author Administrator
 *
 */

public class DataExport {
	
	public ArrayList<Courses> queryCourses(){
		
		ArrayList<Courses> courseData=new ArrayList<Courses>();
		
		String sql="select * from 课程信息表";
		
		ResultSet rs=SqlHelper.executeQuery(sql, null);
		
		if(rs == null){
			System.out.println("No Result.");
			return courseData;
		}
		try {
			System.out.println("Something Happendsfasd.");
			while(rs.next()){
				Courses course=new Courses();
				
				
				course.setGrade(rs.getString(1));
				course.setMajor(rs.getString(2));
				course.setMajorNum(rs.getString(3));
				course.setCourseName(rs.getString(4));
				course.setType(rs.getString(5));
				course.setCredit(rs.getString(6));
				course.setHour(rs.getString(7));
				course.setSyhour(rs.getString(8));
				course.setSjhour(rs.getString(9));
				course.setWeek(rs.getString(10));
				course.setTeacher(rs.getString(11));
				course.setRemarks(rs.getString(12));
				
				courseData.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		
		return courseData;
	}

}
