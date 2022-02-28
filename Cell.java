

public class Cell {
	private String status;
	private int position;
	private int goTo;
	private boolean biscuit;
	private boolean stick;
	
	public Cell(int position) {
		this.position=position;
		biscuit=false;
		stick=false;
		
	
	}//Cell Constructor


	//This method can set a tile as Snake Head or Ladder Bottom
	public void setStatus(String status, int goTo) {
		this.status=status;
		this.goTo=goTo;
	}//set_status
	
	//This is a getter which returns the status("SH", "ST", "LT", "LB") of a cell
	public String getStatus() {
		return status;
	}//get_status
	
	//This is a getter 
	public int getGoTo() {
		return goTo;
	}//get_status
	
	//This is a setter to set the value of the variable biscuit to TRUE
	public void setBiscuit() {
		biscuit=true;	
	}//setBiscuit
	
	//This is a getter to get the value of the variable biscuit
	public boolean getBiscuit() {
		return biscuit;
	}//getBiscuit
	
	
	//This is a setter to set the value of the variable stick to TRUE
	public void setStick() {
		stick=true;	
	}//setStick
	
	//This is a getter to get the value of the variable stick
	public boolean getStick() {
		return stick;
	}//getStick 
	
	//This is a setter to reset the value of the variable biscuit to FALSE
	public void resetBiscuit() {
		biscuit=false;
	}//resetBiscuit
	
	//This is a setter to reset the value of the variable stick to FALSE
	public void resetStick() {
		stick=false;
	}//resetStick
	
	//Print out the cell
	public void printCell() {
		System.out.println(status);
		System.out.println("biscuit "+biscuit);
		System.out.println("stick "+stick);
	}
	
	public void printCellNumber() {
		String str1 = String.format("|%-5s", position); 
		//System.out.print( str1);
		String str2 = String.format("|%-2s", position);
			
		if(status != null) {
			System.out.print( str2 + "  "+status+"  ");	
			if(biscuit)
				System.out.print(biscuit);	
			if(stick)
				System.out.print(stick);
		}	
		else if(!biscuit && !stick)
			System.out.print( str1+"                       ");
		else if(biscuit) 
			System.out.print( str1+" Biscuit               ");
		else if(stick)
			System.out.print( str1+" Stick                 ");
		
		
		
	}

}
