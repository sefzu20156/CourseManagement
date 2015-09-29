package com.sql.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {

	private static Connection ct;
	private static ResultSet rs;
	private static PreparedStatement ps;
	
	private static String url="jdbc:sqlserver://localhost:1433;databaseName=CourseManagement";
	private static String id="sa";
	private static String passwd="123456789";
	private static String driver="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	
	//加载驱动
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//得到连接
	public static Connection getConnection(){
		try {
			ct=DriverManager.getConnection(url,id,passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ct;
	}
	
	//查询方法
		public static ResultSet executeQuery(String sql,String []parameters){
			try {
				ct=getConnection();
				ps=ct.prepareStatement(sql);
				if(parameters!=null && !parameters.equals("")){
					for(int i=0;i<parameters.length;i++){
						ps.setString(i+1, parameters[i]);
					}
				}
				rs=ps.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return rs;
		}
		
		//关闭资源
		public static void close(ResultSet rs,PreparedStatement ps,Connection ct){
			try {
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
				if(ct!=null) ct.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public static Connection getCt() {
			return ct;
		}
		
		public static ResultSet getRs() {
			return rs;
		}
		
		public static PreparedStatement getPs() {
			return ps;
		}
	
}
