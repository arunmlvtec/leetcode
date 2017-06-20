/**
 * Leetcode Problem Solutions
 * Problem No: 240
 * Problem name: Search a 2D Matrix II
 * Description: Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 		Integers in each row are sorted in ascending from left to right.
 * 		Integers in each column are sorted in ascending from top to bottom.
 * Input: 	Matrix =	[[1,   4,  7, 11, 15],
 * 						 [2,   5,  8, 12, 19],
 * 						 [3,   6,  9, 16, 22],
 * 						 [10, 13, 14, 17, 24],
 * 						 [18, 21, 23, 26, 30]
 * 						]
 * 			target =	5 , 20
 * Output: true , false
 * Solved By: Arun Pokharna
 * 
 * */

package leetcode.search2Dmatrix;

public class Search2DMatrix2nd {

	public static void main(String[] args) {
		Search2DMatrix2nd s = new Search2DMatrix2nd();
		int[][] matrix = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
		int target = 20;
		System.out.println(s.searchMatrix(matrix, target));
	}
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        int column = matrix[0].length - 1;
        int row = 0;
        while (row <= matrix.length-1 && column >= 0) {
            if(target == matrix[row][column])
                return true;
            else if (target > matrix[row][column])
                row++;
            else if (target < matrix[row][column])
                column--;
        }
        return false;
    }
}
