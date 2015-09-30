package com.excelcl;

import java.io.File;
import java.util.ArrayList;

import com.domain.Courses;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import com.sql.util.*;

public class ExcelImport {

	public static void main(String[] args){
	
	try {
		//设置workbook的编码方式以解决乱码问题
		WorkbookSettings workbookSettings = new WorkbookSettings();
        workbookSettings.setEncoding("UTF-8");
        //创建一个workbook对象
		Workbook workbook = Workbook.getWorkbook(new File("d:/courses.xls"));
		//创建sheet工作表
		Sheet sheet=workbook.getSheet(0);
		for(int i=2;i<sheet.getRows();i++){
			ArrayList<String> data=new ArrayList<String>();
			for(int j=0;j<sheet.getColumns();j++){
				Cell cell=sheet.getCell(j,i);
				//data.add(j,cell.getContents().replaceAll(String.valueOf((char) 160),""));
				System.out.print(cell.getContents().replaceAll(String.valueOf((char) 160),"")+"   ");
			}
			System.out.println();
			//addCourse(getCourse(data));
		}
		workbook.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
    }
	
	/**
	 * 将Excel导出的数据添加到course对象中
	 * @param data
	 * @return
	 */
	public static Courses getCourse(ArrayList<String> data){

		Courses course=new Courses();

		course.setGrade(data.get(0));
		course.setMajor(data.get(1));
		course.setMajorNum(data.get(2));
		course.setCourseName(data.get(3));
		course.setType(data.get(4));
		course.setCredit(data.get(5));
		course.setHour(data.get(6));
		course.setSyhour(data.get(7));
		course.setSjhour(data.get(8));
		course.setWeek(data.get(9));
		course.setTeacher(data.get(10));
		course.setRemarks(data.get(11));
		
		return course;
	}
	
    /**
     * 将课程对象添加到数据库中
     * @param course
     */
	public static void addCourse(Courses course){

		String sql="insert into 课程信息表  values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String parameters[]={course.getGrade(),
				             course.getMajor(),
				             course.getMajorNum(),
				             course.getCourseName(),
				             course.getType(),
				             course.getCredit(),
				             course.getHour(),
				             course.getSyhour(),
				             course.getSjhour(),
				             course.getWeek(),
				             course.getTeacher(),
				             course.getRemarks()};
		
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
