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

public static class Search {
    protected Tag root;

    public Search(String[] tags) {
        if (terms == null)
            throw new NullPointerException("One or more arguments null");
        // Represent the root as a dummy/placeholder node
        root = new Tag("", 0, null);

        for (int i = 0; i < tags.length; i++) {
            add(tags[i]);
        }
    }

    private void add(Tag input) {
        if (input == null) { //Checking if tag is null
            throw new NullPointerException();
        }
        Tag cur = root;
        for (int i = 0; i < input.level; i++) { //Iterating through the tree
            cur = cur.getChild(input.name); //Increments current tag
        }
        if (cur.getChild(name) == null) { //Checking to see if cur has the specified tag
            Tag t = new Tag(input.name, input.level, cur)//Creating new tag
            cur.children.put(input.name, t); //And add it as a child
        }
    }

    public Iterable<String> getMatches(String name) {
        // TODO: Implement topKMatches
        if (prefix == null) { throw new NullPointerException(); } //Checking if prefix is null
        else {
            Node cur = myRoot;

            for (int i = 0; i < prefix.length(); i++) { //Iterating through the prefix
                char c = prefix.charAt(i); //Current letter
                if (cur.getChild(c) == null) { //Checking if cur has children
                    return new ArrayList<String>(); //If not, returns empty list
                }
                cur = cur.getChild(c); //Increments cur
            }
            double maxWeight = cur.mySubtreeMaxWeight;

            NodeComparator comp = new NodeComparator();
            PriorityQueue<Node> q = new PriorityQueue<>(comp); //This queue will contain all nodes that will be checked if they are a word
            PriorityQueue<Node> wordQueue = new PriorityQueue<>(comp); //Contains only words

            Collection<Node> values = cur.children.values(); //Contains the children of cur
            for (Node n : values) {
                q.add(n); //Adding children to q
            }

            while (!q.isEmpty()) { //While q is not empty
                if (q.peek().children.size() < 0) { continue; } //If there are no children of the specified node
                Collection<Node> c = q.poll().children.values(); //Contains the specified node's children
                for (Node n : c) {
                    q.add(n); //Adding the children to q
                    if (n.isWord) { wordQueue.add(n); } //Adding node n to wordQueue if it is a word
                }
            }

            ArrayList<String> output = new ArrayList<String>(); //List of strings
            ListIterator<String> listerator = output.listIterator(); //Iterator over the list
            for (int i = 0; i < k; i++) {
                if (!wordQueue.isEmpty()) { //While wordQueue is not empty
                    listerator.add(wordQueue.poll().getWord()); //Add word to output list
                }
            }
            return output;
        }
    }

    class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.mySubtreeMaxWeight > b.mySubtreeMaxWeight) { return -1; }
            else if (a.mySubtreeMaxWeight < b.mySubtreeMaxWeight) { return 1; }
            return 0;
        }
    }