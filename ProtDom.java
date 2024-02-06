import java.util.Scanner;

class ProtDom
{ // Protein domain finder
	// (**) insert global variables here if needed
static Scanner input = new Scanner(System.in);
static String AAseqC = new String(AAseq());
static String [] AADomainA = new String[10];// makes the array for the potentially ten domains 
static int num_Domains = 0;
	public static void main(String args[])
	{ // main
		// (**) insert main code here
	AAseqTest();
	} // main

	// (**) insert other methods here as needed
	static String AAseq()
		{//scanner setup for Amino Acid sequence 
			System.out.println("Insert Amino Acid Sequence. ");
			String x = input.nextLine();
			x = x.toUpperCase();
			System.out.println(x); 
			return x;
		}//scanner setup for Amino Acid sequence

	static String[] AAseqD()
	{ //scanner setup and reading in for the amino acid domains 	
			System.out.println("Insert Amino Acid Domains, you may insert up to 10 Domains. ");
			for(int x=0; x <= 9; x++)//limits the number of domains entered to 10 
			{
				String y = input.nextLine();
				y = y.toUpperCase();
				if (y.equals("STOP"))//checks if the incoming string is the exit command 
				{
					return AADomainA;
				}
				else// if it isnt then you add it to the array 
				{
					System.out.println(y);
					AADomainA[x] = y;
					num_Domains++;
				}
			} 
		//System.out.println(AADomainA[5]);//testing to see if array is working by printing the 6th position in it 
		return AADomainA;
	}//scanner setup and reading in for the amino acid domains 

	static String[] AAseqTest()
	{//tests to see if domain sequence is valid 
		AAseqD();
		for(int x = 0;x < num_Domains; x++)
		{//iterates over position in array
			String Domain_seq = AADomainA[x];
			if (AAseqV(Domain_seq) == true)
			{
				AAseqS(Domain_seq); 
				//System.out.println(Domain_seq);
			}
			else
			{
				System.out.println(Domain_seq + " is an invalid amino acid domain. ");
			}
		}//iterates over position in array
		return AADomainA; 
	}//tests to see if domain sequence is valid 


	static Boolean AAseqV(String Domain_seq)
	{
			for(int z = 0; z < Domain_seq.length(); z++)
			{//iterates over position in the string 
				
				switch(Domain_seq.substring(z,z+1))
				{//checks for invalid sequence 
					case "A":
						break;
					case "C":
						break;
					case "D":
						break; 
					case "E":
						break;					
					case "F":
						break;
					case "G":
						break;	
					case "H":
						break;
					case "I":
						break;
					case "K":
						break;
					case "L":
						break;
					case "M":
						break;
					case "N":
						break;
					case "P":
						break;
					case "Q":
						break;
					case "R":
						break;
					case "S":
						break;
					case "T":
						break;
					case "V":
						break;
					case "W":
						break;
					case "Y":
						break;
					default:
						return false;  																																												
				}//checks for invalid sequence 
			}//iterates over position in 
			return true; 
	}

	static String AAseqS(String Domain_seq)
	{
		for(int z = 0; z < (AAseqC.length() - Domain_seq.length() + 1); z++)
		{
			//System.out.println(AAseqC.substring(z, (z + (Domain_seq.length()))));
			//System.out.println(Domain_seq);
			if(AAseqC.substring(z, (z + (Domain_seq.length()))).equals(Domain_seq))
			{
				System.out.println(Domain_seq + " " + (z + 1));
			}
		}
		return Domain_seq; 
	}
} // Protein domain finder

