package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class SudokuBoard extends JFrame {
	private Graphics frameGraphics ;
	private	Graphics offgc;
	private Image offscreen = null;
	private Dimension d = null;
	private boolean run;
	private SudokuPanel panel;
	private JMenuBar menubar;
	private JMenu newGame;
	private JMenuItem easy;
	private JMenuItem hard;
	private JMenuItem veryHard;
	private JMenu solve;
	private JMenu finish;
	private JMenu buildBoard;
	public SudokuBoard() 
	{
		super("Suduko");
		panel=new SudokuPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menubar=new JMenuBar();
		newGame=new JMenu("New Game");
		finish =new JMenu("Check");
		solve=new JMenu("Solve"); 
		menubar.add(newGame);
		menubar.add(finish);
		menubar.add(solve);
		solve.addMenuListener(new mouseLisenerForSolving());
		finish.addMenuListener(new mouseLisenerForFinish());
		
		easy=new JMenuItem("Easy");
		easy.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int holesToMake = (int) ((Math.random()*6)+30); 
				SudokuPanel.buildSudoku(holesToMake);
			}
		});
		hard = new JMenuItem("Hard");
		hard.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int holesToMake = (int) ((Math.random()*6)+40);
				SudokuPanel.buildSudoku(holesToMake);
			}
		});
		veryHard = new JMenuItem("Very Hard");
		veryHard.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int holesToMake = (int) ((Math.random()*10)+55);  
				SudokuPanel.buildSudoku(holesToMake);
			}
		});
		
		newGame.add(easy);
		newGame.add(hard);
		newGame.add(veryHard);
		pack();
		setJMenuBar(menubar);
		setSize(500,500);
		setVisible(true);
		d = this.getSize();
		add(panel);
		offscreen = this.createImage(getWidth(),getHeight());
		offgc=offscreen.getGraphics();
		run = true;
	}
	
class mouseLisenerForSolving implements MenuListener
	{


		@Override
		public void menuCanceled(MenuEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void menuDeselected(MenuEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void menuSelected(MenuEvent arg0) {
			SudokuPanel.solveSudoku();
			
		}
		
	}

class mouseLisenerForFinish implements MenuListener{

	
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void menuSelected(MenuEvent e) {
		SudokuPanel.finishTheBoard();
		
	}
	
}

	public static void main(String[] args) {
		SudokuBoard b1=new SudokuBoard();
	}
}