package battleshipassignment;

import javax.swing.JOptionPane;

public class PlaceShipsCafK extends PlayBattleshipCafK {
	private static String [] row1User = {"   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 "};
	private static String [] row2User = {" A ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row3User = {" B ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row4User = {" C ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row5User = {" D ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row6User = {" E ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row7User = {" F ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row8User = {" G ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row9User = {" H ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [][] gridUser = {row1User, row2User, row3User, row4User, row5User, row6User, row7User, row8User, row9User};
	
	public String PlaceShipsCafK() {
		String userGameBoard = "";
		JOptionPane.showMessageDialog(null, "We will now place ships! Here are the following ships you can place: \n" 
									  + "     - Carrier: 5 Tiles \n"
									  + "     - Battleship: 4 Tiles \n"
									  + "     - Destroyer: 3 Tiles \n"
									  + "     - Submarine: 3 Tiles \n"
									  + "     - Patrol Boat: 2 Tiles \n");
		int ships = 5;
		
		while (ships == 5) { //Carrier
			String inputRow = "";
			int rowOption = 0;
			int columnOption = 0;
			boolean firstCheck = false;
			
			while (firstCheck == false) {
				inputRow = JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the row to add your CARRIER");
				inputRow.toUpperCase();
				rowOption = ((int)inputRow.charAt(0))-64;
				columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the column to add your CARRIER"));
				firstCheck = invalidInput(rowOption, columnOption);
			}			
			
			
			userGameBoard = changeGameboardUser(rowOption, columnOption);
			
			int option = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "\n Would you like to go horizontal (1) or vertical (2)?"));
				
			System.out.println(option);
				
			if (option == 1) { //Column
				System.out.println("Test");
				if (columnOption >= 5) {
					for (int i = 1; i < 5; i++) {
						userGameBoard = changeGameboardUser(rowOption, columnOption - i);
					}
				} if (columnOption <= 4) {
					for (int i = 1; i < 5; i++) {
						userGameBoard = changeGameboardUser(rowOption, columnOption + i);
					}
				}
				
			}
				
			if (option == 2) { //Row
				System.out.println("Test");
				if (rowOption >= 5) {
					for (int i = 1; i < 5; i++) {
						userGameBoard = changeGameboardUser(rowOption - i, columnOption);
					}
				} if (rowOption <= 4) {
					for (int i = 1; i < 5; i++) {
						userGameBoard = changeGameboardUser(rowOption + i, columnOption);
					}
				}
				
			}
			
			ships = 4;
		}
		
		while (ships == 4) { //Battleship
			String inputRow = "";
			int rowOption = 0;
			int columnOption = 0;
			boolean firstCheck = false;
			
			while (firstCheck == false) {
				inputRow = JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the row to add your BATTLESHIP");
				inputRow.toUpperCase();
				rowOption = ((int)inputRow.charAt(0))-64;
				columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "\n You've selected row " + rowOption + " . \n Please input the COLUMN to add your BATTLESHIP"));
				
				firstCheck = invalidInput(rowOption, columnOption);
				
				while (firstCheck == true) {
					if (gridUser[rowOption][columnOption] == " X ") {
						JOptionPane.showMessageDialog(null, userGameBoard + "\n There is already a ship at ROW " + rowOption + ", COLUMN " + columnOption + "! Please input another option (click OK)!");
						firstCheck = false;
					} else {
						firstCheck = true;
						break;
					}
				}
			}	
			
			userGameBoard = changeGameboardUser(rowOption, columnOption);
						
			boolean firstCHECK = true;
			boolean secondCHECK = true;
			boolean thirdCHECK = true;
			boolean fourthCHECK = true;
			boolean finalCHECKDONE = false;
			
			System.out.println("The fourth check is " + fourthCHECK);
			int option = JOptionPane.showOptionDialog(null, "Would you like to go horizontal or vertical?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, getHorizontalVerticalOptions(), getHorizontalVerticalOptions()[0]);
			
			while (finalCHECKDONE == false) {
				if (option == 1) { //Horizontal
					System.out.println("Switching to horizontal");
					if (columnOption > 3 ) {
						for (int i = 1; i < 4; i++) {
							if (gridUser[rowOption][columnOption - i] == " X ") {
								firstCHECK = false;
								System.out.println(firstCHECK + " due to meeting X");
							} else {
								System.out.println(firstCHECK + " due to meeting standards");
							}
						}
														
						if (firstCHECK == true) {
							System.out.println(firstCHECK);
							for (int i = 1; i < 4; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption, columnOption - i);
								finalCHECKDONE = true;
							}
						} else {
							System.out.println("TESTTT");
							option = 0;
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X.");
						}
					}
				
					if (columnOption < 6 && finalCHECKDONE != true) {
						for (int i = 1; i < 4; i++) {
							if (gridUser[rowOption][columnOption + i] == " X ") {
								secondCHECK = false;
								System.out.println(secondCHECK + " TEST due to meeting X");
							} else {
								System.out.println(secondCHECK + " due to meeting standards");
							}
						}
							
						if (secondCHECK == true) {
							System.out.println(secondCHECK);
							for (int i = 1; i < 4; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption, columnOption + i);
								finalCHECKDONE = true;
							}
						} else {
							option = 0;
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
						}
					}
					
					if (firstCHECK == false && secondCHECK == false) {
						option = 1;
						JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
					}
				}
				
				//System.out.println("Broke out of if statement");
				
				if (option == 0) { //Vertical
					System.out.println(rowOption);
					if (rowOption > 3 ) {
						for (int i = 1; i < 4; i++) {
							if (gridUser[rowOption - i][columnOption] == " X ") {
								thirdCHECK = false;
								System.out.println(thirdCHECK + " due to meeting X");
							} else {
								System.out.println(thirdCHECK + " due to meeting standards");
							}
						}
														
						if (thirdCHECK == true) {
							System.out.println(thirdCHECK);
							for (int i = 1; i < 4; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption - i, columnOption);
								finalCHECKDONE = true;
							}
						} 
					}
				
					if (rowOption < 6 && finalCHECKDONE != true) {
						for (int i = 1; i < 4; i++) {
							if (gridUser[rowOption + i][columnOption] == " X ") {
								fourthCHECK = false;
								System.out.println(fourthCHECK + " TEST due to meeting X");
							} else {
								System.out.println(fourthCHECK + " due to meeting standards");
							}
						}
							
						if (fourthCHECK == true) {
							System.out.println(fourthCHECK);
							for (int i = 1; i < 4; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption + i, columnOption);
								finalCHECKDONE = true;
							}
						} 
					}
					
					if (thirdCHECK == false && fourthCHECK == false) {
						option = 1;
						JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
					}
				}
			}
			
			if (finalCHECKDONE == true) {
				System.out.println("Test");
				ships = 3;
			}
			
		}
		
		while (ships == 3) { //Destroyer
			String inputRow = "";
			int rowOption = 0;
			int columnOption = 0;
			boolean firstCheck = false;
			
			while (firstCheck == false) {
				inputRow = JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the row to add your DESTROYER");
				inputRow.toUpperCase();
				rowOption = ((int)inputRow.charAt(0))-64;
				columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "\n You've selected row " + rowOption + " . \n Please input the COLUMN to add your DESTROYER"));
				
				firstCheck = invalidInput(rowOption, columnOption);
				
				while (firstCheck == true) {
					if (gridUser[rowOption][columnOption] == " X ") {
						JOptionPane.showMessageDialog(null, userGameBoard + "\n There is already a ship at ROW " + rowOption + ", COLUMN " + columnOption + "! Please input another option (click OK)!");
						firstCheck = false;
					} else {
						firstCheck = true;
						break;
					}
				}
			}			
			userGameBoard = changeGameboardUser(rowOption, columnOption);
			int option = JOptionPane.showOptionDialog(null, "Would you like to go horizontal or vertical?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, getHorizontalVerticalOptions(), getHorizontalVerticalOptions()[0]);
			
			boolean firstCHECK = true;
			boolean secondCHECK = true;
			boolean thirdCHECK = true;
			boolean fourthCHECK = true;
			boolean finalCHECKDONE = false;
						
			
			while (finalCHECKDONE == false) {
				if (option == 1) { //Horizontal
					System.out.println("Switching to horizontal");
					if (columnOption > 2 ) {
						for (int i = 1; i < 3; i++) {
							if (gridUser[rowOption][columnOption - i] == " X ") {
								firstCHECK = false;
								System.out.println(firstCHECK + " due to meeting X");
							} else {
								System.out.println(firstCHECK + " due to meeting standards");
							}
						}
														
						if (firstCHECK == true) {
							System.out.println(firstCHECK);
							for (int i = 1; i < 3; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption, columnOption - i);
								finalCHECKDONE = true;
							}
						} else {
							System.out.println("TESTTT");
							option = 0;
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X.");
						}
					}
				
					if (columnOption < 7 && finalCHECKDONE != true) {
						for (int i = 1; i < 3; i++) {
							if (gridUser[rowOption][columnOption + i] == " X ") {
								secondCHECK = false;
								System.out.println(secondCHECK + " TEST due to meeting X");
							} else {
								System.out.println(secondCHECK + " due to meeting standards");
							}
						}
							
						if (secondCHECK == true) {
							System.out.println(secondCHECK);
							for (int i = 1; i < 3; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption, columnOption + i);
								finalCHECKDONE = true;
							}
						} else {
							option = 0;
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
						}
					}
					
					if (firstCHECK == false && secondCHECK == false) {
						option = 1;
						JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
					}
				}
				
				//System.out.println("Broke out of if statement");
				
				if (option == 0) { //Vertical
					System.out.println(rowOption);
					if (rowOption > 2) {
						for (int i = 1; i < 3; i++) {
							if (gridUser[rowOption - i][columnOption] == " X ") {
								thirdCHECK = false;
								System.out.println(thirdCHECK + " due to meeting X");
							} else {
								System.out.println(thirdCHECK + " due to meeting standards");
							}
						}
														
						if (thirdCHECK == true) {
							System.out.println(thirdCHECK);
							for (int i = 1; i < 3; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption - i, columnOption);
								finalCHECKDONE = true;
							}
						} 
					}
				
					if (rowOption < 7 && finalCHECKDONE != true) {
						for (int i = 1; i < 3; i++) {
							if (gridUser[rowOption + i][columnOption] == " X ") {
								fourthCHECK = false;
								System.out.println(fourthCHECK + " TEST due to meeting X");
							} else {
								System.out.println(fourthCHECK + " due to meeting standards");
							}
						}
							
						if (fourthCHECK == true) {
							System.out.println(fourthCHECK);
							for (int i = 1; i < 3; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption + i, columnOption);
								finalCHECKDONE = true;
							}
						} 
					}
					
					if (thirdCHECK == false && fourthCHECK == false) {
						option = 1;
						JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
					}
				}
			}
			
			if (finalCHECKDONE == true) {
				System.out.println("Test");
				ships = 2;
			}
			
		}
		
		while (ships == 2) { //Submarine
			String inputRow = "";
			int rowOption = 0;
			int columnOption = 0;
			boolean firstCheck = false;
			
			while (firstCheck == false) {
				inputRow = JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the row to add your SUBMARINE");
				inputRow.toUpperCase();
				rowOption = ((int)inputRow.charAt(0))-64;
				columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "\n You've selected row " + rowOption + " . \n Please input the COLUMN to add your SUBMARINE"));
				
				firstCheck = invalidInput(rowOption, columnOption);
				
				while (firstCheck == true) {
					if (gridUser[rowOption][columnOption] == " X ") {
						JOptionPane.showMessageDialog(null, userGameBoard + "\n There is already a ship at ROW " + rowOption + ", COLUMN " + columnOption + "! Please input another option (click OK)!");
						firstCheck = false;
					} else {
						firstCheck = true;
						break;
					}
				}
			}
			
			userGameBoard = changeGameboardUser(rowOption, columnOption);
			int option = JOptionPane.showOptionDialog(null, "Would you like to go horizontal or vertical?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, getHorizontalVerticalOptions(), getHorizontalVerticalOptions()[0]);
			
			boolean firstCHECK = true;
			boolean secondCHECK = true;
			boolean thirdCHECK = true;
			boolean fourthCHECK = true;
			boolean finalCHECKDONE = false;
						
			while (finalCHECKDONE == false) {
				if (option == 1) { //Horizontal
					System.out.println("Switching to horizontal");
					if (columnOption > 2 ) {
						for (int i = 1; i < 3; i++) {
							if (gridUser[rowOption][columnOption - i] == " X ") {
								firstCHECK = false;
								System.out.println(firstCHECK + " due to meeting X");
							} else {
								System.out.println(firstCHECK + " due to meeting standards");
							}
						}
														
						if (firstCHECK == true) {
							System.out.println(firstCHECK);
							for (int i = 1; i < 3; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption, columnOption - i);
								finalCHECKDONE = true;
							}
						} else {
							System.out.println("TESTTT");
							option = 0;
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X.");
						}
					}
				
					if (columnOption < 7 && finalCHECKDONE != true) {
						for (int i = 1; i < 3; i++) {
							if (gridUser[rowOption][columnOption + i] == " X ") {
								secondCHECK = false;
								System.out.println(secondCHECK + " TEST due to meeting X");
							} else {
								System.out.println(secondCHECK + " due to meeting standards");
							}
						}
							
						if (secondCHECK == true) {
							System.out.println(secondCHECK);
							for (int i = 1; i < 3; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption, columnOption + i);
								finalCHECKDONE = true;
							}
						} else {
							option = 0;
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
						}
					}
					
					if (firstCHECK == false && secondCHECK == false) {
						option = 1;
						JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
					}
				}
				
				//System.out.println("Broke out of if statement");
				
				if (option == 0) { //Vertical
					System.out.println(rowOption);
					if (rowOption > 2) {
						for (int i = 1; i < 3; i++) {
							if (gridUser[rowOption - i][columnOption] == " X ") {
								thirdCHECK = false;
								System.out.println(thirdCHECK + " due to meeting X");
							} else {
								System.out.println(thirdCHECK + " due to meeting standards");
							}
						}
														
						if (thirdCHECK == true) {
							System.out.println(thirdCHECK);
							for (int i = 1; i < 3; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption - i, columnOption);
								finalCHECKDONE = true;
							}
						} 
					}
				
					if (rowOption < 7 && finalCHECKDONE != true) {
						for (int i = 1; i < 3; i++) {
							if (gridUser[rowOption + i][columnOption] == " X ") {
								fourthCHECK = false;
								System.out.println(fourthCHECK + " TEST due to meeting X");
							} else {
								System.out.println(fourthCHECK + " due to meeting standards");
							}
						}
							
						if (fourthCHECK == true) {
							System.out.println(fourthCHECK);
							for (int i = 1; i < 3; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption + i, columnOption);
								finalCHECKDONE = true;
							}
						} 
					}
					
					if (thirdCHECK == false && fourthCHECK == false) {
						option = 1;
						JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
					}
				}
			}
			
			if (finalCHECKDONE == true) {
				System.out.println("Test");
				ships = 1;
			}
			
		}
		
		while (ships == 1) { //Patrol Boat
			String inputRow = "";
			int rowOption = 0;
			int columnOption = 0;
			boolean firstCheck = false;
			
			while (firstCheck == false) {
				inputRow = JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the row to add your PATROL BOAT");
				inputRow.toUpperCase();
				rowOption = ((int)inputRow.charAt(0))-64;
				columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "\n You've selected row " + rowOption + " . \n Please input the COLUMN to add your PATROL BOAT"));
				
				firstCheck = invalidInput(rowOption, columnOption);
				
				while (firstCheck == true) {
					if (gridUser[rowOption][columnOption] == " X ") {
						JOptionPane.showMessageDialog(null, userGameBoard + "\n There is already a ship at ROW " + rowOption + ", COLUMN " + columnOption + "! Please input another option (click OK)!");
						firstCheck = false;
					} else {
						firstCheck = true;
						break;
					}
				}
			}
			
			//userGameBoard = changeGameboardUser(rowOption, columnOption);
			int option = JOptionPane.showOptionDialog(null, "Would you like to go horizontal or vertical?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, getHorizontalVerticalOptions(), getHorizontalVerticalOptions()[0]);
			
			boolean firstCHECK = true;
			boolean secondCHECK = true;
			boolean thirdCHECK = true;
			boolean fourthCHECK = true;
			boolean finalCHECKDONE = false;
									
			while (finalCHECKDONE == false) {
				if (option == 1) { //Horizontal
					System.out.println("Switching to horizontal");
					if (columnOption > 1 ) {
						for (int i = 0; i < 2; i++) {
							if (gridUser[rowOption][columnOption - i] == " X ") {
								firstCHECK = false;
								System.out.println(firstCHECK + " due to meeting X");
							} else {
								System.out.println(firstCHECK + " due to meeting standards");
							}
						}
														
						if (firstCHECK == true) {
							System.out.println(firstCHECK);
							for (int i = 0; i < 2; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption, columnOption - i);
								finalCHECKDONE = true;
							}
						} else {
							System.out.println("TESTTT");
							option = 0;
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X.");
						}
					}
				
					if (columnOption < 8 && finalCHECKDONE != true) {
						for (int i = 0; i < 2; i++) {
							if (gridUser[rowOption][columnOption + i] == " X ") {
								secondCHECK = false;
								System.out.println(secondCHECK + " TEST due to meeting X");
							} else {
								System.out.println(secondCHECK + " due to meeting standards");
							}
						}
							
						if (secondCHECK == true) {
							System.out.println(secondCHECK);
							for (int i = 0; i < 2; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption, columnOption + i);
								finalCHECKDONE = true;
							}
						} else {
							option = 0;
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
						}
					}
					
					if (firstCHECK == false && secondCHECK == false) {
						option = 1;
						JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
					}
				}
				
				//System.out.println("Broke out of if statement");
				
				if (option == 0) { //Vertical
					System.out.println(rowOption);
					if (rowOption > 1) {
						for (int i = 0; i < 2; i++) {
							if (gridUser[rowOption - i][columnOption] == " X ") {
								thirdCHECK = false;
								System.out.println(thirdCHECK + " due to meeting X");
							} else {
								System.out.println(thirdCHECK + " due to meeting standards");
							}
						}
														
						if (thirdCHECK == true) {
							System.out.println(thirdCHECK);
							for (int i = 0; i < 2; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption - i, columnOption);
								finalCHECKDONE = true;
							}
						} 
					}
				
					if (rowOption < 8 && finalCHECKDONE != true) {
						for (int i = 0; i < 2; i++) {
							if (gridUser[rowOption + i][columnOption] == " X ") {
								fourthCHECK = false;
								System.out.println(fourthCHECK + " TEST due to meeting X");
							} else {
								System.out.println(fourthCHECK + " due to meeting standards");
							}
						}
							
						if (fourthCHECK == true) {
							System.out.println(fourthCHECK);
							for (int i = 0; i < 2; i++) {
								System.out.println("Printing");
								userGameBoard = changeGameboardUser(rowOption + i, columnOption);
								finalCHECKDONE = true;
							}
						} 
					}
					
					if (thirdCHECK == false && fourthCHECK == false) {
						option = 1;
						JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X.");
					}
				}
			}
			
			if (finalCHECKDONE == true) {
				System.out.println("Test");
				ships = 0;
			}
			
		}
		
		return userGameBoard;
		
	
	}
	
}
