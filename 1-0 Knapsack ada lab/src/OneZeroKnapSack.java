import java.lang.*;
import java.util.*;
public class OneZeroKnapSack {
    static int max(int a, int b) { return (a > b) ? a : b; }


    static int knapSack(int W, int wt[], int val[], int n)
    {

        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

        else
            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                    knapSack(W, wt, val, n - 1));
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N;  // number of items taken as user input

        System.out.println("Enter the number of items: ");
        N = sc.nextInt();
        int[] wt = new int[N];
        Random r = new Random();
        for(int i = 0;i < N; i ++)   // generating random values
        {
            wt[i] = r.nextInt(100-1)+1;


        }


/*
        for(int i = 0;i < N; i ++)
        {
            System.out.println(wt[i]);


        }
        */

        int[] val = new int[N];
        for (int i = 0 ; i< N;i++)
        {
            System.out.println("Enter value number: "+(i+1));
            val[i] = sc.nextInt();

        }
        System.out.println("Enter the capacity");
        int capacity = sc.nextInt();
        System.out.println(knapSack(capacity, wt, val, N));
    }
}

