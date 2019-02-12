public class User extends Person implements IDisplayable {
	private String status;
    private boolean isAgeVisible;
    
    public User(String fname, String lname, int age) {
        super(fname, lname, age);
        status = "What are you doing today?";
        isAgeVisible = true;
    }
	
    public void display() {
        System.out.println("Name: " + getFName() + " " + getLName());
        if(isAgeVisible) {
            System.out.println("Age: " + getAge());
        }
	}
	
    public void toggleVisibility() {
        isAgeVisible = !isAgeVisible;
    }
	
	public boolean getAgeVisibility() {
		return isAgeVisible;
	}
	
	public void setAgeVisibility(boolean isAgeVisible) {
		this.isAgeVisible = isAgeVisible;
	}
	
    public String getStatus() {
        return status;
    }
	
    public void setStatus(String status) {
        this.status = status;
    }
}