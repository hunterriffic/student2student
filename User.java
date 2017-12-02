import java.util.ArrayList;

public class User {
    String name;
    
// Constructs a User
	public User(String name) {
		this.name = name;
	}

    public void setName(String nameIn) {
	    name = nameIn;
    }

    public String getName() {
	    return name;
    }
}