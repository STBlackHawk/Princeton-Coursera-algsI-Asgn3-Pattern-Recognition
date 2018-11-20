public class BruteCollinearPoints {
    public BruteCollinearPoints(Point[] points){
         double m = points[0].slopeTo(points[1]);
         double n = points[0].slopeTo(points[2]);
         double o = points[0].slopeTo(points[3]);

         if (m == n && m == o){
                LineSegment q = new LineSegment(points[0], points[1]);
         }
         return q;
    }  // finds all line segments containing 4 points
    public           int numberOfSegments()        // the number of line segments
    public LineSegment[] segments()                // the line segments
}