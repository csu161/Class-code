import java.util.*;

public class StudyGuide {

}

class Constructors {
    /* Why might we want some constructors to call other constructors?
     * If later we decide 'y' should count as a vowel, how many peices
     * of code will we have to change?
     */
    class Calling {
        private int vowels;
        private String data;
        public Calling(String data) {
            vowels = 0;
            this.data = data;
            for(char c : data.toCharArray())
                if("aeiou".contains("" + c)) vowels++;
        }

        public Calling(String first, String second) {
            this(first + ", " + second);
        }
    }

    /* When would be ever use a private constructor? Nobody
     */
    class PrivateConstructor {
        int data;
        private PrivateConstructor(int data) {
            this.data = data;
        }
    }

    class ProtectedConstructor {
        int data;
        protected ProtectedConstructor(int data) {
            this.data = data;
        }
    }
}

class Equals {
    int n;
    String s;
    List<Equals> more;

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof Equals)) return false;
        Equals other = (Equals) o;
        return n == other.n && s.equals(other.s) && more.equals(other.more);
    }

    // Collection: contains, containsAll, equals, remove, removeAll, retainAll
    // Collections: disjoint, frequency
}

class CompareTo implements Comparable<CompareTo> {
    int n;
    String s;
    List<CompareTo> more;

    private int compareLists(List<CompareTo> a, List<CompareTo> b) {
        // code here
        return -1;
    }

    @Override
    public int compareTo(CompareTo other) {
        if(n < other.n)
            return -1;
        int c = s.compareTo(other.s);
        if(c != 0) return c;
        return compareLists(more, other.more);
    }

    // sort, binarySearch, max, min
    // SortedSet, SortedMap, NavigableSet, NavigableMap
}

abstract class AbstractClasses {
    int n;
    public AbstractClasses() { n = 0; }
    public int getN() { return n; }

    // can instantiate?
    // want common functionality and data but doesn't make sense on its own
}

interface NicePrinting {
}
class User implements NicePrinting {
    int id;
    String name;
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String toString() {
        return String.format("User with name \"%s\" (id: %d)", name, id);
    }
}

interface IntProducer {
    int getInt();
}
abstract class NumberFarm implements IntProducer {
    // solutions?
}

/*
1. Which of the following can be implemented with lists?
  a. stacks
  b. queues
  c. sets
  d. maps

2. Consider the following class:
class A {
    public final List<String> strings;
    public A(List<String> s) { strings = s; }
}
  Can code outside the class change
  a. strings to reference a different list object?
  b. the string at position 0 of strings to a different string?
  c. the char at position 0 of the string at position 0 of strings to a different char?
  For d, e, f, the same questions but for code inside the class

3. If I have an application where I want to look up student objects by their
   corresponding student ID's, which flavor of data structure should I use?

4. Why is binary search desirable?
  a. it's easy to implement
  b. it helps us keep data sorted
  c. it requires a small amount of work relative to the number of elements to search through

5. Does binary search require the input to be sorted? Or is that just for performance?

6. Name three recursive algorithms that you coded in lab.

7. Write the following classes (the interfaces are already written)
Node class
  * String and next (private member variables)
  * one and two arg constructor (one arg should call two arg)
  * getters, setters

interface IList {
    void add(String, int);
    void remove(int);
    String get(int);
    int size();
}

class List implements IList
  * protected Node head, private int size
  * zero arg constructor

class Deque extends List
  * void addFirst(String)
  * void addLast(String)
  * String popFirst()
  * String popLast()

interface IStack {
    void push(String);
    String peek();
    String pop();
}

class Stack extends Deque implements IStack

interface IQueue {
    void add(String);
    String take();
}

class Queue extends Deque implements IQueue

interface ISet {
    boolean contains(String);
    void add(String);
    void remove(String);
}

class Set extends List implements ISet
  * use protected member variable to efficiently implement method
    * private int positionOf(String)
  * use position of to implement the other three methods

*/

class LongSeq {
    private final long first;
    private final LongSeq rest;
    public LongSeq(long first, LongSeq rest) {
        this.first = first;
        this.rest = rest;
    }

    public LongSeq(long first) {
        this(first, null);
    }

    public long first() {
        return first;
    }

    public LongSeq rest() {
        return rest;
    }

    public LongSeq add(long s) {
        return new LongSeq(s, this);
    }

    public long min() {
        // write a recursive method to return the minimum long in this sequence
        return (long) 99;
    }

    public LongSeq addLast(long s) {
        // write a recursive method to return this sequence of longs with s at the end
        return null;
    }

    @Override
    public String toString() {
        // write a recursive method to return a string representing this sequence of longs
        // for example "14" or "13, 14" or "5, 13, 14"
        return "";
    }

    public static void main(String[] args) {
        LongSeq a = new LongSeq(102L).add(14L).add(13L).add(20L);
        // make sure you test your code.
    }
}

/*
1. Prove with induction that 1^3 + 2^3 + ... + n^3 = ((n * (n + 1)) / 2)^2 for all n greater than 0
2. Prove with induction that 6 evenly divides n^3 - n for all non-negative n.
*/

/* xPy means "x permute y", and xCy means "x choose y"
1. 13P4 = ?
2. 13C4 = xPy / wPz. What are x,y,w,z?
3. I have 8 shirts, one of which is gray. I have 3 pairs of pants, one of which is gray. How many shirt-pants combinations can I make that involve a gray article of clothing?
4. A group of 14 friends put in a pizza order for pick-up. Somebody has to go pick up the pizza. But nobody wants to go alone and no pair of people want to go as just the two of them. At least three people need to go on the pizza run. How many different subsets of people could go on the pizza run?
5. There are six books, called A, B, C, D, E, F. How many ways can you put these books on a shelf such that A is to the left of C?
6. Find n if
  6.1 nP2 = 110
  6.2 nPn = 5040
  6.3 nP4 = 12 * nP2
*/


/*
Be familiar with methods in java.util.Collection.
Which package would you google if you wanted collection that are thread-safe?
*/
