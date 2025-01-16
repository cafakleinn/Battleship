package battleshipassignment;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class PrintBattleshipBoardCafK extends PlayBattleshipCafK {
	
	public PrintBattleshipBoardCafK() {
		String [] row1 = {"   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 "};
		String [] row2 = {" A ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row3 = {" B ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row4 = {" C ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row5 = {" D ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row6 = {" E ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row7 = {" F ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row8 = {" G ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row9 = {" H ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [][] grid = {row1, row2, row3, row4, row5, row6, row7, row8, row9};
		
		String stringRow1 = (Arrays.toString(row1).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow2 = (Arrays.toString(row2).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow3 = (Arrays.toString(row3).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow4 = (Arrays.toString(row4).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow5 = (Arrays.toString(row5).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow6 = (Arrays.toString(row6).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow7 = (Arrays.toString(row7).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow8 = (Arrays.toString(row8).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow9 = (Arrays.toString(row9).replace("[", "").replace("]", "").replace(",", ""));
		String stringBoard = stringRow1 + "\n" + stringRow2 + "\n" + stringRow3 + "\n" + stringRow4 + "\n" + stringRow5 + "\n" + stringRow6 + "\n" +stringRow7 + "\n" +stringRow8 + "\n" +stringRow9 + "\n";				
		
		//return stringBoard;
		//JOptionPane.showMessageDialog(null, stringBoard);
	
	}
	
	public String changeGameboard(int r, int c) {
		int row = r;
		int column = c;
		
		
		String [] row1 = {"   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 "};
		String [] row2 = {" A ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row3 = {" B ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row4 = {" C ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row5 = {" D ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row6 = {" E ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row7 = {" F ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row8 = {" G ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row9 = {" H ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [][] grid = {row1, row2, row3, row4, row5, row6, row7, row8, row9};
		
		grid[row-7][column-7] = " X ";
		
		String stringRow1 = (Arrays.toString(row1).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow2 = (Arrays.toString(row2).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow3 = (Arrays.toString(row3).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow4 = (Arrays.toString(row4).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow5 = (Arrays.toString(row5).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow6 = (Arrays.toString(row6).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow7 = (Arrays.toString(row7).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow8 = (Arrays.toString(row8).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow9 = (Arrays.toString(row9).replace("[", "").replace("]", "").replace(",", ""));
		String stringBoard = stringRow1 + "\n" + stringRow2 + "\n" + stringRow3 + "\n" + stringRow4 + "\n" + stringRow5 + "\n" + stringRow6 + "\n" +stringRow7 + "\n" +stringRow8 + "\n" +stringRow9 + "\n";				
		
		JOptionPane.showMessageDialog(null, stringBoard);
		return stringBoard;
	}
}
