package com.my.service;

import com.my.dao.StudentDao;

/*
 * 学生业务类:
 */
public class StudentService {

	/*
	 * service依赖于dao,一般就是将dao定义为service的成员变量;
	 */
	
	//1)明确接口类型和实现类类型
	//private StudentDao studentDao = new StudentDaoA();
	
	//2)工厂设计模式:只需要明确接口类型,再通过工厂类去获取对应的实现类对象即可
	//private StudentDao studentDao = StudentDaoFactory.getStudentDao();
	
	/*
	 * 3)
	 * service类需要接口对象,IOC容器就会将接口的指定实现类对象自动注入给
     * service类。
	 */
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void test(){
		studentDao.show();
	}
	
}
