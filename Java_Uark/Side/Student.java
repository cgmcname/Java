package GPA;

import java.io.*; 
import java.util.*; 
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class Student 
{
	private String name;
	private int id = 0;
	private double gradeAvg;
	private double hourTotal;
	
	static private int members = 0;
	
	//private Classes test;
	List<Classes> courseLoad = new ArrayList<>();
	
	Student()
	{
		
		name = "";
		id = ++members;
		//setList();
		
		
	
	}
	
	
	Student(String n)
	{
		this();
		name = n;
		
	}
	
	String getName() 
	{
		return name;
	}
	
	int getID()
	{
		return id;
	}
	
	void setList(String n, int cNumber, int cHours, char g) 
	{
		courseLoad.add(new Classes(n, cNumber, cHours, Character.toUpperCase(g)));
		
		
	}
	//double getClassGradePoint()
	//{
	//	return test.getGradePoint();
	//}

	void showClasses()
	{
		courseLoad.forEach(Classes -> {
            System.out.println("Name : " + Classes.getCourseName() + ", GradePoint : " + Classes.getGradePoint());
        });
	}
	
	void howManyClasses() 
	{
		System.out.println(courseLoad.size());
	}
	
	double calClasses()
	{
		courseLoad.forEach(Classes -> {
			gradeAvg += Classes.getGradePoint() * Classes.getCourseHours();
			hourTotal += Classes.getCourseHours();
        });
		
		
		gradeAvg = gradeAvg/hourTotal;
		
		
		return gradeAvg;
	}
	
	
	
}
