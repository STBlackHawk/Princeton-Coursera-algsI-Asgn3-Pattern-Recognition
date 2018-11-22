
import java.util.Arrays;
import java.util.LinkedList;

public class FastCollinearPoints {

    private LinkedList<LineSegment> segment = new LinkedList<>();
    private int numOfSegments = 0;
    private LineSegment[] segments;
    private boolean duplicate;



    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();

        try {
            Arrays.sort(points);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < points.length; i++) {
            double[][] slopes = new double[points.length][2];
            for (int j = 0; j < points.length; j++) {
                if (( i!=j&& points[i].equals(points[j])) || points[i] == null || points[j] == null) {
                    throw new IllegalArgumentException();
                }
                slopes[j][0] = (double) j;
                slopes[j][1] = points[i].slopeTo(points[j]);
            }

            java.util.Arrays.sort(slopes, new java.util.Comparator<double[]>() {
                public int compare(double[] a, double[] b) {
                    return Double.compare(a[1], b[1]);
                }
            });

            //Arrays.sort(slopes);


            for (int t = 0; t < points.length - 2; t++) {
                if (slopes[t][1] == slopes[t + 1][1]
                        && slopes[t][1] == slopes[t+1][1]
                        && slopes[t][1] == slopes[t+2][1]) {

                    t = t + 2;
                    while (t < points.length - 1&&
                            slopes[t][1] == slopes[t+1][1]){
                        t++;
                    }

                    for(int m = 0; m < i; m++){
                        if(points[m].slopeTo(points[(int )slopes[t][0]]) ==
                                points[i].slopeTo(points[(int)slopes[t][0]])) {
                            duplicate = true;
                        }
                    }
                    if(!duplicate) {
                        segment.add(new LineSegment(points[i], points[(int) slopes[t][0]]));
                        numOfSegments++;
                    }

                    duplicate = false;


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
    }
}