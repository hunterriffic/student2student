import java.util.ArrayList;

public class User {
    private String name; 
    private ArrayList<Tag> tags;
    
// Constructs a User
	public User(String name, ArrayList<Tag> tags) {
		this.name = name;
		this.tags = tags;
	}

    public void addTag(Tag tagToAdd) {
        // add tag to entry based on array index
        if (tags.contains(tagToAdd)) return;
      
        tags.add(tagToAdd);
        System.out.println(tagToAdd.getName() + " successfully added");
        return;
    }

    public void removeTag(Tag tagToRemove) {
        tags.remove(tagToRemove);
        return;
    }
    
    public ArrayList<Tag> returnTag() {
    		return tags;
    	}
}