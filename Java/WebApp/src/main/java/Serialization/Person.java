package Serialization;

import java.io.*;

import jakarta.xml.bind.annotation.*;

@XmlRootElement
public class Person implements Serializable{
	private static final long serialVersionUID =1L;
	//@XmlElement(name="felhasznalo")
	private String name;
	private String birthPlace;
	private transient int birthYear;
	
	public Person() {
	}
	
	public Person(String name,String birthPlace,int birthYear) {
		this.name=name;
		this.birthPlace=birthPlace;
		this.birthYear=birthYear;
	}
	
	public String getName() {
		return name;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setName(String name) {
		this.name = name;;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	@Override
	public String toString(){
		return "Person{"+"name"+name+"birthPlace"+birthPlace+"birthYear"+birthYear+"}";
	}
}
