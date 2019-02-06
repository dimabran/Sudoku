package game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SudokuPanel extends JPanel{
	private GridLayout gLayout;//general layout
	private static Square[][] squares;
	public static int mat [][];
	public static int solution [][];
	
	public SudokuPanel() {
		gLayout=new GridLayout(3,3);
		setLayout(gLayout);
		squares=new Square[3][3];
		mat=new int[9][9];
		solution=new int [9][9];
		for (int i=0;i<3;i++)
			for (int j=0;j<3;j++)
			{
				squares[i][j]=new Square(mat);
				add(squares[i][j]);
			}
		setRowAndColForCells();
	}
	public void setRowAndColForCells()
	{
		int jCol=0;
		int jRow=0;
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				for (int line=0;line<3;line++)
				{
					for (int col=0;col<3;col++)
					{
						squares[i][j].getCell(line, col).setRowAndCol(line+jRow, col+jCol);
					}
				}
				jCol+=3;
			}
			jCol=0;
			jRow+=3;
		}
	}
	
	public static void buildSudoku(int holesToMake)
	{
		mat=new SudokuBuilder(holesToMake).getBoard();
		for (int i =0;i<9;i++){
			for (int j=0;j<9;j++)
			{
				solution[i][j]=mat[i][j];
			}
		}
		solution= new SudokuSolver(solution).getMat();

		int jCol=0;
		int jLine=0;
		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++){
				for (int line=0;line<3;line++){
					for (int col=0;col<3;col++){
						squares[i][j].getCell(line, col).setNumber(mat[line+jLine][col+jCol]);
						squares[i][j].getCell(line, col).setEnable();
						squares[i][j].getCell(line, col).setMat(mat);
						squares[i][j].getCell(line, col).setBlackBorder();

					}
				}
				jCol+=3;
			}
			jCol=0;
			jLine+=3;
		}


	}
	
	public static void finishTheBoard()
	{
		if(SudokuBuilder.isStart == true)
		{
			boolean win=true;
				for (int i=0;i<9;i++)
					for (int j=0;j<9;j++)
						if (mat[i][j]!=solution[i][j])
						{
							squares[i/3][j/3].getCell(i%3, j%3).setBlackBorder();
							win=false;
						}
				 
				if (!win)
				{
				for (int i=0;i<9;i++)
					for (int j=0;j<9;j++)
						if (mat[i][j]!=solution[i][j])
						{
							squares[i/3][j/3].getCell(i%3, j%3).setRedBorder();
						}
				JOptionPane.showMessageDialog(null, "There are some mistakes");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Congratulations! you win!");
				}
			}
		else
			JOptionPane.showMessageDialog(null, "Please start the game first");
	}

	public static void solveSudoku()
	{
		if(SudokuBuilder.isStart == true)
		{
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to solve the board?","Warning",dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
				int jCol=0;
				int jRow=0;
				for (int i=0;i<3;i++){
					for (int j=0;j<3;j++){
						for (int row=0;row<3;row++){
							for (int col=0;col<3;col++){
								squares[i][j].getCell(row, col).setNumber(solution[row+jRow][col+jCol]);
								mat[row+jRow][col+jCol] = solution[row+jRow][col+jCol];
							}
						}
						jCol+=3;
					}
					jCol=0;
					jRow+=3;
				}
		
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Please start the game first");
	}
}
