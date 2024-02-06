import java.util.Scanner;
import java.io.*;

class kmer 
{//kmer
    public static String seq; 
    public static String SubS;
    public static int[] intseq = new int[4];
    public static int[] kmerSeq = new int[255];
    public static char[] decodeSeq = new char[4];
    public static void main(String args[])
    {//main
        readseq();
        SWindow();
        printdecode(kmerSeq);
    }//main

    static void SWindow()
    {
        for(int x = 0; x < (seq.length() - 3); x++)
        {
            String SubS = seq.substring(x, (x + 4));
            encode(SubS); 
        }
    }

    static int encode(String SubS)
    {
       for(int x = 0; x < 4; x++)
       {
            switch(SubS.substring(x,x+1))
            {
                case "A": 
                    intseq[x] = 0;
                    break; 
                case "T":
                    intseq[x] = 1;
                    break; 
                case "G": 
                    intseq[x] = 2;
                    break; 
                case "C":
                    intseq[x] = 3; 
                    break; 
            }
       } 
        int y = 0; 
        int value = intseq[y]*64 + intseq[y+1]*16 + intseq[y+2]*4 + intseq[y+3];
        kmerSeq[value]++; 
        //System.out.println(value);//testing
        //System.out.println(kmerSeq[203]);//testing 
        return value; 
    }

    static String printdecode(int[] kmerSeq)
    {
        for(int x = 0; x < 255; x++)
        {
            if(kmerSeq[x] > 0)
            {
                int num = x; 
                int dnum = num%4; 
                decodeSeq[3] = decode(dnum);
                int num2 = num - dnum; 
                num2 = num2/4; 
                dnum = num2%4; 
                decodeSeq[2] = decode(dnum); 
                int num3 = num2 - dnum; 
                num3 = num3/4;
                dnum = num3%4;
                decodeSeq[1] = decode(dnum); 
                int num4 = num3 - dnum; 
                num4 = num4/4;
                dnum = num4%4; 
                decodeSeq[0] = decode(dnum); 
                System.out.print(decodeSeq); 
                System.out.println(" " + kmerSeq[x]);

            }
        }
        return "";
    } 
    static char decode(int dnum)
    {
        switch(dnum)
         {
            case 0: 
                return 'A';
            case 1: 
                return 'T';
            case 2: 
                return 'G';
            case 3: 
                return 'C';
         }
        return 0;
    }

    public static void readseq()
    {

        String s;

        try
        {
            FileReader file = new FileReader("kmersample.txt");
            BufferedReader br = null; 
            br = new BufferedReader(file);

            while((s = br.readLine()) != null)
            {
                seq = s; 
            }
            //System.out.println(seq); //testing 
        } 
        catch(IOException ex){};
    }
}//kmer 