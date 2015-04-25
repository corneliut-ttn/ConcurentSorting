package concurentSorting;

import concurentSorting.model.BubbleSortThread;
import concurentSorting.model.HeapSortThread;
import concurentSorting.model.QuickSortThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main extends Application {

    public final static CyclicBarrier sortingBarrier =new CyclicBarrier(4);
    public static long startTimeMillis;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
       // launch(args);

        BubbleSortThread bubbleSortThread=new BubbleSortThread();
        HeapSortThread heapSortThread= new HeapSortThread();
        QuickSortThread quickSortThread=new QuickSortThread();

        (new Thread(bubbleSortThread)).start();
        (new Thread(heapSortThread)).start();
        (new Thread(quickSortThread)).start();

        try {

            startTimeMillis=System.currentTimeMillis();
            sortingBarrier.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
