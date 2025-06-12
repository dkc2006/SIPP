// Java program to find minimum distance between points

import java.util.*;
import java.lang.Math;

public class FindMinimumDistanceBetweenPoints{

    // Function to compute Euclidean distance between two points
    static double distance(double[] p1, double[] p2) {
        return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) +
                (p1[1] - p2[1]) * (p1[1] - p2[1]));
    }

    // Comparison function to sort points by x-coordinate
    static Comparator<double[]> compareX = new Comparator<double[]>() {
        public int compare(double[] p1, double[] p2) {
            return Double.compare(p1[0], p2[0]);
        }
    };

    // Comparison function to sort points by y-coordinate
    static Comparator<double[]> compareY = new Comparator<double[]>() {
        public int compare(double[] p1, double[] p2) {
            return Double.compare(p1[1], p2[1]);
        }
    };

    // Function to find the minimum distance in the strip
    static double stripClosest(double[][] strip, double d) {
        double minDist = d;

        // Sort points in the strip by their y-coordinate
        Arrays.sort(strip, compareY);

        // Compare each point in the strip
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j][1] - strip[i][1]) < minDist; j++) {
                minDist = Math.min(minDist, distance(strip[i], strip[j]));
            }
        }

        return minDist;
    }

    // Divide and conquer function to find the minimum distance
    static double minDistUtil(double[][] points, int left, int right) {

        // Base case brute force for 2 or fewer points
        if (right - left <= 2) {
            double minDist = Double.MAX_VALUE;
            for (int i = left; i < right; i++) {
                for (int j = i + 1; j < right; j++) {
                    minDist = Math.min(minDist, distance(points[i], points[j]));
                }
            }
            return minDist;
        }

        // Find the midpoint
        int mid = (left + right) / 2;
        double midX = points[mid][0];

        // Recursively find the minimum distances in
        // the left and right halves
        double dl = minDistUtil(points, left, mid);
        double dr = minDistUtil(points, mid, right);

        double d = Math.min(dl, dr);

        // Build the strip of points within distance d from the midline
        List<double[]> strip = new ArrayList<>();
        for (int i = left; i < right; i++) {
            if (Math.abs(points[i][0] - midX) < d) {
                strip.add(points[i]);
            }
        }

        // Find the minimum distance in the strip
        double stripDist = stripClosest(strip.toArray(new double[strip.size()][]), d);

        return Math.min(d, stripDist);
    }

    // Function to find the closest pair of points
    static double minDistance(double[][] points) {
        int n = points.length;

        // Sort points by x-coordinate
        Arrays.sort(points, compareX);

        return minDistUtil(points, 0, n);
    }

    public static void main(String[] args) {
        double[][] points = {{-1, -2}, {0, 0}, {1, 2}, {2, 3}};

        double res = minDistance(points);

        // Output the result with 6 decimal places
        System.out.printf("%.6f\n", res);
    }
}