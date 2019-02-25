import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ArrayList<Point> result = new ArrayList<>();
        Threading[] threads = new Threading[coreCount];

        System.out.println();
        for(int x = 0; x < coreCount; x++){
            threads[x] = new Threading(x);
        }
        for (int n = 1; n < 5000; n++) {
            threads[n%coreCount].addToWork(new Point(n,n+1));
        }

        for (int x = 0; x < coreCount; x++) {
            threads[x].run();
        }

        for (int x = 0; x < coreCount; x++) {
            try {
                threads[x].join();
                result.addAll(threads[x].getWorks());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Point p : result) {
            System.out.println("Works with n = " + p.x + " and k = " + p.y);
        }


    }
}
