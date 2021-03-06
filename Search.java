import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.Iterator;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.ListIterator;

public class Search {
    protected Tag root;
    ArrayList<User> users = new ArrayList<>();

    public Search(ArrayList<Tag> tags) {
        if (tags == null)
            throw new NullPointerException("One or more arguments null");
        // Represent the root as a dummy/placeholder node
        root = new Tag("", 0, null);

        for (Tag t : tags) {
            add(t);
        }
    }

    private void add(Tag input) {
        if (input == null) { //Checking if tag is null
            throw new NullPointerException();
        }
        Tag cur = root;
        for (int i = 0; i < input.level; i++) { //Iterating through the tree
            cur = cur.getChild(input.getName()); //Increments current tag
        }
        if (cur.getChild(input.getName()) == null) { //Checking to see if cur has the specified tag
            Tag t = new Tag(input.getName(), input.level, cur); //Creating new tag
            cur.children.put(input.getName(), t); //And add it as a child
        }
    }

    public ArrayList<User> getMatches(String name) {
        if (name == null) {
            throw new NullPointerException();
        } //Checking if prefix is null
        else {
            ArrayList<User> output = new ArrayList<>();
            for (User u : users) {
                if (u.returnTag().contains(name)) {
                    output.add(u);
                }
            }
            return output;
        }
    }

    public ArrayList<Tag> getSiblings(String name) {
        Tag cur = root;
        ArrayList<Tag> output = new ArrayList<>();

        if (cur.children.containsKey(name)) {
            Collection<Tag> vals = cur.children.values();
            for (Tag t : vals) {
                output.add(t);
            }
            return output;
        }
        else {
            PriorityQueue<Tag> queue = new PriorityQueue<>();
            Collection<Tag> vals = cur.children.values();
            for (Tag t : vals) {
                queue.add(t);
            }
            while (!queue.isEmpty()) {
                Tag current = queue.poll();
                if (current.children.containsKey(name)) {
                    vals = current.children.values();
                    for (Tag v : vals) {
                        output.add(v);
                    }
                } else if (current.children.size() > 0) {
                    vals = current.children.values();
                    for (Tag v : vals) {
                        queue.add(v);
                    }
                }
            }
            return output;
        }
    }

//    class EntryComparator implements Comparator<Entry> {
//        public int compare(Entry a, Entry b) {
//            if (a.date > b.date) { return -1; }
//            else if (a.date < b.date) { return 1; }
//            return 0;
//        }
//    }
}