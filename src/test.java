import java.io.*;
import java.util.Scanner;

public class test {
    public static void main(String[] arg) throws FileNotFoundException {
        File file = new File(arg[0]);

        Scanner in = new Scanner(file);

        int n = in.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i <n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            points[i] = new Point(x, y);
        }



        FastCollinearPoints collinear = new FastCollinearPoints(points);
        collinear.segments();
        collinear.segments();
        collinear.numberOfSegments();
        collinear.segments();


        BruteCollinearPoints Bcollinear = new BruteCollinearPoints(points);
        collinear.segments();
        collinear.segments();
        collinear.numberOfSegments();
        collinear.segments();




    }


}
