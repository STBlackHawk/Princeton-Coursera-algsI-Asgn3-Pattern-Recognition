import java.util.Arrays;
import java.util.LinkedList;

public class BruteCollinearPoints {
    private LinkedList<LineSegment> segment = new LinkedList<>();
    private int numOfSegments = 0;

    public BruteCollinearPoints(Point[] points){
        if (points == null) throw new IllegalArgumentException("the point is null");
        Arrays.sort(points);
         for (int i = 0; i < points.length; i++){
             for (int j = i+1; j < points.length; j++){
                 for (int k =j+1; k < points.length; k++){
                     for (int m = k+1; m < points.length; m++ ){
                         if (points[i] == null || points[j] == null || points[k] == null || points[m] == null ||
                                points[i] == points[j] || points[i] == points[k] || points[i] == points[m])
                             throw new IllegalArgumentException(" one of the point is null");
                         if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])
                         && points[i].slopeTo(points[j]) == points[i].slopeTo(points[m])){
                             segment.add(new LineSegment(points[i], points[m]));
                             numOfSegments ++;

                         }
                     }
                 }
             }
         }
    }  // finds all line segments containing 4 points
    public  int numberOfSegments(){
        return numOfSegments;
    }        // the number of line segments
    public LineSegment[] segments(){
        LineSegment[] segments = new LineSegment[numOfSegments];
        for(int e = 0; e < numOfSegments; e++){
            segments[e] = segment.removeFirst();
        }

        return segments;

    }// the line segments

}