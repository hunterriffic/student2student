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

public void AddTag(Tag tagToAdd) {
    // add tag to entry based on array index
        for (int i = 0; i < tags.size(); i++) {
            if (tagToAdd.getName == tags(i).getName) {
                System.out.println("Tag already added");
                return;
            }
        }
        //int size = tags.size();
        tags.add(tagToAdd);
        System.out.println(tagToAdd.getName + " successfully added");
        return;
}

public void RemoveTag(Tag tagToRemove) {
        tags.remove(tagToRemove);
        return;
}
