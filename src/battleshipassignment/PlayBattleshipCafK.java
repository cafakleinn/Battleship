/**
 * This class represents playing Battleship.
 * 
 * Added:
 *      - Supressed warnings at line 73 for computerGameBoardEmpty not being used. 
 * 
 * @author Klein Cafa
 */

package battleshipassignment;

import java.awt.Font;
import java.util.Arrays;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class PlayBattleshipCafK extends BattleshipDriverCafK { // Added extends.
	private String [] horizontalVerticalOptions = {"Vertical", "Horizontal"}; // Options when user is wanting to go horizontal or vertical.
	private boolean winner = false; // If winner is true, the game will end.
	private static Random rand = new Random(); 
	private static int numberOfUserHits = 0; // Track number of times the user hits a ship.
	private static int numberOfComputerHits = 0; // Track number of times the computer hits a ship.
	
	//Arrays for the user's grid with ships.
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
	
	//Arrays for the computer's grid with ships.
	private static String [] row1Computer = {"   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 "};
	private static String [] row2Computer = {" A ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row3Computer = {" B ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row4Computer = {" C ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row5Computer = {" D ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row6Computer = {" E ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row7Computer = {" F ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row8Computer = {" G ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row9Computer = {" H ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [][] gridComputer = {row1Computer, row2Computer, row3Computer, row4Computer, row5Computer, row6Computer, row7Computer, row8Computer, row9Computer};
	
	//Arrays for the user's grid when guessing.
	private static String [] row1UserEmpty = {"   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 "};
	private static String [] row2UserEmpty = {" A ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row3UserEmpty = {" B ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row4UserEmpty = {" C ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row5UserEmpty = {" D ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row6UserEmpty = {" E ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row7UserEmpty = {" F ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row8UserEmpty = {" G ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row9UserEmpty = {" H ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [][] gridUserEmpty = {row1UserEmpty, row2UserEmpty, row3UserEmpty, row4UserEmpty, row5UserEmpty, row6UserEmpty, row7UserEmpty, row8UserEmpty, row9UserEmpty};
	
	//Arrays for the computer's grid when guessing.
	private static String [] row1ComputerEmpty = {"   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 "};
	private static String [] row2ComputerEmpty = {" A ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row3ComputerEmpty = {" B ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row4ComputerEmpty = {" C ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row5ComputerEmpty = {" D ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row6ComputerEmpty = {" E ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row7ComputerEmpty = {" F ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row8ComputerEmpty = {" G ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [] row9ComputerEmpty = {" H ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
	private static String [][] gridComputerEmpty = {row1ComputerEmpty, row2ComputerEmpty, row3ComputerEmpty, row4ComputerEmpty, row5ComputerEmpty, row6ComputerEmpty, row7ComputerEmpty, row8ComputerEmpty, row9ComputerEmpty};
	private String userGameBoardEmpty = ""; //User's grid when guessing as a string.
	@SuppressWarnings("unused")
	private String computerGameBoardEmpty = ""; //Computer's grid when guessing as a string.
	
	public PlayBattleshipCafK() {
		//Variables:
		String [] firstSecond = {"Second", "First"}; //Options when wanting to go first or second.
		String [] changeBoard = {"Continue!", "No wait, I want to change the board!"};
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Monospaced", Font.PLAIN, 12))); //Font for JOptionPane.   
		
		//Input & Processing:
		String userGameBoard = placeShips(); //Method to add ships.
		System.out.println("User's Board: \n" + userGameBoard);
		String computerGameBoard = computerPlaceShips(); //Method for the computer to add ships onto its board.
		System.out.println("Computer's Board: \n" + computerGameBoard);
		
		var oneLastCheck = JOptionPane.showOptionDialog(null, "Here is what your board looks like! Would you like to change anything, "
														+ "or continue? \n \n" + userGameBoard, "Before we start...", 
														JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, changeBoard, 
														changeBoard[0]);
		if (oneLastCheck == 1) {
			JOptionPane.showMessageDialog(null, "Redirecting you to place your ships again!");
			userGameBoard = placeShips();
		}
		var firstSecondPlayer = JOptionPane.showOptionDialog(null, "You will be playing against a computer! Would you like to go first "
															 + "or second?", "Before we start...", JOptionPane.DEFAULT_OPTION, 
															 JOptionPane.INFORMATION_MESSAGE, null, firstSecond, firstSecond[0]);
		userGameBoardEmpty = printGameboard(); //Empty gameboard used to show the user's selections on the computer's board.
		computerGameBoardEmpty = printGameboard(); //Empty gameboard used to show the computer's selections on the user's board.
		if (firstSecondPlayer == 1) { //If user is going first.
			playGameUser();
		} if (firstSecondPlayer == 0) { //If computer is going first.
			playGameComputer();
		}
	}
	
	/**
	 * Method for the user to pick coordinates in order to hit a ship.
	 */
	public void playGameUser() {
		//Variables:
		String inputRow = "";
		boolean firstCheck = false;
		int rowOption = 0;
		int columnOption = 0;
		
		//Input & Processing:
		if (numberOfUserHits == 17) { //This if statement is first before asking the user to input. If the user reaches
									  //17 hits, the private boolean winner is set to true and the game ends.
			JOptionPane.showMessageDialog(null, "User wins!");
			winner = true;
		}
		
		while (winner == false && firstCheck == false) { //If statement where there is no winner yet. This will ask the user for their input.
			inputRow = JOptionPane.showInputDialog(null, userGameBoardEmpty + "\n Please input the row to place your hit (letters A-H"
													   + ", not case sensitive)!");
			
			inputRow.toUpperCase();                   	  //Converting the row input to uppercase for easier processing.
			rowOption = ((int)inputRow.charAt(0))-64; 	  //Converting the row input to ASCII decimal value, then subtracting 64. 
														  //(for example, letter A would be decimal value 65. Subtracting would be 1, 
														  //which would be the row number!
			
			columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoardEmpty + "\n You've seleved row " + 
																		inputRow + "! Please input the column to finalize your hit "
																		+ "(numbers 1-8)!"));
	
			//If statement to check if the selection is already hit with X (hit) or / (water).
			
			if (gridUserEmpty[rowOption][columnOption] == " X " || gridUserEmpty[rowOption][columnOption] == " / ") {
				JOptionPane.showMessageDialog(null, "You already hit row " + inputRow + " , column " + columnOption + "! Please "
											  + "try again!");
			} else {
				firstCheck = true;
			}
		
			if (firstCheck == true) {
				userGameBoardEmpty = changeGameboardUserEmpty(rowOption, columnOption); //Use the method to change the user's empty gameboard
																						//to the selected row and column.
				//playGameComputer(); //Go to the void method where it is the computer's turn.
			}
			//break;
		}
		
		playGameComputer(); //Go to the void method where it is the computer's turn.

	}
	
	/**
	 * Method for the computer to pick random coordinates to hit a ship.
	 */
	public void playGameComputer() { 
		if (numberOfComputerHits == 17) { 	//This if statement is first before letting the computer pick a coordinate. If the computer
				 							//reaches 17 hits, the private boolean winner is set to true and the game ends.
			JOptionPane.showMessageDialog(null, "Computer wins!");
			winner = true;
		}
		
		if (winner == false) { //If statement where there is no winner yet. This will let the computer pick a random coordinate.
			int rowOption = rand.nextInt(1, 9); //Use the rand variable to pick a random number.
			int columnOption = rand.nextInt(1, 9);;
			computerGameBoardEmpty = changeGameboardComputerEmpty(rowOption, columnOption); //Use the method to change the empty gameboard
																							//to the selected row and column.
			playGameUser(); //Go to the void method where it is the user's turn.
		}
	}
	
	/**
	 * Getter method to ask the user where they want to place ships.
	 * @return constructed game board of the user with ships.
	 */
	public String placeShips() {
		String userGameBoard = printGameboard(); //Make a variable called userGameBoard to show an empty gameboard.
		int ships = 5; //Variable to track how many ships to add.
		JOptionPane.showMessageDialog(null, "We will now place ships! Here are the following ships you can place on an 8x8 grid: \n" 
									  + "     - Carrier: 5 Tiles \n"
									  + "     - Battleship: 4 Tiles \n"
									  + "     - Destroyer: 3 Tiles \n"
									  + "     - Submarine: 3 Tiles \n"
									  + "     - Patrol Boat: 2 Tiles \n \n"
									  + userGameBoard);
		
		while (ships == 5) { //Carrier //While loop where the user must pick coordinates for this ship. All checks must be completed 
									   //before moving to the next ship.
			//These variables are repetitive in each ship, which includes the string input for row, integer input for column and 
			//the boolean for the first check.
			String inputRow = "";
			int rowOption = 0;
			int columnOption = 0;
			boolean firstCheck = false;
			
			//This first check is to see if the user inputs coordinates where an X is placed, or if coordinates are not within the 
			//correct coordinates.
			while (firstCheck == false) {
				inputRow = JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the row to add your CARRIER!");
				inputRow.toUpperCase(); //Same lines of code earlier to convert to ASCII decimal.
				rowOption = ((int)inputRow.charAt(0))-64;
				columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "You've selected row " + inputRow + "!\n "
																			+ "Please input the column to add your CARRIER!"));
				firstCheck = invalidInput(rowOption, columnOption); //Method to check if the input is valid, which returns a boolean.
			}			
			
			userGameBoard = changeGameboardUser(rowOption, columnOption); //Change the grid of the user that includes ships.
	
			int option = JOptionPane.showOptionDialog(null, "Would you like to go horizontal or vertical?", null, JOptionPane.DEFAULT_OPTION, 
													  JOptionPane.INFORMATION_MESSAGE, null, horizontalVerticalOptions, 
													  horizontalVerticalOptions[0]);
			if (option == 1) { //Horizontal
				if (columnOption >= 5) { //If the column input is greater than 5, it will subtract i as it can be above the length of the array (8).
					for (int i = 1; i < 5; i++) {
						userGameBoard = changeGameboardUser(rowOption, columnOption - i); //Method to change the grid of the user.
					}
				} if (columnOption <= 4) { //If the column input is less than 5, it will add i as it can be below the length of the array (8).
					for (int i = 1; i < 5; i++) {
						userGameBoard = changeGameboardUser(rowOption, columnOption + i); 
					}
				}
			}
				
			if (option == 0) { //Vertical
				if (rowOption >= 5) { //If the row input is greater than 5, it will subtract i as it can be above the length of the array (8).
					for (int i = 1; i < 5; i++) {
						userGameBoard = changeGameboardUser(rowOption - i, columnOption); //Method to change the grid of the user.
					}
				} if (rowOption <= 4) { //If the row input is less than 5, it will add i as it can be below the length of the array (8).
					for (int i = 1; i < 5; i++) {
						userGameBoard = changeGameboardUser(rowOption + i, columnOption);
					}
				}
			}
			
			ships = 4; //Change ships to 4 to move onto battleship.
		}
		
		while (ships == 4) { //Battleship //While loop where the user must pick coordinates for this ship. All checks must be completed 
										  //before moving to the next ship.
			//Same variables as ships == 5.
			String inputRow = "";
			int rowOption = 0;
			int columnOption = 0;
			//Variables below are used to track the checks before changing the grid to the user's selection. 
			boolean firstCheck = false;
			boolean firstCHECK = true;
			boolean secondCHECK = true;
			boolean thirdCHECK = true;
			boolean fourthCHECK = true;
			boolean finalCHECKDONE = false;
			
			//This first check is to see if the user inputs coordinates where an X is placed, or if coordinates are not within the 
			//correct coordinates.
			while (firstCheck == false) {
				inputRow = JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the row to add your BATTLESHIP!");
				inputRow.toUpperCase();
				rowOption = ((int)inputRow.charAt(0))-64;
				columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "\n You've selected row " + inputRow 
																			+ "! \n Please input the COLUMN to add your BATTLESHIP"));
				firstCheck = invalidInput(rowOption, columnOption); //Method to returns a boolean, checking if the input is between letters 
																	//A to H and numbers 1 to 8.
				
				while (firstCheck == true) { //While loop to check if the current selection has an X.
					if (gridUser[rowOption][columnOption] == " X ") {
						JOptionPane.showMessageDialog(null, userGameBoard + "\n There is already a ship at ROW " + rowOption + ", COLUMN " + columnOption + "! Please input another option (click OK)!");
						firstCheck = false; //Ask the user to input again.
					} else {
						firstCheck = true;
						break;
					}
				}
			}	
			
			userGameBoard = changeGameboardUser(rowOption, columnOption); //Method to change the grid of the user.
	
			int option = JOptionPane.showOptionDialog(null, "Would you like to go horizontal or vertical?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, horizontalVerticalOptions, horizontalVerticalOptions[0]);
			
			while (finalCHECKDONE == false) { //While loop where the final check is not true (there are 4 checks to see if the row/column 
											  //is not occupied by a ship with the amount of spaces of that ship (firstCHECK, secondCHECK, etc.).
											  //The CHECKS are all true by default.
				if (option == 1) { //Horizontal
					//Depending on the conditions, each if statement may be met to find all possible ways to input the row without any
					//restrictions. For example:
					//	  1 2 3 4 5 6 7 8    
					//	A                      
					//	B           X            
					//	C           X         
					//	D           X      
					//	E           X      
					//	F           X        
					//	G           -       
					//	H	  X X X X			
					//If a ship wants to be placed at G8 vertically, it can not go up as an X is present. It can not go 
					//down as it will go beyond row H. The only possible option is to go horizontal left. This is repetitive
					//for ships 4, 3, 2 and 1.
					
					if (columnOption > 3 ) { //If column is greater than 3, there is a possibility of subtracting instead of adding spaces.
						for (int i = 1; i < 4; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption][columnOption - i] == " X ") {
								firstCHECK = false; //First check has failed.
							} 
						}
														
						if (firstCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 4; i++) {
								userGameBoard = changeGameboardUser(rowOption, columnOption - i);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 0; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X at row " + inputRow + ". \n \n" + userGameBoard);
						}
					}
				
					if (columnOption < 6 && finalCHECKDONE != true) { //If column is less than 6, there is a possibility of adding instead of subtracting spaces.
						for (int i = 1; i < 4; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption][columnOption + i] == " X ") {
								secondCHECK = false; //Second check has failed.
							} 
						}
							
						if (secondCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 4; i++) {
								userGameBoard = changeGameboardUser(rowOption, columnOption + i);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 0; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X at row " + inputRow + ". \n \n" + userGameBoard);
						}
					}
				}
								
				if (option == 0) { //Vertical
					//Depending on the conditions, each if statement may be met to find all possible ways to input the row without any
					//restrictions. For example:
					//  1 2 3 4 5 6 7 8          1 2 3 4 5 6 7 8
					//A             X          A
					//B             X          B
					//C             X          C
					//D X X X X X - X -   OR   D X X X X X - X -
					//E                        E			 X
					//F                        F			 X
					//G                        G			 X
					//H						   H
					//If a ship wants to be placed at D7 horizontally, it can not go to the left as an X is present. It can not go to the
					//right as it will go beyond columns 8. The only possible options are to go vertical, up or down. This is repetitive
					//for ships 4, 3, 2 and 1.
					
					if (rowOption > 3 ) { //If column is greater than 3, there is a possibility of subtracting instead of adding spaces.
						for (int i = 1; i < 4; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption - i][columnOption] == " X ") {
								thirdCHECK = false; //Third check has failed.
							} 
						}
														
						if (thirdCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 4; i++) {
								userGameBoard = changeGameboardUser(rowOption - i, columnOption);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 1; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X at column " + columnOption + ". \n \n" + userGameBoard);
						}
					}
				
					if (rowOption < 6 && finalCHECKDONE != true) { //If column is less than 6, there is a possibility of adding instead of subtracting spaces.
						for (int i = 1; i < 4; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption + i][columnOption] == " X ") {
								fourthCHECK = false; //Fourth check has failed.
							} 
						}
							
						if (fourthCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 4; i++) {
								userGameBoard = changeGameboardUser(rowOption + i, columnOption);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 1; //Go from option 0 (vertical) to 1 (horizontal).
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X at column " + columnOption + ". \n \n" + userGameBoard);
						}
					}
				}
			}
			
			if (finalCHECKDONE == true) { //Once the ship has been placed, it will move onto the next set of ships.
				ships = 3; //Move to destroyer.
			}
			
		}
		
		while (ships == 3) { //Destroyer //While loop where the user must pick coordinates for this ship. All checks must be completed 
			   							 //before moving to the next ship.
			//Copied from ships == 4, with changes to for loops when adding ships to grid.
			//Same variables as ships == 4 & 5.
			String inputRow = "";
			int rowOption = 0;
			int columnOption = 0;
			//Variables below are used to track the checks before changing the grid to the user's selection. 
			boolean firstCheck = false;
			boolean firstCHECK = true;
			boolean secondCHECK = true;
			boolean thirdCHECK = true;
			boolean fourthCHECK = true;
			boolean finalCHECKDONE = false;
			
			//This first check is to see if the user inputs coordinates where an X is placed, or if coordinates are not within the 
			//correct coordinates.
			while (firstCheck == false) {
				inputRow = JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the row to add your DESTROYER!");
				inputRow.toUpperCase();
				rowOption = ((int)inputRow.charAt(0))-64;
				columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "\n You've selected row " + inputRow 
																			+ "! \n Please input the COLUMN to add your DESTROYER"));
				firstCheck = invalidInput(rowOption, columnOption); //Method to returns a boolean, checking if the input is between letters 
																	//A to H and numbers 1 to 8.
				
				while (firstCheck == true) { //While loop to check if the current selection has an X.
					if (gridUser[rowOption][columnOption] == " X ") {
						JOptionPane.showMessageDialog(null, userGameBoard + "\n There is already a ship at ROW " + rowOption + ", COLUMN " + columnOption + "! Please input another option (click OK)!");
						firstCheck = false; //Ask the user to input again.
					} else {
						firstCheck = true;
						break;
					}
				}
			}	
			
			userGameBoard = changeGameboardUser(rowOption, columnOption); //Method to change the grid of the user.
	
			int option = JOptionPane.showOptionDialog(null, "Would you like to go horizontal or vertical?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, horizontalVerticalOptions, horizontalVerticalOptions[0]);
			
			while (finalCHECKDONE == false) { //While loop where the final check is not true (there are 4 checks to see if the row/column 
											  //is not occupied by a ship with the amount of spaces of that ship (firstCHECK, secondCHECK, etc.).
											  //The CHECKS are all true by default.
				if (option == 1) { //Horizontal
					if (columnOption > 2 ) { //If column is greater than 3, there is a possibility of subtracting instead of adding spaces.
						for (int i = 1; i < 3; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption][columnOption - i] == " X ") {
								firstCHECK = false; //First check has failed.
							} else {
							}
						}
														
						if (firstCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 3; i++) {
								userGameBoard = changeGameboardUser(rowOption, columnOption - i);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 0; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X at row " + inputRow + ". \n \n" + userGameBoard);
						}
					}
				
					if (columnOption < 7 && finalCHECKDONE != true) { //If column is less than 6, there is a possibility of adding instead of subtracting spaces.
						for (int i = 1; i < 3; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption][columnOption + i] == " X ") {
								secondCHECK = false; //Second check has failed.
							} 
						}
							
						if (secondCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 3; i++) {
								userGameBoard = changeGameboardUser(rowOption, columnOption + i);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 0; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X at row " + inputRow + ". \n \n" + userGameBoard);
						}
					}
				}
								
				if (option == 0) { //Vertical
					if (rowOption > 2 ) { //If column is greater than 3, there is a possibility of subtracting instead of adding spaces.
						for (int i = 1; i < 3; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption - i][columnOption] == " X ") {
								thirdCHECK = false; //Third check has failed.
							} 
						}
														
						if (thirdCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 3; i++) {
								userGameBoard = changeGameboardUser(rowOption - i, columnOption);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 1; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X at column " + columnOption + ". \n \n" + userGameBoard);
						}
					}
				
					if (rowOption < 7 && finalCHECKDONE != true) { //If column is less than 6, there is a possibility of adding instead of subtracting spaces.
						for (int i = 1; i < 3; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption + i][columnOption] == " X ") {
								fourthCHECK = false; //Fourth check has failed.
							} 
						}
							
						if (fourthCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 3; i++) {
								userGameBoard = changeGameboardUser(rowOption + i, columnOption);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 1; //Go from option 0 (vertical) to 1 (horizontal).
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X at column " + columnOption + ". \n \n" + userGameBoard);
						}
					}
				}
			}
			
			if (finalCHECKDONE == true) { //Once the ship has been placed, it will move onto the next set of ships.
				ships = 2; //Move to submarine.
			}
			
		}
		
		while (ships == 2) { //Submarine //While loop where the user must pick coordinates for this ship. All checks must be completed 
			   							 //before moving to the next ship.
			//Copied from ships == 3 & 4, with changes to for loops when adding ships to grid.
			//Same variables as ships == 3, 4 & 5.
			String inputRow = "";
			int rowOption = 0;
			int columnOption = 0;
			//Variables below are used to track the checks before changing the grid to the user's selection. 
			boolean firstCheck = false;
			boolean firstCHECK = true;
			boolean secondCHECK = true;
			boolean thirdCHECK = true;
			boolean fourthCHECK = true;
			boolean finalCHECKDONE = false;
			
			//This first check is to see if the user inputs coordinates where an X is placed, or if coordinates are not within the 
			//correct coordinates.
			while (firstCheck == false) {
				inputRow = JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the row to add your SUBMARINE!");
				inputRow.toUpperCase();
				rowOption = ((int)inputRow.charAt(0))-64;
				columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "\n You've selected row " + inputRow 
																			+ "! \n Please input the COLUMN to add your SUBMARINE"));
				firstCheck = invalidInput(rowOption, columnOption); //Method to returns a boolean, checking if the input is between letters 
																	//A to H and numbers 1 to 8.
				
				while (firstCheck == true) { //While loop to check if the current selection has an X.
					if (gridUser[rowOption][columnOption] == " X ") {
						JOptionPane.showMessageDialog(null, userGameBoard + "\n There is already a ship at ROW " + rowOption + ", COLUMN " + columnOption + "! Please input another option (click OK)!");
						firstCheck = false; //Ask the user to input again.
					} else {
						firstCheck = true;
						break;
					}
				}
			}	
			
			userGameBoard = changeGameboardUser(rowOption, columnOption); //Method to change the grid of the user.
	
			int option = JOptionPane.showOptionDialog(null, "Would you like to go horizontal or vertical?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, horizontalVerticalOptions, horizontalVerticalOptions[0]);
			
			while (finalCHECKDONE == false) { //While loop where the final check is not true (there are 4 checks to see if the row/column 
											  //is not occupied by a ship with the amount of spaces of that ship (firstCHECK, secondCHECK, etc.).
											  //The CHECKS are all true by default.
				if (option == 1) { //Horizontal
					if (columnOption > 2 ) { //If column is greater than 3, there is a possibility of subtracting instead of adding spaces.
						for (int i = 1; i < 3; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption][columnOption - i] == " X ") {
								firstCHECK = false; //First check has failed.
							} else {
							}
						}
														
						if (firstCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 3; i++) {
								userGameBoard = changeGameboardUser(rowOption, columnOption - i);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 0; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X at row " + inputRow + ". \n \n" + userGameBoard);
						}
					}
				
					if (columnOption < 7 && finalCHECKDONE != true) { //If column is less than 6, there is a possibility of adding instead of subtracting spaces.
						for (int i = 1; i < 3; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption][columnOption + i] == " X ") {
								secondCHECK = false; //Second check has failed.
							}
						}
							
						if (secondCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 3; i++) {
								userGameBoard = changeGameboardUser(rowOption, columnOption + i);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 0; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X at row " + inputRow + ". \n \n" + userGameBoard);
						}
					}
				}
								
				if (option == 0) { //Vertical
					if (rowOption > 2 ) { //If column is greater than 3, there is a possibility of subtracting instead of adding spaces.
						for (int i = 1; i < 3; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption - i][columnOption] == " X ") {
								thirdCHECK = false; //Third check has failed.
							} 
						}
														
						if (thirdCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 3; i++) {
								userGameBoard = changeGameboardUser(rowOption - i, columnOption);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 1; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X at column " + columnOption + ". \n \n" + userGameBoard);
						}
					}
				
					if (rowOption < 7 && finalCHECKDONE != true) { //If column is less than 6, there is a possibility of adding instead of subtracting spaces.
						for (int i = 1; i < 3; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption + i][columnOption] == " X ") {
								fourthCHECK = false; //Fourth check has failed.
							}
						}
							
						if (fourthCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 1; i < 3; i++) {
								userGameBoard = changeGameboardUser(rowOption + i, columnOption);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 1; //Go from option 0 (vertical) to 1 (horizontal).
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X at column " + columnOption + ". \n \n" + userGameBoard);
						}
					}
				}
			}
			
			if (finalCHECKDONE == true) { //Once the ship has been placed, it will move onto the next set of ships.
				ships = 1; //Move to patrol boat.
			}
			
		}
		
		while (ships == 1) { //Patrol Boat //While loop where the user must pick coordinates for this ship. All checks must be completed 
			   							   //before finishing.
			//Copied from ships == 2, 3 & 4, with changes to for loops when adding ships to grid.
			//Same variables as ships == 2, 3, 4 & 5.
			String inputRow = "";
			int rowOption = 0;
			int columnOption = 0;
			//Variables below are used to track the checks before changing the grid to the user's selection. 
			boolean firstCheck = false;
			boolean firstCHECK = true;
			boolean secondCHECK = true;
			boolean thirdCHECK = true;
			boolean fourthCHECK = true;
			boolean finalCHECKDONE = false;
			
			//This first check is to see if the user inputs coordinates where an X is placed, or if coordinates are not within the 
			//correct coordinates.
			while (firstCheck == false) {
				inputRow = JOptionPane.showInputDialog(null, userGameBoard + "\n Please input the row to add your PATROL BOAT!");
				inputRow.toUpperCase();
				rowOption = ((int)inputRow.charAt(0))-64;
				columnOption = Integer.parseInt(JOptionPane.showInputDialog(null, userGameBoard + "\n You've selected row " + inputRow 
																			+ "! \n Please input the COLUMN to add your PATROL BOAT"));
				firstCheck = invalidInput(rowOption, columnOption); //Method to returns a boolean, checking if the input is between letters 
																	//A to H and numbers 1 to 8.
				
				while (firstCheck == true) { //While loop to check if the current selection has an X.
					if (gridUser[rowOption][columnOption] == " X ") {
						JOptionPane.showMessageDialog(null, userGameBoard + "\n There is already a ship at ROW " + rowOption + ", COLUMN " + columnOption + "! Please input another option (click OK)!");
						firstCheck = false; //Ask the user to input again.
					} else {
						firstCheck = true;
						break;
					}
				}
			}	
			
			int option = JOptionPane.showOptionDialog(null, "Would you like to go horizontal or vertical?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, horizontalVerticalOptions, horizontalVerticalOptions[0]);
			
			while (finalCHECKDONE == false) { //While loop where the final check is not true (there are 4 checks to see if the row/column 
											  //is not occupied by a ship with the amount of spaces of that ship (firstCHECK, secondCHECK, etc.).
											  //The CHECKS are all true by default.
				if (option == 1) { //Horizontal
					if (columnOption > 1 ) { //If column is greater than 3, there is a possibility of subtracting instead of adding spaces.
						for (int i = 0; i < 2; i++) { //Start at 0 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption][columnOption - i] == " X ") {
								firstCHECK = false; //First check has failed.
							} 
						}
														
						if (firstCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 0; i < 2; i++) {
								userGameBoard = changeGameboardUser(rowOption, columnOption - i);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 0; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X at row " + inputRow + ". \n \n" + userGameBoard);
						}
					}
				
					if (columnOption < 8 && finalCHECKDONE != true) { //If column is less than 6, there is a possibility of adding instead of subtracting spaces.
						for (int i = 0; i < 2; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption][columnOption + i] == " X ") {
								secondCHECK = false; //Second check has failed.
							} 
						}
							
						if (secondCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 0; i < 2; i++) {
								userGameBoard = changeGameboardUser(rowOption, columnOption + i);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 0; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to vertical due to meeting X at row " + inputRow + ". \n \n" + userGameBoard);
						}
					}
				}
								
				if (option == 0) { //Vertical
					if (rowOption > 1 ) { //If column is greater than 3, there is a possibility of subtracting instead of adding spaces.
						for (int i = 0; i < 2; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption - i][columnOption] == " X ") {
								thirdCHECK = false; //Third check has failed.
							} else {
							}
						}
														
						if (thirdCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 0; i < 2; i++) {
								userGameBoard = changeGameboardUser(rowOption - i, columnOption);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 1; //Go from option 1 (horizontal) to 0 (vertical).
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X at column " + columnOption + ". \n \n" + userGameBoard);
						}
					}
				
					if (rowOption < 8 && finalCHECKDONE != true) { //If column is less than 6, there is a possibility of adding instead of subtracting spaces.
						for (int i = 0; i < 2; i++) { //Start at 1 and end at 4 as it is adding/subtracting the amount of spaces to reach the correct amount of ship spaces.
							if (gridUser[rowOption + i][columnOption] == " X ") {
								fourthCHECK = false; //Fourth check has failed.
							} 
						}
							
						if (fourthCHECK == true) { //If there are no conflicts, ship spaces will be placed with the for loop.
							for (int i = 0; i < 2; i++) {
								userGameBoard = changeGameboardUser(rowOption + i, columnOption);
								finalCHECKDONE = true;
							}
						} else { //Else, if there are conflicts, it will switch to going vertical.
							option = 1; //Go from option 0 (vertical) to 1 (horizontal).
							JOptionPane.showMessageDialog(null, "Switching to horizontal due to meeting X at column " + columnOption + ". \n \n" + userGameBoard);
						}
					}
				}
			}
			
			if (finalCHECKDONE == true) { //Once the ship has been placed, it will move onto the next set of ships.
				ships = 0; //End placement of ships.
			}
			
		}
		
		return userGameBoard;
		
	}
	
	/**
	 * Getter method to check if the user input is past restrictions.
	 * @return boolean true/false if all checks are valid or not.
	 */
	public String computerPlaceShips() {
		//Similar to the user placing ships, the computer will go down the int ships from 5 to 1, adding the right amount of
		//spaces for each ship.
		//The computer finds a random integer. If it is above the maximum column/row the size of the ship can take, it will pick a
		//a random number that is below the restricted spaces the maximum can take going horizontal/vertical. 
		String computerGameBoard = "";
		int ships = 5;
		
		while (ships == 5) { //Carrier //While loop where the computer must randomly pick coordinates for this ship. All checks must be completed 
			 						   //before moving to the next ship.
			int rowOption = rand.nextInt(1, 9);
			int columnOption = rand.nextInt(1, 9);
			int option = rand.nextInt(2);
			if (option == 0 && columnOption >= 5) { //Horizontal and past 5.
				columnOption = rand.nextInt(1, 4); //Pick another integer between 1 and 4.
			}
			
			if (option == 1 && rowOption >= 5) { //Vertical and past 5.
				rowOption = rand.nextInt(1, 4); //Pick another integer between 1 and 4.
			}
			
			computerGameBoard = changeGameboardComputer(rowOption, columnOption); //Method to change the computer's grid coordinates as X.
							
			if (option == 0) { //Horizontal adding X's in a for loop. 
				for (int i = 1; i < 5; i++) {
					computerGameBoard = changeGameboardComputer(rowOption, columnOption + i);
				}
			}
				
			if (option == 1) { //Vertical adding X's in a for loop. 
				for (int i = 1; i < 5; i++) {
					computerGameBoard = changeGameboardComputer(rowOption + i, columnOption);
				}
			}
			
			ships = 4; //Move down to the next ship, Battleship.
		}
		
		while (ships == 4) { //Battleship //While loop where the computer must randomly pick coordinates for this ship. All checks must be completed 
							 //before moving to the next ship.
			int rowOption = 0;
			int columnOption = 0;
			int option = rand.nextInt(2);
			boolean addShip = false; //If a ship has or has not been added.
			
			while (addShip == false && option == 0) { //While loop if ship is not added and computer wants to go horizontal to 
				  									  //see if the selection meets an X within the columns.
				rowOption = rand.nextInt(1, 9);
				columnOption = rand.nextInt(1, 6);
				
				//Inspecting row if there is an X present.
				for (int i = 0; i < 4; i++) { 
					if (gridComputer[rowOption][columnOption + i] == " X ") {
						addShip = false; //addShip is false and new rows & columns are generated.
						i = 4; //Exit for loop.
					} else {
						addShip = true; //addShip is true and can continue on.
					}
				}
			}
			
			while (addShip == false && option == 1) { //While loop if ship is not added and computer wants to go vertical to 
													  //see if the selection meets an X within the rows.
				rowOption = rand.nextInt(1, 6);
				columnOption = rand.nextInt(1, 9);
				
				for (int i = 0; i < 4; i++) { //Row, Vertical
					if (gridComputer[rowOption + i][columnOption] == " X ") {
						addShip = false; //addShip is false and new rows & columns are generated.
						i = 4; //Exit for loop.
					} else {
						addShip = true; //addShip is true and can continue on.
					}	
				}
			}
			
			
			if (addShip == true) { 
				computerGameBoard = changeGameboardComputer(rowOption, columnOption);				
				if (option == 0) { //Horizontal
					for (int i = 1; i < 4; i++) { //Add ships in for loop.
						computerGameBoard = changeGameboardComputer(rowOption, columnOption + i);
					}
				}
					
				if (option == 1) { //Vertical
					for (int i = 1; i < 4; i++) { //Add ships in for loop.
						computerGameBoard = changeGameboardComputer(rowOption + i, columnOption);
					}
				}
				ships = 3;
			}
		}
		
		while (ships == 3) { //Destroyer //While loop where the computer must randomly pick coordinates for this ship. All checks must be completed 
			 							 //before moving to the next ship.
			int rowOption = 0;
			int columnOption = 0;
			int option = rand.nextInt(2);
			boolean addShip = false; //If a ship has or has not been added.
			
			while (addShip == false && option == 0) { //While loop if ship is not added and computer wants to go horizontal to 
				  									  //see if the selection meets an X within the columns.
				rowOption = rand.nextInt(1, 9);
				columnOption = rand.nextInt(1, 7);
				
				//Inspecting row if there is an X present.
				for (int i = 0; i < 3; i++) { 
					if (gridComputer[rowOption][columnOption + i] == " X ") {
						addShip = false; //addShip is false and new rows & columns are generated.
						i = 4; //Exit for loop.
					} else {
						addShip = true; //addShip is true and can continue on.
					}
				}
			}
			
			while (addShip == false && option == 1) { //While loop if ship is not added and computer wants to go vertical to 
				  									  //see if the selection meets an X within the rows.
				rowOption = rand.nextInt(1, 7);
				columnOption = rand.nextInt(1, 9);
				
				for (int i = 0; i < 3; i++) { //Row, Vertical
					if (gridComputer[rowOption + i][columnOption] == " X ") {
						addShip = false; //addShip is false and new rows & columns are generated.
						i = 4; //Exit for loop.
					} else {
						addShip = true; //addShip is true and can continue on.
					}	
				}
			}
			
			
			if (addShip == true) { 
				computerGameBoard = changeGameboardComputer(rowOption, columnOption);				
				if (option == 0) { //Horizontal
					for (int i = 1; i < 3; i++) { //Add ships in for loop.
						computerGameBoard = changeGameboardComputer(rowOption, columnOption + i);
					}
				}
					
				if (option == 1) { //Vertical
					for (int i = 1; i < 3; i++) { //Add ships in for loop.
						computerGameBoard = changeGameboardComputer(rowOption + i, columnOption);
					}
				}
				ships = 2;
			}
		}
		
		while (ships == 2) { //Submarine //While loop where the computer must randomly pick coordinates for this ship. All checks must be completed 
										 //before moving to the next ship.
			int rowOption = 0;
			int columnOption = 0;
			int option = rand.nextInt(2);
			boolean addShip = false; //If a ship has or has not been added.
			
			while (addShip == false && option == 0) { //While loop if ship is not added and computer wants to go horizontal to 
													  //see if the selection meets an X within the columns.
				rowOption = rand.nextInt(1, 9);
				columnOption = rand.nextInt(1, 7);
				
				//Inspecting row if there is an X present.
				for (int i = 0; i < 3; i++) { 
					if (gridComputer[rowOption][columnOption + i] == " X ") {
						addShip = false; //addShip is false and new rows & columns are generated.
						i = 4; //Exit for loop.
					} else {
						addShip = true; //addShip is true and can continue on.
					}
				}
			}
			
			while (addShip == false && option == 1) { //While loop if ship is not added and computer wants to go vertical to 
				  									  //see if the selection meets an X within the rows.
				rowOption = rand.nextInt(1, 7);
				columnOption = rand.nextInt(1, 9);
				
				for (int i = 0; i < 3; i++) { //Row, Vertical
					if (gridComputer[rowOption + i][columnOption] == " X ") {
						addShip = false; //addShip is false and new rows & columns are generated.
						i = 4; //Exit for loop.
					} else {
						addShip = true; //addShip is true and can continue on.
					}	
				}
			}
			
			
			if (addShip == true) { 
				computerGameBoard = changeGameboardComputer(rowOption, columnOption);				
				if (option == 0) { //Horizontal
					for (int i = 1; i < 3; i++) { //Add ships in for loop.
						computerGameBoard = changeGameboardComputer(rowOption, columnOption + i);
					}
				}
					
				if (option == 1) { //Vertical
					for (int i = 1; i < 3; i++) { //Add ships in for loop.
						computerGameBoard = changeGameboardComputer(rowOption + i, columnOption);
					}
				}
				ships = 1;
			}
		}
		
		while (ships == 1) { //Patrol Boat //While loop where the computer must randomly pick coordinates for this ship. All checks must be completed 
										   //before exiting.
			int rowOption = 0;
			int columnOption = 0;
			int option = rand.nextInt(2);
			boolean addShip = false; //If a ship has or has not been added.
			
			while (addShip == false && option == 0) { //While loop if ship is not added and computer wants to go horizontal to 
													  //see if the selection meets an X within the columns.
				rowOption = rand.nextInt(1, 9);
				columnOption = rand.nextInt(1, 8);
				
				//Inspecting row if there is an X present.
				for (int i = 0; i < 2; i++) { 
					if (gridComputer[rowOption][columnOption + i] == " X ") {
						addShip = false; //addShip is false and new rows & columns are generated.
						i = 4; //Exit for loop.
					} else {
						addShip = true; //addShip is true and can continue on.
					}
				}
			}
			
			while (addShip == false && option == 1) { //While loop if ship is not added and computer wants to go vertical to 
				  									  //see if the selection meets an X within the rows.
				rowOption = rand.nextInt(1, 8);
				columnOption = rand.nextInt(1, 9);
				
				for (int i = 0; i < 2; i++) { //Row, Vertical
					if (gridComputer[rowOption + i][columnOption] == " X ") {
						addShip = false; //addShip is false and new rows & columns are generated.
						i = 4; //Exit for loop.
					} else {
						addShip = true; //addShip is true and can continue on.
					}	
				}
			}
			
			
			if (addShip == true) { 
				if (option == 0) { //Horizontal
					for (int i = 0; i < 2; i++) { //Add ships in for loop.
						computerGameBoard = changeGameboardComputer(rowOption, columnOption + i);
					}
				}
					
				if (option == 1) { //Vertical
					for (int i = 0; i < 2; i++) { //Add ships in for loop.
						computerGameBoard = changeGameboardComputer(rowOption + i, columnOption);
					}
				}
				ships = 2;
			}
		}
		
		return computerGameBoard;
	}
	
	/**
	 * Retreives the row and column and return if input is between conditions or not.
	 * @param row Integer of the input row.
	 * @param col Integer of the input column.
	 * @return value if input is valid or not.
	 */
	public boolean invalidInput(int row, int col) {
		boolean validInput = false;
		//Do note: Grid is 8x8.
		if (row > 8) {
			JOptionPane.showMessageDialog(null, "Invalid input due to the row you selected is past letter H! Please ensure that the row you select is between letters A and H (not case sensitive");
			return validInput;
		} if (row < 1) {
			JOptionPane.showMessageDialog(null, "Invalid input due to the row you selected is not a valid letter! Please ensure that the row you select is between letters A and H (not case sensitive");
			return validInput;
		} if (col > 8) {
			JOptionPane.showMessageDialog(null, "Invalid input due to the column you selected is past number 8! Please ensure that the column you select is between numbers 1 and 8!");
			return validInput;
		} if (col < 1) {
			JOptionPane.showMessageDialog(null, "Invalid input due to the column you selected is past number 8! Please ensure that the column you select is between numbers 1 and 8!");
			return validInput;
		} else {
			validInput = true;
		}
		return validInput;
	}
	
	/**
	 * Retrieves an empty grid of the game. 
	 * @return built string of empty grid.
	 */
	public String printGameboard() {
		//Arrays to simulate a grid.
		String [] row1 = {"   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", " 8 "};
		String [] row2 = {" A ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row3 = {" B ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row4 = {" C ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row5 = {" D ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row6 = {" E ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row7 = {" F ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row8 = {" G ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		String [] row9 = {" H ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - "};
		
		//Replace [, ] and , to empty strings for the output to look nicer.
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
		
		return stringBoard;
	
	}
	
	/**
	 * Updates the gameboard of the user to X. NOTE: This is for building ships only.
	 * @param r The integer of the row.
	 * @param c The integer of the column
	 * @return build string of the user's grid.
	 */
	public String changeGameboardUser(int r, int c) {
		int row = r;
		int column = c;
		
		gridUser[row][column] = " X "; //Change the grid's coordinates to the ship symbol.
		
		//Replace [, ] and , to empty strings for the output to look nicer.
		String stringRow1 = (Arrays.toString(row1User).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow2 = (Arrays.toString(row2User).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow3 = (Arrays.toString(row3User).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow4 = (Arrays.toString(row4User).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow5 = (Arrays.toString(row5User).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow6 = (Arrays.toString(row6User).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow7 = (Arrays.toString(row7User).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow8 = (Arrays.toString(row8User).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow9 = (Arrays.toString(row9User).replace("[", "").replace("]", "").replace(",", ""));
		String stringBoardUser = stringRow1 + "\n" + stringRow2 + "\n" + stringRow3 + "\n" + stringRow4 + "\n" + stringRow5 + "\n" + stringRow6 + "\n" +stringRow7 + "\n" +stringRow8 + "\n" +stringRow9 + "\n";				
		
		return stringBoardUser;
	}
	
	/**
	 * Updates the gameboard of the computer to X. NOTE: This is for building ships only.
	 * @param r The integer of the row.
	 * @param c The integer of the column
	 * @return built string of the computer's grid.
	 */
	public String changeGameboardComputer(int r, int c) {
		int row = r;
		int column = c;
		
		gridComputer[row][column] = " X ";
		
		//Replace [, ] and , to empty strings for the output to look nicer.
		String stringRow1 = (Arrays.toString(row1Computer).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow2 = (Arrays.toString(row2Computer).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow3 = (Arrays.toString(row3Computer).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow4 = (Arrays.toString(row4Computer).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow5 = (Arrays.toString(row5Computer).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow6 = (Arrays.toString(row6Computer).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow7 = (Arrays.toString(row7Computer).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow8 = (Arrays.toString(row8Computer).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow9 = (Arrays.toString(row9Computer).replace("[", "").replace("]", "").replace(",", ""));
		String stringBoardComputer = stringRow1 + "\n" + stringRow2 + "\n" + stringRow3 + "\n" + stringRow4 + "\n" + stringRow5 + "\n" + stringRow6 + "\n" +stringRow7 + "\n" +stringRow8 + "\n" +stringRow9 + "\n";				
		
		return stringBoardComputer;
	}
	
	/**
	 * Updates the empty gameboard of the user to X or / from their guesses. NOTE: This is for guessing ships only.
	 * @param r The integer of the row.
	 * @param c The integer of the column
	 * @return built string of the user's grid.
	 */
	public String changeGameboardUserEmpty(int r, int c) {
		int row = r;
		int column = c;
				
		if (gridComputer[row][column] == " X ") { //If a ship is present.
			gridUserEmpty[row][column] = " X "; //Change grid to X, showing that a ship has been hit.
		} else { //If it hits water.
			gridUserEmpty[row][column] = " / ";  //Change grid to /, showing that water has been hit.
		}
				
		//Replace [, ] and , to empty strings for the output to look nicer.
		String stringRow1 = (Arrays.toString(row1UserEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow2 = (Arrays.toString(row2UserEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow3 = (Arrays.toString(row3UserEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow4 = (Arrays.toString(row4UserEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow5 = (Arrays.toString(row5UserEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow6 = (Arrays.toString(row6UserEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow7 = (Arrays.toString(row7UserEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow8 = (Arrays.toString(row8UserEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow9 = (Arrays.toString(row9UserEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringBoardUser = stringRow1 + "\n" + stringRow2 + "\n" + stringRow3 + "\n" + stringRow4 + "\n" + stringRow5 + "\n" + stringRow6 + "\n" +stringRow7 + "\n" +stringRow8 + "\n" +stringRow9 + "\n";				
		
		if (gridComputer[row][column] == " X ") {
			JOptionPane.showMessageDialog(null, stringBoardUser + "\n Hit!");
			numberOfUserHits++;
			System.out.println("Number of user hits: " + numberOfUserHits);
		} else {
			JOptionPane.showMessageDialog(null, stringBoardUser + "\n No hit!");
		}
		
		return stringBoardUser;
	}
	
	/**
	 * Updates the empty gameboard of the computer to X or / from their guesses. NOTE: This is for guessing ships only.
	 * @param r The integer of the row.
	 * @param c The integer of the column
	 * @return built string of the computer's grid.
	 */
	public String changeGameboardComputerEmpty(int r, int c) {
		int row = r;
		int column = c;
		boolean boxFilledIn = false;
				
		while (boxFilledIn == false) {
			if (gridUser[row][column] == " X ") { //If a ship is present in the USER'S grid.
				if (gridComputerEmpty[row][column] != " X ") { //Compares to the computer's grid if that spot has guessed a ship already.
					gridComputerEmpty[row][column] = " X ";
					boxFilledIn = true;
					break;
				} else { //If the coordinate is already guessed.
					row = rand.nextInt(1, 9); //Regenerate row.
					column = rand.nextInt(1, 9); //Regenerate column.
				}
			} if (gridComputerEmpty[row][column] == " / ") { //Compares to the computer's grid if that spot has guessed but missed already.
				row = rand.nextInt(1, 9); //Regenerate row.
				column = rand.nextInt(1, 9); //Regenerate column.
			} else { //If the user hit water. 
				gridComputerEmpty[row][column] = " / ";
				boxFilledIn = true;
				break;
			}
		}
				
		//Replace [, ] and , to empty strings for the output to look nicer.
		String stringRow1 = (Arrays.toString(row1ComputerEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow2 = (Arrays.toString(row2ComputerEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow3 = (Arrays.toString(row3ComputerEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow4 = (Arrays.toString(row4ComputerEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow5 = (Arrays.toString(row5ComputerEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow6 = (Arrays.toString(row6ComputerEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow7 = (Arrays.toString(row7ComputerEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow8 = (Arrays.toString(row8ComputerEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringRow9 = (Arrays.toString(row9ComputerEmpty).replace("[", "").replace("]", "").replace(",", ""));
		String stringBoardComputer = stringRow1 + "\n" + stringRow2 + "\n" + stringRow3 + "\n" + stringRow4 + "\n" + stringRow5 + "\n" + stringRow6 + "\n" +stringRow7 + "\n" +stringRow8 + "\n" +stringRow9 + "\n";				
		
		if (gridUser[row][column] == " X ") {
			JOptionPane.showMessageDialog(null, stringBoardComputer + "\n The computer has gotten a hit!");
			numberOfComputerHits++;
			System.out.println("Number of computer hits: " + numberOfComputerHits);
		} else {
			JOptionPane.showMessageDialog(null, stringBoardComputer + "\n The computer did not get a hit!");
		}
		
		return stringBoardComputer;
	}
	
}

