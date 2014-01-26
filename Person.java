public class Person {
	private final String name;
	
	public Person(String name) { 
		this.name = name;
	}
	public String getName() //missing bracket
		return this.name;
	}
	public void setName(String name) { //can't have a setter for a final variable
		this.name = name;
	} 
}