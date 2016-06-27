import java.io.File;
import java.util.Scanner;
import java.util.Iterator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileNotFoundException;

//class && constructor of ScanTwoFiles class example
public class TestCopy implements Iterator<String> { 
	private Iterator<String> s1;
	private Iterator<String> s2;
	private boolean s1Done = false;
	
	public TestCopy (File f1, File f2) throws FileNotFoundException {
		s1 = new Scanner(f1);
		s2 = new Scanner(f2);
	}
	@Override
	public String next() {
		return !s1Done ? s1.next() : s2.next();
	}
	@Override
	public boolean hasNext() {
		if(!s1Done) {
			boolean a = s1.hasNext();
			if(!a) {
				s1Done =true;
				//small example of recurrsion
				return hasNext();
			}
			else {
				return a;
			}
		} else {
			return s2.hasNext();
		}
	}	
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove not supported");
		
	}
    public static void main(String[] args) throws FileNotFoundException{
        // write a basic test to check your work
//        copyFromTo(new File(args[0]), new File(args[1]));
    	System.out.println("tried");
    	TestCopy s = new TestCopy(new File(args[0]), new File(args[1]));
    
    	while(s.hasNext()) {
    		System.out.println(s.next());
    	}
    }
    
}