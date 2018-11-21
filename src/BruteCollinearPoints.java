import java.util.Arrays;
import java.util.LinkedList;

public class BruteCollinearPoints {
    private LinkedList<LineSegment> segment = new LinkedList<>();
    private int numOfSegments = 0;
    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points){

        if (points == null) throw new IllegalArgumentException();
        try {
            Arrays.sort(points);
        }catch (NullPointerException e){
            throw new IllegalArgumentException();
        }
         for (int i = 0; i < points.length; i++){
             for (int j = i+1; j < points.length; j++){
                 for (int k =j+1; k < points.length; k++){
                     for (int m = k+1; m < points.length; m++ ){
                         if (points[i].equals(points[j]) || points[i].equals(points[k]) || points[i].equals(points[m])
                         || points[i] == null || points[j] == null || points[k] == null || points[m] == null) {
                             throw new IllegalArgumentException();
                         }
                         if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])
                         && points[i].slopeTo(points[j]) == points[i].slopeTo(points[m])){
                             segment.add(new LineSegment(points[i], points[m]));
                             numOfSegments ++;

                         }
                     }
                 }
             }
         }

        segments = segment.toArray(new LineSegment[numOfSegments]);

    }  // finds all line segments containing 4 points
    public  int numberOfSegments(){
        return numOfSegments;
    }        // the number of line segments

    public LineSegment[] segments(){
        return segments;

    }// the line segments

}