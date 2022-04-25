package DataStructureWithMosh.linkedLists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class ZigZagCorrect
{
    // method returns minimum cost to break board into
    // m*n squares
    static int minimumCostOfBreaking(Integer X[], Integer Y[],
                                     int m, int n)
    {
        int res = 0;

        // sort the horizontal cost in reverse order
        Arrays.sort(X, Collections.reverseOrder());

        // sort the vertical cost in reverse order
        Arrays.sort(Y, Collections.reverseOrder());

        // initialize current width as 1
        int hzntl = 1, vert = 1;

        // loop until one or both
        // cost array are processed
        int i = 0, j = 0;
        while (i < m && j < n)
        {
            if (X[i] > Y[j])
            {
                res += X[i] * vert;

                // increase current horizontal
                // part count by 1
                hzntl++;
                i++;
            }
            else
            {
                res += Y[j] * hzntl;

                // increase current vertical
                // part count by 1
                vert++;
                j++;
            }
        }

        // loop for horizontal array,
        // if remains
        int total = 0;
        while (i < m)
            total += X[i++];
        res += total * vert;

        // loop for vertical array,
        // if remains
        total = 0;
        while (j < n)
            total += Y[j++];
        res += total * hzntl;

        return res;
    }
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        Integer X[] = new Integer[m];
        Integer Y[] = new Integer[n];
        for(int i=0;i<m-1;i++){
            X[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++){
            Y[i]=sc.nextInt();
        }
        System.out.print(minimumCostOfBreaking(X, Y, m-1, n-1));
    }
}