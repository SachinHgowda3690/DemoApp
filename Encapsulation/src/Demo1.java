class Student
{
	private int age;
	private String name;
	private String city;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
public class Demo1 {

	public static void main(String[] args) {
		Student s=new Student();
		s.setAge(64);
		s.setName("nirin");
		s.setCity("bangalore");
		
		System.out.println(s.getAge()+"  "+s.getName()+"  "+s.getCity());

	}

}
