package com.my.main;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.beans.Student;
import com.my.service.StudentService;

public class Demo {

	/*
	 * 之前玩javaBean:
	 * 我们自己创建javaBean对象,自己给bean对象的属性赋值
	 */
	@Test
	public void testA(){
		//使用构造器创建出javaBean对象
		Student student = new Student();
		//调用set方法给属性赋值
		student.setSno(10101);
		student.setSname("张三");
		//测试
		System.out.println(student);
	}
	
	/*
	 * Spring玩javaBean:
	 * bean对象的创建和属性的赋值都由IOC容器去做,我们仅仅需要做的是拿到IOC容器,再从IOC容器拿所需的bean对象就行;
	 */
	@Test
	public void testB(){
		/*
		 * 1>创建IOC容器 ----- 创建ApplicationContext对象
		 *   ApplicationContext是接口类型
		 *   ClassPathXmlApplicationContext是ApplicationContext接口的一个实现类,表示通过加载
		 *   类路径下的参数名称的bean配置文件拿到IOC容器;
		 */
		ApplicationContext appContext = 
				 new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*
		 * 2>从IOC容器中获取bean对象:
		 *   调用IOC容器的getBean()方法,参数传递所要获取的bean对象的id引用名,返回值是Object类型需要强转;
		 */
		Student s1 = (Student) appContext.getBean("s1");
		//Student s1 = appContext.getBean(Student.class);
		
		//测试  Student [sno=10102, sname=李四]
		System.out.println(s1);
		
	}
	
	@Test
	public void testC(){
		ApplicationContext appContext = 
				 new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService) appContext.getBean("stuService");
		studentService.test();
	}
}














