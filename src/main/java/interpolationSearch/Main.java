package org.example;
import java.util.*;

// Java program to implement interpolation
// search with recursion



public class Main {

        // If x is present in arr[0..n-1], then returns
        // index of it, else returns -1.
    //interpolationSearch(arr, 0, n - 1, x);
    public static int interpolationSearch(int arr[], int lo,
                                              int hi, int x)
        {
            int pos;

            // Since array is sorted, an element
            // present in array must be in range
            // defined by corner
            if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {

                // Probing the position with keeping
                // uniform distribution in mind.
                pos = lo
                        + (((hi - lo) / (arr[hi] - arr[lo]))
                        * (x - arr[lo]));
                System.out.println("----------pos----" + pos);
                // Condition of target found
                if (arr[pos] == x) {
                    System.out.println("Exact_match " + pos);
                    return pos;
                }
                // If x is larger, x is in right sub array
                if (arr[pos] < x) {
                    System.out.println("Recursive2  "+pos);
                    return interpolationSearch(arr, pos + 1, hi,
                            x);
                }

                // If x is smaller, x is in left sub array
                if (arr[pos] > x) {
                    System.out.println("Recursive3  "+ pos);
                    return interpolationSearch(arr, lo, pos - 1,
                            x);
                }
            }
            return -1;
        }

        // Driver Code
        public static void main(String[] args)
        {

            // Array of items on which search will
            // be conducted.
            int arr[] = { 10, 12, 13, 16, 18, 19, 20, 21,
                    22, 23, 24, 33, 35, 42, 47 };

            int n = arr.length;

            // Element to be searched
            int x = 18;
            int index = interpolationSearch(arr, 0, n - 1, x);
            int lo=0, hi=n-1, pos;

            pos = lo+ (((hi - lo) / (arr[hi] - arr[lo]))* (x - arr[lo]));


            System.out.println("Array Length: "+ (lo+ ((hi - lo))));
            // If element was found
            if (index != -1)
                System.out.println("Element found at index "
                        + index);
            else
                System.out.println("Element not found.");
        }
    }

// This code is contributed by equbalzeeshan
