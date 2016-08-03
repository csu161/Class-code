class Node {
    private String data;
    private Node next;
    public Node(String data, Node next)
    {
        this.data = data;
        this.next = next;
    }
    public Node(String data) {
        this(data, null);
    }
    public String getData() { return data; }
    public Node getNext() { return next; }
    public void setData(String data) { this.data = data; }
    public void setNext(Node next) { this.next = next; }
}

public class List {
    private int size;
    protected Node head;
    public List() { size = 0; head = null; }
    public int size() { return size; }

    private Node nodeBefore(int pos) {
        Node before = head;
        for(int i = 0; i < pos - 1; ++i)
            before = before.getNext();
        return before;
    }

    private static void checkBounds(int pos, int low, int high) {
        if(!(low <= pos && pos < high))
            throw new IndexOutOfBoundsException();
    }

    public void add(String s, int pos) {
        checkBounds(pos, 0, size + 1);
        size++;
        if(pos == 0) {
            head = new Node(s, head);
            return;
        }
        Node before = nodeBefore(pos);
        before.setNext(new Node(s, before.getNext()));
    }

    public void remove(int pos) {
        checkBounds(pos, 0, size);
        size--;
        if(pos == 0) {
            head = head.getNext();
            return;
        }
        Node before = nodeBefore(pos);
        before.setNext(before.getNext().getNext());
    }

    public String get(int pos) {
        checkBounds(pos, 0, size);
        if(pos == 0) return head.getData();
        return nodeBefore(pos + 1).getData();
    }
}

class Deque extends List {
    public void addLast(String s) {
        add(s, size());
    }

    public void addFirst(String s) {
        add(s, 0);
    }

    public String popFirst() {
        String s = get(0);
        remove(0);
        return s;
    }

    public String popLast() {
        int last = size() - 1;
        String s = get(last);
        remove(last);
        return s;
    }
}

class Queue extends Deque {
    public void enqueue(String s) {
        addFirst(s);
    }
    public String dequeue() {
        return popLast();
    }
}

class Stack extends Deque {
    public void push(String s) {
        addFirst(s);
    }
    public String peek() {
        return get(0);
    }
    public String pop() {
        return popFirst();
    }
}

class Set extends List {
    private int positionOf(String s) {
        Node n = head;
        for(int i = 0; n != null; n = n.getNext(), ++i)
            if(n.getData().equals(s))
                return i;
        return -1;
    }
    public boolean contains(String s) {
        return positionOf(s) != -1;
    }
    public void add(String s) {
        if(!contains(s))
            add(s, 0);
    }
    public void remove(String s) {
        int pos = positionOf(s);
        if(pos != -1)
            remove(pos);
    }
}
