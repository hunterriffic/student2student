public class User {
    private String name;
}

// Constructs a User
public User(String name) {
    this.name = name;
    private static ArrayList<Tag> tags = new ArrayList<Tag>();
}

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