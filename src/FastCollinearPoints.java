import java.util.LinkedList;

public class FastCollinearPoints {

    LinkedList<LineSegment> segment = new LinkedList<>();
    int numOfSegments = 0;
    public FastCollinearPoints(Point[] points){
        double[][] slopes = new double[points.length][2];
     for(int i = 0; i < points.length; i++) {
         for (int j = 0; j < points.length; j++) {
             slopes[j][0] = j;
             slopes[j][1] = points[i].slopeTo(points[j]);

         }


         java.util.Arrays.sort(slopes, new java.util.Comparator<double[]>() {
             public int compare(double[] a, double[] b) {
                 return Double.compare(a[1], b[1]);
             }
         });

         for (int t = 1; t < points.length - 1; t++) {

             if (slopes[t - 1][1] == slopes[t][1] && slopes[t][1] == slopes[t + 1][1]) {
                 segment.add(new LineSegment(points[i], points[(int)slopes[t + 1][0]]));
                 numOfSegments++;
             }
         }
     }


     } // finds all line segments containing 4 or more points
    public int numberOfSegments() {

        return numOfSegments;
    }       // the number of line segments
    public LineSegment[] segments() {

        LineSegment[] segments = new LineSegment[numberOfSegments()];
        for(int e = 0; e < numOfSegments; e++){

            segments[e] = segment.removeFirst();
        }

        return segments;
    }               // the line segments
}