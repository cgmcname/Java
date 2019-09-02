package GPA;

public class Main 
{

	public static void main(String[] args) 
	{
		Student one = new Student();
		Student two = new Student("Bob");
		//Student three = new Student("Sally");
		//Student four = new Student("Dave");
		
		System.out.println(one.getName());
		System.out.println(one.getID());
		
		System.out.println("");
		
		System.out.println(two.getName());
		System.out.println(two.getID());
		
		System.out.println("");
	
		//System.out.println(two.getClassGradePoint());
		two.setList("Math", 9922, 3, 'A');
		two.setList("Math", 9922, 3, 'a');
		two.setList("Math", 9922, 3, 'b');
		two.setList("Math", 9922, 3, 'c');
		two.setList("Math", 9922, 3, 'A');
		//two.showClasses();
		
		
		System.out.println(two.calClasses());
		
	}

}
