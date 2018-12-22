package Sudoku;

class CheckAnswer
{
	// ���� ���� 3x3�ڽ��� 1~9�� �ϳ����� �ִ��� üũ���ִ� �Լ�.
	public static boolean Grading(int[][] a_board, int row, int col, int answer) {
		// ����,���� Ȯ���ϱ�
		boolean a = true;
		for(int x=0; x<9;x++) {
			if (a_board[col][x] == answer || a_board[x][row] == answer) {
				a = false;
			}
		}
		
		int box_col = col/3*3;
		int box_row = row/3*3;
		
		for(int i = 0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if (a_board[box_col + i][box_row + j] == answer) {
					a = false;
				}
			}
		}
		return a;
	}
}