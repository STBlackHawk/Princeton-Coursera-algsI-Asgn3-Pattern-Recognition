import java.util.Arrays;
import java.util.LinkedList;

public class FastCollinearPoints {

    private LinkedList<LineSegment> segment = new LinkedList<>();
    private int numOfSegments = 0;
    private LineSegment[] segments;

    public FastCollinearPoints(Point[] points){
        if (points == null) throw new IllegalArgumentException("the point is null");

        try{
        Arrays.sort(points);
        }catch(NullPointerException e){
            throw new IllegalArgumentException("one or more of the points are null");
        }
        double[][] slopes = new double[points.length][2];
     for(int i = 0; i < points.length; i++) {
         for (int j = i+1 ; j < points.length; j++) {
             if (points[i]==points[j]) {
                 throw new IllegalArgumentException(" one of the point is null");
             }
                 slopes[j][0] = j;
                 slopes[j][1] = points[i].slopeTo(points[j]);
         }

         java.util.Arrays.sort(slopes, new java.util.Comparator<double[]>() {
             public int compare(double[] a, double[] b) {
                 return Double.compare(a[1], b[1]);
             }
         });

         for (int t = 0; t < points.length - 1; t++) {
             if(slopes[t][1] == slopes[t+1][1]) {
                 while (t < points.length - 1 && slopes[t][1] == slopes[t + 1][1]) {
                     t++;
                 }
                 segment.add(new LineSegment(points[i], points[(int) slopes[t][0]]));
                 numOfSegments++;
             }
         }
     }

     segments = segment.toArray(new LineSegment[numOfSegments]);

     } // finds all line segments containing 4 or more points
    public int numberOfSegments() {

        return numOfSegments;
    }       // the number of line segments
    public LineSegment[] segments() {
        return segments;
    }               // the line segments
}