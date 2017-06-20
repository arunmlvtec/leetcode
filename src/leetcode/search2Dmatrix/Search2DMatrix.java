/**
 * Leetcode Problem Solutions
 * Problem No: 74
 * Problem name: Search a 2D Matrix
 * Description: Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 		Integers in each row are sorted from left to right.
 * 		The first integer of each row is greater than the last integer of the previous row.
 * Input: 	Matrix =	[[1,   3,  5,  7],
 * 						 [10, 11, 16, 20],
 * 						 [23, 30, 34, 50]
 * 						]
 * 			target =	3
 * Output: true
 * Solved By: Arun Pokharna
 * 
 * */

package leetcode.search2Dmatrix;

public class Search2DMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		int target = 8;
		Search2DMatrix s = new Search2DMatrix();
		System.out.println(s.searchMatrix(matrix, target));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0)
            return false;
        int columns = matrix[0].length;
        
        int begin = 0;
        int end = (rows * columns) - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            int midValue = matrix[mid / columns][mid % columns];
            if (midValue == target) {
                return true;
            }
            else if (midValue > target) {
                end = mid - 1;
            }
            else {
                begin = mid + 1;
            }
        }
        return false;
    }
}
