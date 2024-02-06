import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

class hashMap
{//hashmap
    public static String seq = "";
    static Scanner input = new Scanner(System.in);
    public static int size;

    public static void main(String args[])
        {
            readseq();
            domainSize();
            hashmap();
        }

    static int domainSize()
    {
        System.out.println("What length domains would you like to use (1-6).");
        String x = input.nextLine();
        size = Integer.parseInt(x);
        //System.out.println(size); //testing
        return size; 
    }

     static void hashmap()
    {
        HashMap<String, Integer> kmers = new HashMap<String, Integer>();

        for(int x = 0; x < (seq.length() - size + 1); x++)
        {
          String current = seq.substring(x,(x + size));
          if(kmers.containsKey(current))
          {
            kmers.put(current, (kmers.get(current) + 1));
          }
          else
          {
            kmers.put(current, 1);
          }
        }
        for(String i : kmers.keySet())
        {
            System.out.println(i + " " + kmers.get(i));
        }
    }

    public static void readseq()
        {

            String s;

            try
            {
                FileReader file = new FileReader("kmersample_Week14.txt");
                BufferedReader br = null; 

                br = new BufferedReader(file);

                while((s = br.readLine()) != null)
                    {
                        seq += s; 
                    }
            } 
            catch(IOException ex){};
            System.out.println(seq); //testing 
        }
}//hashmap
