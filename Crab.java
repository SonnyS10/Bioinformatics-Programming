import java.util.Scanner;
 
class Crab
{ // class Crab

	public static void main(String args[])
	{ // main

		// variables
		String location = "Field";	// start in the field
		boolean found = false;		// have not found the crab yet
		// (**) create a variable of type "char" named "dir"
		char dir;

		// give user instructions
		System.out.println("Welcome to Crab!");
		System.out.println("Your goal is to find the crab.");
		System.out.println("You can make a decision at any point by using...");
		System.out.println("N - Go North");
		System.out.println("S - Go South");
		System.out.println("E - Go East");
		System.out.println("W - Go West");
		System.out.println("L - Look for the crab");

		// (**) insert an indeterminate loop that continues until "found" is true
		while(found == false)
		{ // get information and make decision

			if (location.equals("Field"))
			{ // in the field
				System.out.println("You are in a field.");
				dir = getdirection();
				if (dir == 'N')
				{ // oops
					System.out.println("Ouch...you hit your head on a wall...");
				} // oops
				// (**) assuming that the previous if was false as dir is not 'N', test if dir is 'S'
				else if(dir == 'S')
				{ // move to swamp
					location = "Swamp";
				} // move to forest
				else if (dir == 'E')
				{ // move to forest
					location = "Forest";
				} // move to forest
				else if (dir == 'W')
				{ // oops
					System.out.println("Ouch...you hit your head on a wall...");
				} // oops
				else if (dir == 'L')
				{ // is the crab here?
					// (**) tell the user that crabs do not live in fields
					System.out.println("Crabs do not live in fields");
				} // is the crab here?
			} // in the field
			else if (location.equals("Forest"))
			{ // in the forest
				System.out.println("You are in a forest full of dancing fawns.");
				// (**) get the user input as was done above in "Field"
				dir = getdirection();
				if (dir == 'N')
				{ // oops
					System.out.println("Ouch...you hit your head on a wall...");
				} // oops
				else if (dir == 'S')
				{ // move to cave
					location = "Cave";
				} // move to cave
				// continue the conditional by testing if the direction is 'E'
				else if (dir == 'E')
				{ // oops
					System.out.println("Ouch...you hit your head on a wall...");
				} // oops
				else if (dir == 'W')
				{ // move to field
					location = "Field";
				} // move to field
				else if (dir == 'L')
				{ // is the crab here?
					System.out.println("Hmmm....I don't think that crabs live in forests...");
					System.out.println("You ask and the deer agree...");
				} // is the crab here?
			} // in the forest
			// (**) continue the condition by testing if the location is "Swamp"
			else if (location.equals("Swamp"))
			{ // in the swamp
				System.out.println("You are in a deep....dark...swamp.");
				dir = getdirection();
				if (dir == 'N')
				{ // move to field
					location = "Field";
				} // move to field
				else if (dir == 'S')
				{ // oops
					System.out.println("Ouch...you hit your head on a wall...");
				} // oops
				else if (dir == 'E')
				{ // move to cave
					location = "Cave";
				} // move to cave
				else if (dir == 'W')
				{ // oops
					System.out.println("Ouch...you hit your head on a wall...");
				} // oops
				else if (dir == 'L')
				{ // is the crab here?
					System.out.println("Hmmm....I don't think that crabs live in swamps...");
					System.out.println("A passing turtle snaps your finger and the agrees...");
				} // is the crab here?
			} // in the swamp
			else if (location.equals("Cave"))
			{//in the Cave
			// (**) create a block that implements a cave where the Forest is north, the Beach is south
				// (**) the Swamp is west, a wall is east, and there is no crab here...
				// (**) this is worth four blanks!
				System.out.println("You are in a dark....musty...cave.");
				dir = getdirection();
				if (dir == 'N')
				{//move to forest
					location = "Forest";
				}//move to forest
				else if (dir == 'S')
				{//move to Beach
					location = "Beach";
				}//move to Beach
				else if (dir == 'E')
				{//oops
					System.out.println("Ouch...you hit your head on a wall...");
				}//oops
				else if (dir == 'W')
				{//move to Swamp
					location = "Swamp";
				}//move to Swamp
				else if (dir == 'L')
				{//is the crab here?
					System.out.println("Hmmm...I don't think that crabs live in swamps...");
					System.out.println("A flying bat swoops down to let you know this...");
				}//is the crab here 
			}// in the Cave
			else if (location.equals("Beach"))
			{ // on the beach
				System.out.println("You are in a deep....dark...cave....with things making...");
				System.out.println("....wait a minute....you're on a bright sunny beach....");
				dir = getdirection();
				if (dir == 'N')
				{ // move to cave
					location = "Cave";
				} // move to cave
				else if (dir == 'S')
				{ // oops
					System.out.println("Ouch...you hit your head on a wall...");
				} // oops
				else if (dir == 'E')
				{ // oops
					System.out.println("Ouch...you hit your head on a wall...");
				} // oops
				else if (dir == 'W')
				{ // oops
					System.out.println("Ouch...you hit your head on a wall...");
				} // oops
				else if (dir == 'L')
				{ // is the crab here?
					System.out.println("Hmmm....I don't think that crabs live on beaches...");
					System.out.println("Ouch!  He bit you!  I guess that they do live here...");
					found = true;
				} // is the crab here?
			} // on the beach

		} // get information and make decision

		// (**) congratulate the user!
		System.out.println("Congratulations on finding the Crab!!");
	} // main

	static char getdirection()
	{ // get directions
		char choice;
		System.out.print("What would you like to do? (NSEWL) ");
		Scanner s= new Scanner(System.in);
		choice = s.next().charAt(0);
		while ( (choice != 'N') && (choice != 'S') && (choice != 'W') && (choice != 'E') && (choice != 'L') )
		{ // invalid choice
			System.out.print("Invalid choice.  Choose NSEWL.  ");
			choice = s.next().charAt(0);
		} // invalid choice
		return choice;
	} // get directions

} // class Crab

