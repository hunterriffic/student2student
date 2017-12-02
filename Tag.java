import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Tag implements Comparable<Tag> {
    String tagName;
    int level;
    Map<String, Tag> children;
    Tag parent;

    public Tag(String tagNameIn, int levelIn, Tag parentTag) {
        tagName = tagNameIn;
        level = levelIn;
        children = new HashMap<String, Tag>();
        parent = parentTag;
    }

    public void setName(String name) {
        tagName = name;
    }

    public String getName() {
        return tagName;
    }

    public void setLevel(int levelIn) {
        level = levelIn;
    }

    public int getLevel() {
        return level;
    }

    Tag getChild(String name) {
        return children.get(name);
    }

//    @Override
//    public int compareTo(Tag t) {
//        // Sort in weight ascending
//        if (this.myWeight < o.myWeight) {
//            return -1;
//        } else if (this.myWeight > o.myWeight) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
}
