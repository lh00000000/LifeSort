import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
public class MergeSortStrings {
	private String[] strings;
	private String[] helper;

	//Scanner user_input = new Scanner( System.in );
	BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
	
	
	private int number;
	
	private int totalComp = 0;;
	private int compsSoFar = 0;

	public void sort(String[] values) {
		this.strings = values;
		totalComp = (int) (values.length * Math.log(values.length));
		number = values.length;
		this.helper = new String[number];
		mergesort(0, number - 1);
	}

	private void mergesort(int low, int high) {
		// check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		
		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = strings[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			String input = "";
			//TODO show remaining comparisions left (total is nlogn)
			
			System.out.println("............................................................" + compsSoFar + "/" + totalComp);			
			//System.out.println("is \t\"" + helper[i] + "\"\nmore important than\t\"" + helper[j] + "\" ?");
			System.out.print("" + helper[i] + " > " + helper[j] + "?  [Y/n]");
			//input = user_input.next( );
			try {
				input = user_input.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (input.equals("") || input.equals("y") || input.equals("Y")) {
				strings[k] = helper[i];
				i++;
				k++;
				compsSoFar ++;
			} else if (input.equals("N") || input.equals("n")){
				strings[k] = helper[j];
				j++;
				k++;
				compsSoFar ++;
			} else {
				System.out.println();
				System.out.println("wait what");
			}
			System.out.println("\n");

			
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			strings[k] = helper[i];
			k++;
			i++;
		}

	}
} 