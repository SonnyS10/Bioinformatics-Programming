import java.util.Scanner;

class GCContent
{ // GC Content calculator


	public static void main(String args[])
	{ // main
	while(true)
	{//repeats the process for as many times as the user wants 
	String DNAstr = new String(DNAseq());
	String DNAseq2 = DNAstr.toUpperCase();
	double seqlength = DNAstr.length();//finds the length of the sequence and makes a variable calles seqlength
	double GCcontent = 0;
	double ATcontent = 0;
	double GCpercent = 0;
	double ATpercent = 0;
	//System.out.println(DNAseq2);//testing
	if(DNAseq2.equals("STOP"))
	{//STOP
		return;
	}//STOP
	for(int x=0; x < seqlength; x++)
	{//finding GC content
	//System.out.println(DNAseq2.substring(x,x+1));//testing
		if(DNAseq2.substring(x,x+1).equals("G") || DNAseq2.substring(x,x+1).equals("C"))
		{//finds the amount of GC characters there are
		GCcontent += 1;
		}//finds the amount of GC characters there are
		else if(DNAseq2.substring(x,x+1).equals("A") || DNAseq2.substring(x,x+1).equals("T"))
		{//finds the amount of AT characters there are
		ATcontent +=1;
		}//finds the amount of AT characters there are
		else
		{// invalid sequence
		System.out.println("Invalid sequence, sequence can only contain A,T,C, and G");
		}//invalid sequence
	}//finding GC content
	//System.out.println(GCcontent);//testing
	//System.out.println(ATcontent);//testing
		GCpercent = (GCcontent/seqlength)*100;
		ATpercent = (ATcontent/seqlength)*100;
		int seqlength2 = (int)seqlength;//turns a double into a integer to make the print look better
		System.out.println("There are " + seqlength2 + " basepairs in your sequence");
		System.out.println("GC content percentage: " +  GCpercent + "%");
		System.out.println("AT content percentage: " +  ATpercent + "%");
	}//repeats the process for as many times as the user wants
	} // main
	static String DNAseq()
	{//Scanner setup
		System.out.println("Input DNA sequence(ATCG) or type STOP to end program. ");
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		return x;
		//make a while loop similar to what is in the hw5
	}//Scanner setup
} // GC Content calculator
