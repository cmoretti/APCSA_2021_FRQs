import java.util.Arrays;

public class ArrayResizer
{

    // read 3 minutes
    
    /** Returns true if and only if every value in row r 
     *  of array2D is non-zero.
     *  Precondition: r is a valid row index in array2D.
     *  Postcondition: array2D is unchanged. */
    public static boolean isNonZeroRow(int[][] array2D, int r)
    {
        // 1 minute
        for(int i : array2D[r])
            if(i == 0)
                return false;
        return true;
    }
    
    /** Returns the number of rows in array2D that contain 
     *  all non-zero values. 
     * Postcondition: array2D is unchanged.
     */
    public static int numNonZeroRows(int[][] array2D) {
        int acc = 0;
        for(int i = 0; i < array2D.length; i++) {
            if(isNonZeroRow(array2D,i))
                acc++;
        }
        return acc;
    }

    /** Returns a new, possibly smaller, two-dimensional array 
     *  that contains only rows from array2D with no zeros, 
     *  as described in part (b).
     *  Precondition: array2D contains at least one column and 
     *  at least one row with no zeros. 
     *  Postcondition: array2D is unchanged.
     */
    public static int[][] resize(int[][] array2D)
    {
        // 6 minutes
        int rows = numNonZeroRows(array2D);
        int[][] ret = new int[rows][array2D[0].length];
        int index = 0;
        for(int r = 0; r < array2D.length; r++)
            if(isNonZeroRow(array2D, r)) {
                ret[index] = array2D[r];
                index++;
            }
        return ret;
    }

    public static void main(String[] args) {
        int[][] arr = {{2,1,0},
                       {1,3,2},
                       {0,0,0},
                       {4,5,6}};
        System.out.println("AR.iNZR(arr,0) should be false: "+
                           ArrayResizer.isNonZeroRow(arr, 0));
        System.out.println("AR.iNZR(arr,1) should be true: "+
                           ArrayResizer.isNonZeroRow(arr, 1));
        System.out.println("AR.iNZR(arr,2) should be false: "+
                           ArrayResizer.isNonZeroRow(arr, 2));
        System.out.println("AR.iNZR(arr,3) should be true: "+
                           ArrayResizer.isNonZeroRow(arr, 3));

        int[][] smaller = ArrayResizer.resize(arr);
        System.out.println("smaller should be {{1,3,2}, {4,5,6}}: "+
                           Arrays.deepToString(smaller));
    }
}
