package game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Square extends JPanel{

		private GridLayout gLayout;
		private Cell[][] cells;
		

		public Square(int[][] mat) 
		{
			Border border;
			border= BorderFactory.createLineBorder(Color.BLACK);
			setBorder(border);
			cells=new Cell[3][3];
			this.gLayout = new GridLayout(3,3);
			setLayout(gLayout);
			for (int i=0;i<3;i++)
			{
				for (int j=0;j<3;j++)
				{
					cells[i][j]=new Cell();
					add (cells[i][j].getCell());	
					cells[i][j].setNumber(0);
					cells[i][j].setDisable();

				}
			}
		}
		public Cell getCell(int row,int col){
			return cells[row][col];
		}


}
