

public class Player {
	private String name;
	private int currentPosition;
	private int previousPosition;
	private int diceNumber;
	private int biscuits;
	private int sticks;
	private final int MIN =1;
	private final int MAX =6;
	

	public Player() {
		currentPosition=0;
		previousPosition=0;
		biscuits=0;
		sticks=0;
	}//Player Constructor
	public Player(String name) {
		this.name=name;
		currentPosition=0;
		previousPosition=0;
		biscuits=0;
		sticks=0;
	}//Player Constructor
	//This method (getter) returns the current position of the player
	public int getCurrentPosition() {
		return currentPosition;
	}//get_current_position
	
	//This method (getter) returns the name of the player
	public String getName() {
		return name;
	}//get_name
	
	//This setter allows the player to collect a biscuit
	public void collectBiscuit() {
		biscuits++;
		System.out.println("Congratulations! You have successfully collected one biscuit!");
	}
	//Getter
	public int getBiscuit() {
		return biscuits;
	}
	
	//This method allows player to feed the biscuit to the snake
	public void useBiscuit() {
		if(biscuits>0) {
			biscuits--;
			System.out.println("You have used one biscuit.");
		}
			
	}//useBiscuit()
	
	//This method allows player to collect a stick
	public void collectStick() {
		sticks++;
		System.out.println("Congratulations! You have successfully collected one stick!");
	}//collectStick
	
	//Getter returns the number of sticks the player possesses
	public int getStick() {
		return sticks;
	}//getStick
	
	//This method allows player to use the stick to move up 10 squares
	public void useStick() {
		if(sticks>0) {
			sticks--;
			System.out.println("You have used one stick.");			
		}			
		else
			System.out.println("Sorry, you have zero stick.");
			
	}

	//This method (setter) set current position of the player
		public void setPosition(int position) {
			currentPosition=position;			
		}//set_position
		
	//This method simulates the function of a dice: generate a random number between 1 and 6.
	public void rollDice() {
		int number = (int)Math.floor(Math.random()*(MAX-MIN+1)+MIN);
		System.out.println("Dice number: "+number);
		diceNumber=number;
		//System.out.println("Current position: "+(currentPosition));
		//setPosition(number+currentPosition);
		//System.out.println("New position: "+(currentPosition));
	}//roll_dice
	
	public int getDice() {
		return diceNumber;
	}
	

	public void printPlayer() {
		System.out.println(name + " rolled a "+ diceNumber+" and moved from square "+
							(this.previousPosition+1) +" to square "+ (this.currentPosition+1));
	}//end printPlayer
	
	public void printPlayerInfo() {
		System.out.println(getName());
		
	}//end printPlayerInfo
	//getter 
	public int getPreviousPosition() {
		return previousPosition;
	}
	//setter
	public void setPreviousPosition(int previousPosition) {
		this.previousPosition = previousPosition;
	}

}
