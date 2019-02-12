public abstract class Person {
	private String fname;
	private String lname;
	private int age;
	
	public Person(String fname,String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }
    
	//getters    
    public int getAge() {
        return age;
    }
    public String getLName() {
        return lname;
    }
    public String getFName() {
        return fname;
    }
    
    //setters
    public void setAge(int age) {
        this.age = age;
    }
    public void setFName(String fname) {
        this.fname = fname;
    }
    public void setLName(String lname) {
        this.lname = lname;
    }
}