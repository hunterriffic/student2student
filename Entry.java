import java.util.ArrayList;

public class Entry {
    private String entryName;
    private String description;
    private User creator;
    private ArrayList<Tag> tags = new ArrayList<Tag>();


// constructs an Entry
public Entry(String entryName, String description, User creator, ArrayList<Tag> tags) {
    this.entryName = entryName;
    this.description = description;
    this.creator = creator;
    this.tags = tags;
}
    

public void AddTag(Tag tagToAdd) {
    // add tag to entry based on array index
	 	if (tags.contains(tagToAdd)) return;
	
		tags.add(tagToAdd);
        System.out.println(tagToAdd.getName() + " successfully added");
        return;
}

public void RemoveTag(Tag tagToRemove) {
        tags.remove(tagToRemove);
        return;
}

}
