import java.util.Scanner;
import java.io.*;

class SortMe
{  // SortMe

	// (**) global variables here
	public static int[] numbers = new int[10000];

	public static void main(String args[])
	{ // main

		System.out.println("Reading in numbers");
		ReadNumbers();
		intsort(numbers);
		print();
		

		// (**) write a method to sort the numbers using one of the five from lecture

	} // main

	static void intsort(int numbers[])
	{//method for selection sort 
		for(int x = 0; x < 9999; x++)
		{//iterates over array for first position 
			int pos = 0; 
			int min = 100000; 
			for(int y = x; y < 10000; y++)
			{// goes through ints in array 
				if(numbers[y] < min)
				{//switching min value 
					min = numbers[y];
					pos = y; 
				}//switching min value 
			}//goes through ints in array 
			int swap = numbers[x];
			numbers[x] = min; 
			numbers[pos] = swap; 
		}//iterates over array for first position 
	}//method for selection sort 
	static void print()
	{
		for(int x = 0; x < 9999; x++)
		{
			System.out.print(" "); 
			 String value = String.valueOf(numbers[x]);
			int valuel = value.length();
			switch(valuel)
			{
				case 1: 
					System.out.print("    " + numbers[x]);
					break;
				case 2:
					System.out.print("   " + numbers[x]);
					break;	
				case 3:
					System.out.print("  " + numbers[x]);
					break;
				case 4:
					System.out.print(" " + numbers[x]);
					break;
				case 5: 
					System.out.print(numbers[x]);
					break;
			}
		}
	}

	public static void ReadNumbers()
	{ // Read the numbers in from a file

		String s;
		int x;

		try{

			FileReader file = new FileReader("randnumbers.txt");
			BufferedReader br = null;

			br = new BufferedReader(file);

			x = -1;

			while ((s = br.readLine()) != null)
			{  // read in one sequence
				x++;
				if ((x % 100) == 0)
				{ System.out.print("."); }
				numbers[x] = Integer.parseInt(s);
			}  // read in one sequence
		} catch (IOException ex) {};

		System.out.println("Numbers read!");

		// [**] test the code
			//for (x=0; x<10000; x++)
			//{ System.out.println(numbers[x]); }

	} // Read the numbers in from a file

}  // SortMe
