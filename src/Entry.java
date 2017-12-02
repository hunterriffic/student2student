public class Entry {
    private String entryName;
    private String description;
    private User creator;
    private static ArrayList<Tag> tags = new ArrayList<Tag>();
}

// constructs an Entry
public Entry(String entryName, String description, User creator, ArrayList<Tag> tags) {
    this.entryName = entryName;
    this.description = description;
    this.creator = creator;
    this.tags = tags;
}

public void AddTag(tag toAdd) {
    // add tag to entry
}
