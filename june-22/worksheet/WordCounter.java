import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private static class Counter {
        // declare a private long member variable
    	private long member;
    	
        // write a no argument constructor, starts at 0
    	public Counter() {
    		this.member = 0;
    	}

        // write a method "current" to get the current value
    	public long current() {
    		return this.member;
    	}

        // write a method, "inc" to increment the value
    	public double inc() {
    		return this.member++;
    	}

        // write an equals and toString with @Override
    	@Override
    	public String toString() {
    		return String.format("Here's the string: %s", Double.toString(member));
    	}
    	
    	@Override
    	public boolean equals(Object o) {
    		if (o instanceof Counter) {
    			Counter counter = (Counter) o;
    			return this.member == (counter.member);
    		}
    		return false;
    	}
    }

    private final Map<String, Counter> counts;

    public WordCounter() {
        counts = new HashMap<String, Counter>();
    }

    public void count(String s) {
        Counter c = counts.get(s);
        if(c != null)
            c.inc();
        else {
            counts.put(s, new Counter());
            count(s);
        }
    }

    public long countOf(String s) {
        Counter c = counts.get(s);
        if(c != null)
            return c.current();
        return 0;
    }

    // write an equals and toString with @Override
    // hint, don't work too hard, leverage HashMap's equals and toString
    
    @Override
    public String toString() {
    	return String.format("Here's the WordCounter string: %s", counts.toString());
    }
    
    @Override
    public boolean equals(Object o) {
    	if(o instanceof WordCounter) {
    		WordCounter wc = (WordCounter) o;
    		//match the maps
    		return this.counts.equals(wc.counts);
    	}
    	return false;
    }

    public String highestCount() {
        // code here to return the highest count String
        return null;
    }
    
    public static void main(String[] args) {
    	System.out.println("WordCounter Start");
    	WordCounter wc = new WordCounter();

    	System.out.println(wc.toString());
    	
    }
}
