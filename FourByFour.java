
public class FourByFour {
	//[position in row][position in column][options]
	// | 00 10 20 | 30 40 50 | 60 70 80 |
	// | 01 11 21 | 31 41 51 | 61 71 81 |
	// | 02 12 22 | 32 42 52 | 62 72 82 |
	// ----------------------------------
	// | 03 13 23 | 33 43 53 | 63 73 83 |
	// | 04 14 24 | 34 44 54 | 64 74 84 |
	// | 05 15 25 | 35 45 55 | 65 75 85 |
	// ----------------------------------
	// | 06 16 26 | 36 46 56 | 66 76 86 |
	// | 07 17 27 | 37 47 57 | 67 77 87 |
	// | 08 18 28 | 38 48 58 | 68 78 88 |
	private int[][] solution = new int[4][4];
	private int[][][] puzzle = new int[4][4][4];
	
	public FourByFour(int[][] input) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					this.puzzle[i][j][k] = input[i][j];
				}
			}
		}
	}
	
	private void RemoveZeroes() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(puzzle[i][j][0] == 0) {
					puzzle[i][j][0] = 1;
					puzzle[i][j][1] = 2;
					puzzle[i][j][2] = 3;
					puzzle[i][j][3] = 4;
				} else {
					solution[i][j] = puzzle[i][j][0];
				}
			}
		}
	}
	
	private void SolveOne(int m, int n) {
		if(solution[m][n] == 0) {
			for(int i = 0; i < 4; i++) {
				if(solution[i][n] != 0) {
					puzzle[m][n][solution[i][n]-1] = 0;
				}
				if(solution[m][i] != 0) {
					puzzle[m][n][solution[m][i]-1] = 0;
				}
			}
			
			int plusi = 0;
			int plusj = 0;
			
			if(m>1) {
				plusi = 2;
			}
			if(n>1) {
				plusj = 2;
			}
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					if(solution[i+plusi][j+plusj] != 0) {
						puzzle[m][n][solution[i+plusi][j+plusj]-1] = 0;
					}
				}
			}
			if(puzzle[m][n][0] != 0 && puzzle[m][n][1] == 0 && puzzle[m][n][2] == 0 && puzzle[m][n][3] == 0) {
				solution[m][n] = puzzle[m][n][0];
			}
			if(puzzle[m][n][0] == 0 && puzzle[m][n][1] != 0 && puzzle[m][n][2] == 0 && puzzle[m][n][3] == 0) {
				solution[m][n] = puzzle[m][n][1];
			}
			if(puzzle[m][n][0] == 0 && puzzle[m][n][1] == 0 && puzzle[m][n][2] != 0 && puzzle[m][n][3] == 0) {
				solution[m][n] = puzzle[m][n][2];
			}
			if(puzzle[m][n][0] == 0 && puzzle[m][n][1] == 0 && puzzle[m][n][2] == 0 && puzzle[m][n][3] != 0) {
				solution[m][n] = puzzle[m][n][3];
			}
		}
	}
	
	private boolean CheckSolved() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(solution[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void SolveAll() {
		RemoveZeroes();
		int count = 0;
		while(CheckSolved() == false && count < 10) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					SolveOne(i,j);
				}
			}
			count++;
		}
		System.out.println(count + " loops");
	}
	
	public void PrintSolution(){
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(solution[i][j]+ "  ");
			}
			System.out.println(" ");
		}
	}
	
	public void PrintPuzzle(){
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print("{");
				for(int k = 0; k < 4; k++) {
					System.out.print(solution[i][j]+ "  ");
				}
				System.out.print("} ");
			}
			System.out.println(" ");
		}
	}
}







