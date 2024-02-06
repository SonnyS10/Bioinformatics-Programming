import java.io.*;
import java.util.*;

class SandQ
{
    static String seq = "";
    public static void main(String args[])
    {
        readseq();
        stack();
        queue();
    }

    static void stack()
    {
        Stack<Integer> myStack = new Stack<Integer>();
        for(int x = 0; x < 20; x++)
        {
        String num = seq.substring(x*5,((x*5)+5));
        int value = Integer.parseInt(num);
        //System.out.println(value);//testing
        myStack.push(value);
        }
        System.out.println("Stack:");
        for(int y = 0; y < 20; y++)
        {
            System.out.println(myStack.peek());
            myStack.pop();
        }
    }

    static void queue()
    {
        Queue<Integer> myQueue = new LinkedList<Integer>();
        for(int x = 0; x < 20; x++)
        {
        String num = seq.substring(x*5,((x*5)+5));
        int value = Integer.parseInt(num);
        //System.out.println(value);//testing
        myQueue.add(value);
        }
        System.out.println("Queue:");
        for(int y = 0; y < 20; y++)
        {
            System.out.println(myQueue.peek());
            myQueue.remove();
        }
    }

    public static void readseq()
    {

        String s;

        try
        {
            FileReader file = new FileReader("StackQueueNumbers.txt");
            BufferedReader br = null; 

            br = new BufferedReader(file);

            while((s = br.readLine()) != null)
                {
                    seq += s; 
                }
        } 
        catch(IOException ex){};
        //System.out.println(seq); //testing 
    }
}