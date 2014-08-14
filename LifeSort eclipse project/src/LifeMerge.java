import java.io.*;
import java.util.*;


public class LifeMerge {
	
	public static void main(String [ ] args) throws IOException {
		
		// create token1
	    String token1 = "";

	    // for-each loop for calculating heat index of May - October

	    // create Scanner inFile1
	    Scanner inFile1 = new Scanner(new File("tasks.txt"));

	    List<String> temps = new LinkedList<String>();

	    // while loop
	    while (inFile1.hasNext()) {
	      // find next line
	      token1 = inFile1.nextLine();
	      temps.add(token1);
	    }
	    
	    inFile1.close();


	    String[] tasks = temps.toArray(new String[0]);

	    for (String s : tasks) {
	      System.out.println(s);
	    }
	    
	    
	    
	    
	    
	    MergeSortStrings ms = new MergeSortStrings();
		System.out.print("input tasks: ");
		System.out.println(Arrays.toString(tasks));
		ms.sort(tasks);
		System.out.println(" ");
		System.out.println("............................................................");
		System.out.println("............................................................");
		System.out.println("............................................................");
		System.out.println("............................................................");
		System.out.println("............................................................");

		System.out.println("...oh");
		System.out.println("...my");
		System.out.println("...god");
		System.out.println("...sorted!!!");
		
		System.out.println("\n\nsorted as " + Arrays.toString(tasks));
		System.out.println("saved as sortedtasks.txt");
		
		 BufferedWriter outputWriter = null;
		  outputWriter = new BufferedWriter(new FileWriter("sortedtasks.txt"));
		  for (int i = 0; i < tasks.length; i++) {
		    // Maybe:
		    outputWriter.write(tasks[i]+"");
		    // Or:
		    outputWriter.newLine();
		  }
		  outputWriter.flush();  
		  outputWriter.close();  
	}
}

