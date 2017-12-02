public class Entry {
    private String entryName;
    private String description;
    private User creator;
}

// constructs an Entry
public Entry(String entryName, String description, User creator) {
    this.entryName = entryName;
    this.description = description;
    this.creator = creator;
    private static ArrayList<Tag> tags = new ArrayList<Tag>();

public void AddTag(int indexToAdd, Tag tagToAdd) {
    // add tag to entry based on array index
        int size = tags.size();
        tags.add(tagToAdd, size);
        System.out.println(tagToAdd.getName + " successfully added");
}
