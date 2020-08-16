package com.my.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.my.dao.StudentDao;

/*
 * StudentDao的工厂类:
 * 使用工厂设计模式,创建出StudentDao接口对应的实现类对象;
 */
public class StudentDaoFactory {

	private static String studentDaoName;
	
	static{
		Properties pts = new Properties();
		try {
			InputStream in = new FileInputStream("src/studentDao.properties");
			pts.load(in);
			studentDaoName = pts.getProperty("studentDao");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//静态工厂方法
	public static StudentDao getStudentDao(){
		try {
			Class c = Class.forName(studentDaoName);
			StudentDao stuDao = (StudentDao) c.newInstance();
			return stuDao;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
