package game;

public class SnakeLadderBoard implements Board {

	private String grid[];
	private int totalGrid;
	private int start = 0;

	@Override
	public boolean insertOnBoard(int row, int column, String symbol) {
		return false;
	}

	@Override
	public void setBoard(int row, int column) {
		
		totalGrid = row*column;
		String tempGrid[] = new String [totalGrid];
		
		for (int i = 0; i < totalGrid; i++) {
			tempGrid[i] = String.valueOf(i+1);
		}
		grid = tempGrid;
		setSnakesLadders();
	}

	private void setSnakesLadders(){
		
		grid[16] = "s1";
		grid[6] = "t1";
		grid[63] = "s2";
		grid[59] = "t2";
		grid[88] = "s3";
		grid[25] = "t3";
		grid[94] = "s4";
		grid[74] = "t4";
		grid[98] = "s5";
		grid[77] = "t5";
		
		grid[13] = "l1";
		grid[3] = "f1";
		grid[30] = "l2";
		grid[8] = "f2";
		grid[37] = "l3";
		grid[19] = "f3";
		grid[83] = "l4";
		grid[27] = "f4";
		grid[58] = "l5";
		grid[39] = "f5";
		grid[80] = "l6";
		grid[62] = "f6";
		grid[66] = "l7";
		grid[50] = "f7";
		
	}
	
	@Override
	public void displayBoard() {

		for (int i = 4; i >= 0; i--) {
			goLeft((i*2)+1);
			System.out.println("\n");
			goRight(i*2);
			System.out.println("\n");
		}

	}	

	private void goLeft(int i) {
		for(int j = 9; j >= 0; j--)
			System.out.print("  "+grid[(i*10)+j]);
	}

	private void goRight(int i) {
		if(i==0){
			for(int j = 0; j <= 9; j++)
				System.out.print("  "+grid[(i*10)+j]+" ");
		}
		else{
			for(int j = 0; j <= 9; j++)
				System.out.print("  "+grid[(i*10)+j]);
		}
	}

	@Override
	public boolean validMove(int row, int column) {
		return false;
	}

	@Override
	public String[] getGrid() {
		return grid;
	}

	@Override
	public String[][] getBoard() {
		return null;
	}

	@Override
	public void updateBoard(int value, String symbol) {
		int count = 0;
		
		for(int i=0;i<totalGrid;i++){
			if(grid[i].contains(symbol) && (i+value)<totalGrid){
				
				grid[i] = grid[i].replaceAll(","+symbol, "");
				
				if(checkSnake(i+value,symbol)){
					System.out.println("You landed on a snake....");
					count++;
					break;
				}
				else if(checkLadder(i+value,symbol)){
					System.out.println("You landed on a ladder....");
					count++;
					break;
				}
				
				else{
						grid[i+value] = grid[i+value]+","+symbol;
						count ++ ;
						break;
					}
				}
			
			else if(grid[i].contains(symbol) && (i+value)>=totalGrid){
				count++;
			}
		}
		
		if(count==0){
			if(checkLadder(start+value-1,symbol)){
				System.out.println("You landed on a ladder....");
			}
			else{	
				grid[start+value-1] = grid[start+value-1]+","+symbol;
			}
		}
	}	
	
	private boolean checkSnake(int pos,String symbol){
		if(grid[pos].startsWith("s")){
			for(int i=0;i<pos;i++){
				if(grid[i].equals("t"+grid[pos].charAt(1))){
					grid[i]=grid[i]+","+symbol;
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean checkLadder(int pos,String symbol){
		if(grid[pos].startsWith("f")){
			for(int i=pos;i<totalGrid;i++){
				if(grid[i].equals("l"+grid[pos].charAt(1))){
					grid[i]=grid[i]+","+symbol;
					return true;
				}
			}
		}
		
		return false;
	}
	
}
