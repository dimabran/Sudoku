package game;
import java.util.Random;


public class SudokuBuilder {
	private int mat[][];
	public static boolean isStart = false;
	
	public SudokuBuilder(int holesToMake)
	{
		isStart = true;
		mat=new int[9][9];
		nextCell(0, 0);
		makeHoles(holesToMake);
	}

	public boolean nextCell(int x, int y)
	{
		int nextX = x;
		int nextY = y;
		int[] toCheck = {1,2,3,4,5,6,7,8,9};
		Random r = new Random();
		int tmp = 0;
		int current = 0;
		int top = toCheck.length;
		
		//scrambles the numbers in toCheck
   		for(int i=top-1;i>0;i--)
		{
		    current = r.nextInt(i);
		    tmp = toCheck[current];
		    toCheck[current] = toCheck[i];
		    toCheck[i] = tmp;
    	}
		
		for(int i=0;i<toCheck.length;i++)
		{
			if(legalMove(x, y, toCheck[i])) // checks if number is legal
			{
				mat[x][y] = toCheck[i];
				if(x == 8)
				{
					if(y == 8)
						return true;//if board is full
					else
					{
						nextX = 0; //
						nextY = y + 1;
					}
				}
				else
				{
					nextX = x + 1;
				}
			if(nextCell(nextX, nextY)) // calls recursive nethod nextCall to do next cell.
				return true;
		}
	}
	mat[x][y] = 0;
	return false;
	}

	private boolean legalMove(int i, int j, int current) 
	{
		for(int col=0;col<9;col++) 
		{//checks if num is in col
			if(current == mat[i][col])
				return false;
		}
		for(int row=0;row<9;row++) 
		{//checks if num is in row
			if(current == mat[row][j])
				return false;
		}
		//determined which block that number is in.
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
		//checks the block for the number
		for(int line=cornerX;line<10 && line<cornerX+3;line++)
			for(int col=cornerY;col<10 && col<cornerY+3;col++)
				if(current == mat[line][col])
					return false;
		return true;
	}
	
	public void makeHoles(int holesToMake)
	{
		double generalHoles = 81;

		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
			{
				double holeChance = holesToMake/generalHoles;
				double r=Math.random();
				if((r <= holeChance))
				{
					mat[i][j] = 0;
					holesToMake--;
				}
				generalHoles--;
			}
	}
	
	public int[][] getBoard()
	{
		return mat;
	}
	
}

