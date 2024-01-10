package oe.lesson2;

public class person implements Comparable {
	private String name;
	private int age;
	
	public person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	public  String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age=age;
	}
	
	@Override
	public int compareTo(Object o) {
		return Integer.compare(this.age, ((person)o).getAge());
	}
	@Override
	public String toString() {
		return "Person{" + " name= "+ name + ", age= " + age + "}";
	}
}
