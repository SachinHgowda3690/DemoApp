class Student 
{
	static int sId;
	String sName;
	
	void playCricket()
	{
		System.out.println("student is playing cricket");
	}
	
	void sleep()
	{
		System.out.println("student is sleeping");
	}
}
public class Test {

	public static void main(String[] args) {
		
		Student std=new Student();
		
		
		System.out.println(std.sId=10);
		System.out.println(std.sName="sachin");
		std.playCricket();
		std.sleep();

	}

}
