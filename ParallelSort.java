import java.util.Scanner;
import java.io.*;

class ParallelSort
{  // ParallelSort

	// (**) global variables here
	public static int[] numbers = new int[10000];
	public static String[] strings = new String[10000];

	public static void main(String args[])
	{ // main

		System.out.println("Reading in numbers");
		ReadNumbers();
		System.out.println("Reading in strings");
		ReadStrings();
		intsort(numbers,strings);
		for(int x = 0; x < 9999; x++)
		{
			System.out.println(numbers[x] + " " + strings[x]);
		}

		// (**) sort the arrays in parallel

	} // main

	static void intsort(int numbers[], String strings[])
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
			String change = strings[x];
			strings[x] = strings[pos];
			strings[pos] = change; 
		}//iterates over array for first position 
	}//method for selection sort 

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
		//	for (x=0; x<10000; x++)
		//	{ System.out.println(numbers[x]); }

	} // Read the numbers in from a file

	public static void ReadStrings()
	{ // Read the strings in from a file

		String s;
		int x;

		try{

			FileReader file = new FileReader("randstrings.txt");
			BufferedReader br = null;

			br = new BufferedReader(file);

			x = -1;

			while ((s = br.readLine()) != null)
			{  // read in one string
				x++;
				if ((x % 100) == 0)
				{ System.out.print("."); }
				strings[x] = s;
			}  // read in one string
		} catch (IOException ex) {};

		System.out.println("Strings read!");

		// [**] test the code
		//	for (x=0; x<10000; x++)
		//	{ System.out.println(strings[x]); }

	} // Read the strings in from a file

}  // ParallelSort
