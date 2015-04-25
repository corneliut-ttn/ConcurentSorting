package concurentSorting.model;

import concurentSorting.Main;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by Cornelius on 25.04.2015.
 */
public class BubbleSortThread implements Runnable,SortThread{

    private int[] array;

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

        System.out.println("BubbleSort Time:\n"+(System.currentTimeMillis()-Main.startTimeMillis));
       // printNumbers();
    }

    @Override
      public void startSort() {
        bubbleSort();
    }

    public void bubbleSort() {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k);
                }
            }
         //   printNumbers();
        }
    }

    private void swapNumbers(int i, int j) {

        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void printNumbers() {
        System.out.println("BubbleSort");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("\n");
    }

}
