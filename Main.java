
public class Main {

	public static void main(String[] args) {
		// 0,0,0, 0,0,0, 0,0,0,     for copy-paste reasons
		int[] row1 = {0,1,2, 5,9,4, 6,8,0};
		int[] row2 = {6,0,0, 2,1,7, 0,9,5};
		int[] row3 = {9,5,4, 6,8,0, 0,0,7};
		
		int[] row4 = {0,7,6, 0,5,0, 8,4,0};
		int[] row5 = {2,9,1, 4,0,8, 5,3,6};
		int[] row6 = {0,4,8, 0,2,0, 9,7,0};
		
		int[] row7 = {4,0,0, 0,6,5, 2,1,8};
		int[] row8 = {8,2,0, 9,3,1, 0,0,4};
		int[] row9 = {0,6,7, 8,4,2, 3,5,0};
		
		int[][] puzz = new int[][]{row1, row2, row3, row4, row5, row6, row7, row8, row9};
		
		SudokuBoard sud = new SudokuBoard(puzz);
		sud.SolveAll();
		sud.PrintSolution();
		
		// 0,0,0,0    for copy-paste reasons
		int[] row41 = {1,0,0,0};
		int[] row42 = {0,0,0,4};
		int[] row43 = {0,0,2,0};
		int[] row44 = {0,3,0,0};
		
		int[][] puzz4 = new int[][]{row41, row42, row43, row44};
		
		FourByFour sud4 = new FourByFour(puzz4);
		sud4.SolveAll();
		sud4.PrintSolution();
		
	}
}
