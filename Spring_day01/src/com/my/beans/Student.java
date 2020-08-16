package com.my.beans;
/*
 * 学生javaBean类:
 */
public class Student {

	private Integer sno;
	
	private String sname;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
		System.out.println("sno属性被赋值了.....");
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
		System.out.println("sname属性被赋值了.....");
	}

	public Student() {
		System.out.println("Student对象被创建了.....");
	}

	public Student(Integer sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + "]";
	}
    	
}
