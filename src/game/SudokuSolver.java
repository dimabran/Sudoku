package game;


public class SudokuSolver {

	private int [][] mat;
	private boolean [][][] checkNumbers;
	
	public SudokuSolver(int [][]mat)
	{
		this.mat=mat;
		checkNumbers=new boolean[9][9][9];
		for (int i=0;i<9;i++)
			for (int j=0;j<9;j++)
				for (int z=0;z<z;z++)
					checkNumbers[i][j][z]=true;
		solve(0, 0);
	}
	
	public boolean solve(int i, int j) 
	{//if end of the board
		if (i == 9) 
		{
			i = 0;
			if (++j == 9)
				return true;
		}
		if (mat[i][j] != 0) //if cell is empty
		return solve(i+1,j);

		for (int current = 1; current <= 9; ++current) 
		{
			if (legalMove(i,j,current)) 
			{
				mat[i][j] = current;
				if (solve(i+1,j))
					return true;
			}
		}
		mat[i][j] = 0;
		return false;
	}

	private boolean legalMove(int i, int j, int current) 
	{
		for(int col=0;col<9;col++) 
		{//checks the column for the number
			if(current == mat[i][col])
				return false;
		}
		for(int row=0;row<9;row++) 
		{//checks the row for the num
			if(current == mat[row][j])
				return false;
		}
		
		//checks which block the number is in.
		int cornerX = 0;
		int cornerY = 0;
		if(i > 2)
			if(i > 5)
				cornerX = 6;
			else
				cornerX = 3;
		if(j > 2)
			if(j > 5)
				cornerY = 6;
			else
				cornerY = 3;
		//checks if number is in block.
		for(int line=cornerX;line<10 && line<cornerX+3;line++)
			for(int col=cornerY;col<10 && col<cornerY+3;col++)
				if(current == mat[line][col])
					return false;
		return true;
	}

	public int[][] getMat()
	{
		return mat;
	}
}
