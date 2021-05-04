import java.util.*;
import java.lang.*;
public class KnapSack {
    private static double getMaxValue(int[] wt, int[] val,
                                      int capacity)
    {
        ItemValue[] iVal = new ItemValue[wt.length];

        for (int i = 0; i < wt.length; i++) {
            iVal[i] = new ItemValue(wt[i], val[i], i);
        }


        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2)
            {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0d;

        for (ItemValue i : iVal) {

            int curWt = (int)i.wt;
            int curVal = (int)i.val;

            if (capacity - curWt >= 0) {

                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {

                double fraction
                        = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                capacity = (int)(capacity - (curWt * fraction));
                break;
            }
        }

        return totalValue;
    }

    static class ItemValue {
        Double cost;
        double wt, val, ind;


        public ItemValue(int wt, int val, int ind)
        {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = new Double((double)val / (double)wt);
        }
    }


    public static void main(String[] args)
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

        double maxValue = getMaxValue(wt, val, capacity);


        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
