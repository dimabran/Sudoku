package game;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Cell implements ActionListener {

	private JButton cell;
	private int num;
	private int row;
	private int col;
	private int[][] mat;
	public Cell() {
		
		cell=new JButton();
		cell.addActionListener(this);
		cell.addKeyListener(new KL());
		cell.setBorderPainted(true);
		row=0;
		col=0;
	}
	//sets cells row and col
	public void setRowAndCol(int row,int col)
	{
		this.row=row;
		this.col=col;
	}
	public void setMat(int[][]mat){
		this.mat=mat;
	}
	public int getRow(){
		return row;
	}
	public int getCol()
	{
		return col;
	}
	//disables cell
	public void setDisable(){
		cell.setEnabled(false);
	}
	//enables cell
	public void setEnable(){
		cell.setEnabled(true);
	}
	public JButton getCell() 
	{
		return cell;
	}
	//sets the border color to red
	public void setRedBorder()
	{
		Border border;
		border= BorderFactory.createLineBorder(Color.RED);
		cell.setBorder(border);
	}
	//sets the border color to black
	public void setBlackBorder()
	{
		Border border;
		border= BorderFactory.createLineBorder(Color.BLACK);
		cell.setBorder(border);
		
	}
	//sets the background color to grey
	public void setGrayBackground()
	{
		cell.setBackground(Color.GRAY);
		cell.setOpaque(true);
	}
	//sets the background color to white
	public void setWhiteBackground()
	{
		cell.setBackground(Color.WHITE);
		cell.setOpaque(true);
	}
	public int getNumber() {
		return num;
	}
	//sets the cell number
	public void setNumber(int num){
		this.num=num;
		if(num == 0)
		{
			cell.setText("");
			this.setWhiteBackground();
		}
		else
			cell.setText(Integer.toString(num));
	}
	
	class AL implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			KeyListener k=new KL();

		}

	}

	class KL implements KeyListener{


		public void keyPressed(KeyEvent e) {
			if (getNumber()!=0){
				if (getNumber()%10!=0){
					if (e.getKeyCode()>48&&e.getKeyCode()<58)
							setNumber(e.getKeyCode()-48);
					if (e.getKeyCode()>96&&e.getKeyCode()<106)
							setNumber(e.getKeyCode()-96);
					SudokuPanel.mat[row][col]=getNumber();
				}
			}
			else{

				if (e.getKeyCode()>48&&e.getKeyCode()<58)
						setNumber(e.getKeyCode()-48);
				if (e.getKeyCode()>96&&e.getKeyCode()<106)
						setNumber(e.getKeyCode()-96);
				SudokuPanel.mat[row][col]=getNumber();
				

			}	
			
		}

		
		public void keyReleased(KeyEvent e) {
			
		}

		
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
}
