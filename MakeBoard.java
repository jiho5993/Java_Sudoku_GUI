package Sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MakeBoard
{
	// ������ �����
	public static int[][] CreateBoard() {
		// 1~9�� ��� ��Ģ��� ���忡 �迭.
		List<Integer> seed = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
		    seed.add(i);
		}
		Collections.shuffle(seed);
		
		int n1=seed.get(0) ,n2=seed.get(1), n3=seed.get(2), n4=seed.get(3), n5=seed.get(4), n6=seed.get(5), n7=seed.get(6), n8=seed.get(7), n9=seed.get(8);
		int[][] board = {{n1,n2,n3,n4,n5,n6,n7,n8,n9}
						,{n4,n5,n6,n7,n8,n9,n1,n2,n3}
						,{n7,n8,n9,n1,n2,n3,n4,n5,n6}
						,{n2,n3,n1,n5,n6,n4,n8,n9,n7}
						,{n5,n6,n4,n8,n9,n7,n2,n3,n1}
						,{n8,n9,n7,n2,n3,n1,n5,n6,n4}
						,{n3,n1,n2,n6,n4,n5,n9,n7,n8}
						,{n6,n4,n5,n9,n7,n8,n3,n1,n2}
						,{n9,n7,n8,n3,n1,n2,n6,n4,n5}
						};
		
		// ���θ� 3�� �� ��� ����.
		// 0,1,2 ����Ʋ�� ���� ������� �迭, 3ĭ�� �ݺ�.
		List<Integer> random = new ArrayList<>();
		for (int i=0; i<3;i++) {
			random.add(i);
		}
		
		for(int i=0; i<7; i+=3) {
			Collections.shuffle(random);
			int[] row_temp = board[i];
			board[i] = board[random.get(0)+i];
			board[random.get(0)+i] = board[random.get(1)+i];
			board[random.get(1)+i] = row_temp;
		}
		// ���� ���θ� �迭�� �޾Ƽ� copy �迭�� ����� ���ο� ���� ������� ���� �ٽ� ���忡 ���� �־��ش�.
		// ���� 3�پ� ����� ����.
		int count = 0;
		int [][]copy = new int[9][9];
		while (count < 9) {
			for(int i=0; i<9; i++) {
				copy[count][i] = board[i][count];
			}
			count++;
		}
		for(int i=0; i<7; i+=3) {
			Collections.shuffle(random);
			int[] col_temp = copy[i];
			copy[i] = copy[random.get(0)+i];
			copy[random.get(0)+i] = copy[random.get(1)+i];
			copy[random.get(1)+i] = col_temp;
		}
		count = 0;
		while (count < 9) {
			for(int i=0; i<9; i++) {
				board[i][count] = copy[count][i];
			}
			count++;
		}
			
		return board;
	}
    
    // ���̵� �ޱ⿡�� ���� ���� ������ŭ ������ �մ� �Լ�
    public static int[][] MakeHoles(int[][] board,int holes) {
    	int [][] p_board = board;
    	int i,j,holes_num;
    	holes_num = holes;
    	while (holes_num>0) {
    		i = (int) (Math.random()*9);
    		j = (int) (Math.random()*9);
    		if(p_board[i][j] == 0) {
    			continue;
    		}
    		p_board[i][j] = 0;
    		holes_num--;
    	}
    	return p_board;
    }
    
    // ������ ���� ��ġ�� �������ִ� �Լ�.
    // ù ��° �迭�� ����, �� ��° �迭�� ����.
    public static int[][] Holeset(int[][] p_board, int holes_num){
    	int[][] holeset = new int[2][holes_num];
    	int holes = holes_num;
	    for(int i=0; i<9; i++) {
	    	for(int j=0; j<9; j++) {
	    		if (p_board[i][j] == 0) {
	    			holeset[0][(holes_num-holes)] = i;
	    			holeset[1][(holes_num-holes)] = j;
	    			holes--;
	    		}
	    	}
	    }
    	return holeset;
    }
    
}