class HiLow
{ // class HiLow

	public static void main(String args[])
	{ // main

		int number;

		// read in the number from the command line
		if (args.length < 1)
		{ // no arguments
			// Inform the user that they have no arguments and how to call the program
			System.out.println("Usage: java HiLow <number>");
			System.out.println("   Where <number> is the number from 1-100 you want the program to guess.");
		} // no arguments
		else if ( (Integer.parseInt(args[0]) < 1) || (Integer.parseInt(args[0]) > 100) )
		{ // invalid number
			// inform the user their number is out of bounds
			System.out.println("Number must be between 1 and 100");
		} // invalid number
		else
		{ // guess the number

			int guess;		// what number the program is guessing
			int count;		// how many guesses the program has made by a method

			// assign first command line parameter to the number to guess
			number = Integer.parseInt(args[0]);

			// brute force
			System.out.println("");
			System.out.println("Guessing by brute force...");
			// (**) print a blank line...hint: look above for how to do this...
			System.out.println("");

			// (**) set count to 0
			count = 0;
				// initialize the count
			// (**) insert a determinate loop that iterates variable guess from 1 to 100
			for(guess =1; guess <= 100; guess++)
			{ // brute force guess
				count++;
				// (**) test if guess is equal to the number
				if(guess == number)
				{ // found it
					System.out.println("Found the number is " + guess + " at guess " + count + ".");
				} // found it
			} // brute force guess
			System.out.println("Total guesses: " + count);

			// guess by hi-low method
			System.out.println("");
			System.out.println("Guessing by binary search...");
			System.out.println("");
			// (**) initialize the count to 1
			count = 1;
			// (**) initialize variable high to 100
			int high = 100;
			int low = 1;		// minimum value the number can be
			guess = (high + low) / 2;		// pick a number half-way between high and low
			System.out.print("Guessing hi-low");
			// (**) insert an indeterminate loop that checks if guess is not equal to the number
			while(guess != number)
			{ // try another number
				// (**) print, without a new line, a period
				System.out.println(".");
				// (**) insert a conditional to test if guess is less than the number
				if(guess <= number)
				{ // pick higher
					low = guess;
				} // pick higher
				else
				{ // pick lower
					high = guess;
				} // pick lower
				count++;
				// pick a new guess between the new high and low
				guess = (high + low) / 2;
			} // try another number
			System.out.println("!");
			System.out.println("Found the number is " + guess + " at guess " + count + ".");
			System.out.println("Total guesses: " + count);

		} // guess the number

	} // main

} // class HiLow
