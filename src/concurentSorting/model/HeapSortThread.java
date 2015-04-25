package concurentSorting.model;

import concurentSorting.Main;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by Cornelius on 25.04.2015.
 */
public class HeapSortThread implements Runnable,SortThread {

    private int[] array;
    private static int length;

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
            Main.sortingBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        this.array=SortThread.array;
        
        startSort();

        System.out.println("HeapSort Time:\n"+(System.currentTimeMillis()-Main.startTimeMillis));
       // printNumbers();
    }

    @Override
    public void startSort() {
        heapSort(array);
    }

    public void heapSort(int array[])
    {
        heapify(array);
        for (int i = length; i > 0; i--)
        {
            swap(array,0, i);
            length = length-1;
            maxheap(array, 0);
        }
    }
    /* Function to build a heap */
    public void heapify(int array[])
    {
        length = array.length-1;
        for (int i = length/2; i >= 0; i--)
            maxheap(array, i);
    }
    /* Function to swap largest element in heap */
    public void maxheap(int array[], int i)
    {
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= length && array[left] > array[i])
            max = left;
        if (right <= length && array[right] > array[max])
            max = right;

        if (max != i)
        {
            swap(array, i, max);
            maxheap(array, max);
            //printNumbers();
        }
    }
    /* Function to swap two numbers in an array */
    public static void swap(int array[], int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    @Override
    public void printNumbers() {
        System.out.println("HeapSort");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("\n");
    }

}
