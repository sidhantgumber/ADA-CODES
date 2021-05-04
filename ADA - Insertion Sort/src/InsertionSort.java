import java.util.*;

public class InsertionSort {
  public static void sort(int[] arr)
    {
        for(int i=1;i<arr.length;i++)
        {
           int key = arr[i];
           int j = i - 1;

           while(j>=0 && arr[j]>key)
           {
               arr[j+1]=arr[j];
               j = j - 1;
           }

           arr[j+1] = key;
        }
    }

   public static int[] enterArray()
    {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        for(int i =0;i< arr.length;i++)
        {
            System.out.print("Enter element nunmber "+i+" : ");
            arr[i] =  sc.nextInt();
        }
        return arr;
    }

   public static void printArray(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");


    }

    public static void main(String[] args) {
        System.out.println("Enter unsorted array of size 5");

        int[] arr = enterArray();
        System.out.println("Array entered is: ");
        printArray(arr);
        System.out.println("Array after sorting is: ");
        sort(arr);
        printArray(arr);
  }

}
