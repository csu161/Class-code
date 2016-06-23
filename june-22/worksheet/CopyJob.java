import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyJob {
    // declare a boolean member variable called "done" initially set to false
	private boolean done = false;

    // declare a final member variable of type File called "source"
	private final File source;

    // declare a final member variable of type File[] called "destinations"
	private final File[] destinations;

    // create a constructor that takes a source File and an array of destination Files
    // verifies that source File canRead (it's a method you can call on Files)
    // trys calling createNewFile on all destinations, then call canWrite on each
    // if the first step does not throw an exception and the second step returns true
    // then we will be able to copy into that file!	
	public CopyJob (File f, File[] fa) {
		this.source = f;
		this.destinations = fa;
		
		if(f.canRead()) {
			
			for(int i=0; i < fa.length; i++) {
				try {
					fa[i].createNewFile();
					if (fa[i].canWrite()) {
						this.done = true;
					}
					else {
						this.done = false;
					}
					
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

    // create a constructor that takes a source File and a destination File
    // calls previous constructor
	public CopyJob (File f, File fd) {
		this(f, new File[] {fd});
	}

    // create a static method, called fromStrings, that takes a source String
    // filename and an array of destination String filenames,
    //calls the first constructor, and returns the resulting object
	public static CopyJob fromStrings(String src, String[] dest) {
		File f = new File(src);
		File [] fa = new File[dest.length];
		for (int i = 0; i < dest.length; i++) {
			File fd = new File(dest[i]);
			fa[i] = fd;
		}
		return new CopyJob(f, fa);
	}

    // create a non-static method, called "copyAll", that repeatedly calls
    // copyFromTo for each of the destination files
    // then sets the "done" boolean to true

    // create a non-static method, called "isDone" to tell if the job is done


    private static void copyFromTo(File from, File to) {
        try {
            Files.copy(from.toPath(), new FileOutputStream(to));
        } catch (IOException e) {
            // this should not happen if the constructor does it's error checking!
            System.err.println("IO failure!");
        }
    }

    public static void main(String[] args) {
        // write a basic test to check your work
        copyFromTo(new File(args[0]), new File(args[1]));
    }
}
