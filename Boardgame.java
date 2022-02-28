

public class Boardgame {
	private Cell[] cell = new Cell[101];
	private final int MIN=1;
	private final int MAX=97;
	//biscuit1 and biscuit2 are the positions of the first and second biscuit on the board
	private int biscuit1, biscuit2;
	//biscuit1 and biscuit2 are the positions of the first and second stick on the board
	private int stick1, stick2;
	
	
	public Boardgame() {
		for(int i=0; i<=99; i++) {
				cell[i]=new Cell(i+1);
		}//end for i
		
		//generate four random number between 1 and 97
		 biscuit1 = (int)Math.floor(Math.random()*(MAX-MIN+1)+MIN);
		//System.out.println("position of first biscuit: "+(biscuit1+1));
		 biscuit2 = (int)Math.floor(Math.random()*(MAX-MIN+1)+MIN);
		//System.out.println("position of second biscuit: "+(biscuit2+1));
		 stick1 = (int)Math.floor(Math.random()*(89-5+1)+5);
		//System.out.println("position of first stick: "+(stick1+1));
		 stick2 = (int)Math.floor(Math.random()*(89-5+1)+5);
		//System.out.println("position of second stick: "+(stick2+1));
		
		//set 2 biscuits on the board
		cell[biscuit1].setBiscuit();
		cell[biscuit2].setBiscuit();
		
		//set 2 sticks on the board
		cell[stick1].setStick();
		cell[stick2].setStick();
	}//Boardgame Constructor
	
	public void printBoardgame() {
		for(int i=0; i<=99; i++) {
			
			System.out.print("Cell number "+ (i+1)+ " status: ");
			cell[i].printCell();
		
	}//for i
	}//end printBoardgame()
	public void printBoard() {
		int counter=1;
		for(int i=99; i>=0; i--) {
			cell[i].printCellNumber();
			counter++;	
			if(counter>10) {	
				System.out.println("\n__________________________________________________________________________________________________________________________________");

				counter=1;
				for(int j=i-10; j<=i-1;j++) {
					cell[j].printCellNumber();
				}
				i=i-10;
				System.out.println("\n__________________________________________________________________________________________________________________________________");
			}
				
			
		}//for i
	}//printBoard()
	
	//Initialise Snakes and Ladders
	public void setSnakesLadders() {
		cell[98].setStatus(" HOS, go to square 79 ", 78);
		cell[9].setStatus(" BOL, go to square 37 ", 36);
	}//end 

	//This method can move the player on the board according to its current position and the number on the dice he rolled
	public void move(Player player, int diceNumber) {
		//Check if the player is moving to a position over the 100th square
		if(player.getCurrentPosition()+diceNumber<=99) {
			player.setPreviousPosition(player.getCurrentPosition());
			player.setPosition(player.getCurrentPosition()+diceNumber);
			
			
			//If the player lands on a ladder
			if(player.getCurrentPosition()==9) {
				player.setPosition(cell[9].getGoTo());
			    System.out.println(cell[9].getStatus());
			    //Check if the player has a stick and its position is below 89th then use the stick to move up 10 squares.
			    if(player.getStick()>0 && player.getCurrentPosition()<=89)
			    	player.setPosition(player.getCurrentPosition()+10);
			    	player.useStick(); //After using the stick, the player updates the number of sticks he has
			    	
			    
			}//end if the player lands on a ladder
			
			/**Check if the player lands on the head of a snake and has no biscuits.
				*The player needs to go to the tail of the snake.
				*Otherwise the player does not need go to the tail of the snake
			 */
			if(player.getCurrentPosition()==98 && player.getBiscuit()==0) {
				player.setPosition(cell[98].getGoTo());
				System.out.println(cell[98].getStatus());
			}//end if
			//If the player lands on the head of a snake and has biscuits, use one biscuit to avoid going to the tail of the snake
			else if(player.getCurrentPosition()==98 && player.getBiscuit()>0)
				player.useBiscuit();

			
		}//end if
		else
			System.out.println("Sorry, you are going out of the boardgame. Try to roll a smaller number.");
		
		
		//Check if the player has landed on one of the squares containing biscuit or stick, if so, collect them
		if(player.getCurrentPosition()==biscuit1 || player.getCurrentPosition()==biscuit2 ) {
			player.collectBiscuit();
			System.out.println("You collected a biscuit!");
			
		}
			
		if(player.getCurrentPosition()==stick1 || player.getCurrentPosition()==stick2 ) {
			player.collectStick();
			System.out.println("You collected a stick!");
			
		}
			
	}//end move
	
	//This is a get method.
	//This method returns the value of biscuit1
	public int getBiscuit1() {
		return biscuit1;
	}//end getBiscuit1
	
	//This is a get method.
	//This method returns the value of biscuit2
	public int getBiscuit2() {
		return biscuit2;
	}//end getBiscuit2
	
	//This is a get method.
	//This method returns the value of stick1
	public int getStick1() {
		return stick1;
	}//end getBiscuit1
		
	//This is a get method.
	//This method returns the value of stick2
	public int getStick2() {
		return stick2;
	}//end getBiscuit2
	
	
	
	
	
}
