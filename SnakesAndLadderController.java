
import java.util.ArrayList;
import java.util.Scanner;
public class SnakesAndLadderController{
	public static void main(String[] args) {
		play();
	}

	public static void play(){
		Boardgame snakesLadders= new Boardgame();
		snakesLadders.setSnakesLadders();
		ArrayList<Player> players= new ArrayList<Player>();
		// Creating the Scanner object
        Scanner scanner = new Scanner(System.in);
        // Use of the next() method
        System.out.println("Insert number of players: ");
        // numPlayer is the number of players
        int numPlayer = scanner.nextInt();  
        
        for (int i=1; i<=numPlayer; i++){
        	System.out.println("Insert the name of player " +i+ ": ");
            // numPlayer is the number of players
            String name = scanner.next();
        	players.add(new Player(name));
        }//end for loop
        
        //printPlayerData(players);
        snakesLadders.printBoard();
		//snakesLadders.printBoardgame();
		//int nWinners=checkNumWinner(players);
        int nWinners=0;
		while(nWinners< numPlayer-1) {
			for(int i=0;i<players.size();i++){
				System.out.println(players.get(i).getName() + ", Please type the letter r to roll the dice. ");
				char roll=scanner.next().charAt(0);
				if(roll=='r') {
					players.get(i).rollDice();
					snakesLadders.move(players.get(i), players.get(i).getDice());
					if(players.get(i).getCurrentPosition()==99) {
						nWinners++;
						System.out.println(players.get(i).getName() +" , Congratulation! You have won!");
					}
						
					players.get(i).printPlayer();
				}
					
						while(players.get(i).getDice()==6) {
							System.out.println("You rolled a number 6. You can have another turn."
									+ "Please type the letter r to roll the dice again. ");
							roll=scanner.next().charAt(0);
							if(roll=='r')
								players.get(i).rollDice();
							    snakesLadders.move(players.get(i), players.get(i).getDice());
							    if(players.get(i).getCurrentPosition()==99) {
							    	nWinners++;
							    	System.out.println(players.get(i).getName() +", Congratulations! You have won!");
							    }
							
								players.get(i).printPlayer();
								
						}//while
					
				//end if
			}
			
			
		}//end while
		scanner.close();
		
		
	}
}


	