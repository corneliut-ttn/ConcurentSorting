package concurentSorting.model;

/**
 * Created by Cornelius on 25.04.2015.
 */
public interface SortThread  {

    static public final int array[] = { 23,9,30,27,18,5,31,14,
                                        25,1,28,15,2,17,28,7,
                                        32,22,11,24,12,33,8,6,
                                        19,29,34,3,10,21,11,4,
                                        13,20,16,26,35};

    public void startSort();

    public  void printNumbers();

}
