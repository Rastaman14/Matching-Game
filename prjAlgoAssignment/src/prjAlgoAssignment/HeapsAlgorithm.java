/**
 * 
 */
package prjAlgoAssignment;
import java.util.*;
import java.io.*;
/**
 * @author 072619133
 *
 */
public class HeapsAlgorithm {

	/**
	 * @param args
	 */
	public static int userChoice;
	// Function below lets the user choose what difficulty they want to play
	public static int menu(String user, Scanner scan)
	{
		boolean check = false;
		while (check== false)
		{
			do
			{
			System.out.println("What diffculty would you like to play?");
			System.out.println("1-->Easy");
			System.out.println("2-->Hard");
			user=scan.nextLine();
			}while(user.length()!=1||user.length()>1);
			userChoice = Integer.parseInt(user);
			if (userChoice<3 && userChoice>0)
			{
				check = true;
			}
			else
			{
				System.out.println("Enter option again");
			}
		}
		return userChoice;
	}
	//The function below is Heaps permutation where it randomizes the values
	public static void heapsPer(String[] array, int x)
	{
		String temp = ""; 
		
		//If the array length = 1, then return the function
		if (x==1)
		{
			return;
		}
		else
		{
			
			for (int i = 0; i<(x-1);i++)
			{
				//If the remainder =0, meaning 
				//if it's an even value then swap
				if (x%2==0)
				{
					temp = array[0];
					array[0] = array[x-1];
					array[x-1] = temp;
					
				}
				//meaning it's a odd value, it swaps
				else
				{
					temp = array[i];
					array[i] = array[x-1];
					array[x-1] = temp;
				}
			}
			// Recall function shorting the array length
			heapsPer(array, x-1);
		}
		
	}
	//This function below checks to see if the users coordinates were inputted before
	public static boolean validCords(int userX, int userY, String [][]board, String []cards)
	{
		boolean check = false;
		for (int i = 0; i<cards.length; i++)
		{
			if (board[userY][userX].equals(cards[i]))
			{
				check = true;
				break;
			}
			else
			{
				check = false;
			}
						
		}
		if (check == true)
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	//This is function is the main function for the board game
	public static void boardGame(int j, String [] user1, Scanner scan, int userX, int userY, String[][] board, String[] cards, String[] block)
	{
		String [] num;
		String user;
		//if user choose easy level
		if (userChoice==1)
		{
			//While loop makes sure user only inputs two coordinates 
			//and store the values of the coordinate in a block array
			while(j<2)
			{
				
				boolean finalCheck = false;
				int k =0;
				while(finalCheck==false)
				{
					boolean check1 = false;
					
					while(check1==false)
					{	
						do
						{
						if (j==0)
						{
						System.out.println("Enter " + (j+1) +"st "+ "coordinates (X/Y): ");
						}
						else
						{
							System.out.println("Enter " + (j+1) +"nd "+ "coordinates (X/Y): ");
						}
						
						user=scan.nextLine();

						}while((user.length()!=3||user.length()>=3) && !user.contains("/"));
						num = user.split("/");
						userX = Integer.parseInt(num[0]);
						userY = Integer.parseInt(num[1]);
						if (userX<2 && userX>=0 && userY<2 && userY>=0 )
						{					
							check1 = true;
						}
						else
						{
							System.out.println("Your coordinates is out of range.");
							check1 = false;
						}
					}

					
					if (validCords(userX,userY,board,cards)==true)					
					{
						System.out.println("You have already entered this coordinate. Try again");
						finalCheck = false;
					}
					else
					{
						finalCheck = true;
					}
					
					
				}
				
				for (int y = 0; y<board.length; y++)
				{
					if (y==0)
					{
						System.out.println("     0    1");
					}
					System.out.println("  +----+----+");
					System.out.print( y + " ");
					for (int x=0; x<board.length;x++)
					{	
						if (board[y][x].equals(cards[k]))
						{
							System.out.print("| " +board[y][x] + " ");
						}
						else
						{
							// if users coordinates equals the for loops coordinates
							//then board[y][x] new value is whatever position cards[k] holds.
							if  (x == userX && y == userY)
							{
								if (board[y][x] == "()")
								{
									board[y][x] = cards[k];
									block[j] = board[y][x];
									System.out.print("| " +board[y][x] + " ");
								}
							}
							else
							{
								board[y][x]="()";
								System.out.print("| " +board[y][x] + " ");
							}
							
						}
						
						
						
						k++;
						
					}			
					System.out.print("|");
					System.out.println("");				
				}			
				System.out.println("  +----+----+");
			
				j++;
			}
		}// end of if statement
		else
		{
			while(j<2)
			{				
				boolean finalCheck = false;
				int k =0;
				while(finalCheck==false)
				{
					boolean check1 = false;

					while(check1==false)
					{	
						do
						{
						if (j==0)
						{
						System.out.println("Enter " + (j+1) +"st "+ "coordinates (X/Y): ");
						}
						else
						{
							System.out.println("Enter " + (j+1) +"nd "+ "coordinates (X/Y): ");
						}
						
						user=scan.nextLine();

						}while((user.length()!=3||user.length()>=3) && !user.contains("/"));
						num = user.split("/");
						userX = Integer.parseInt(num[0]);
						userY = Integer.parseInt(num[1]);
						if (userX<4 && userX>=0 && userY<4 && userY>=0 )
						{					
							check1 = true;
						}
						else
						{
							System.out.println("Your coordinates is out of range.");
							check1 = false;
						}
					}

					
					if (validCords(userX,userY,board,cards)==true)					
					{
						System.out.println("You have already entered this coordinate. Try again");
						finalCheck = false;
					}
					else
					{
						finalCheck = true;
					}
					
					
				}
				
				for (int y = 0; y<board.length; y++)
				{
					if (y==0)
					{
						System.out.println("     0     1     2     3");
					}
					System.out.println("  +-----+-----+-----+-----+");
					System.out.print( y + " ");
					for (int x=0; x<board.length;x++)
					{	
						if (board[y][x].equals(cards[k]))
						{
							System.out.print("| " +board[y][x] + "  ");
						}
						else
						{

							if  (x == userX && y == userY)
							{
								if (board[y][x] == "()")
								{
									board[y][x] = cards[k];
									block[j] = board[y][x];
									System.out.print("| " +board[y][x] + "  ");
								}
							}
							else
							{
								board[y][x]="()";
								System.out.print("| " + board[y][x] + "  ");
							}
							
						}
						
						
						
						k++;
						
					}			
					System.out.print("|");
					System.out.println("");				
				}			
				System.out.println("  +-----+-----+-----+-----+");

				j++;			
			}

		}// end of else statement
		
		
		if (block[0]==block[1])
		{
			checkBlock( 0, user1,  scan,  userX,  userY,  board,  cards,  block);
		}
		else
		{
			checkBlock( 0, user1,  scan,  userX,  userY,  board,  cards,  block);
		}
		
	}
	//This function clears the consoles screen
	// we use this so that every time the user enters new coordinates it clears previous boards 
	// to make it more challenging for user. Thus, making a better memory game
	// this only work on Cmd, not on eclipse
	public static void clearScreen(){

	    try {
	    	//Check to see if it's running on a windows machine.
	    	// if true then its uses the 'cls' command to cmd to clear the screen
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	        //If it's not true, then it will try clearing it a different way.
	    } catch (IOException | InterruptedException ex) {
	    	//if it can't clear the screen. Error code windex, cause windex is used to clean windows.
	    	System.out.println("ERROR: Code WINDEX");
	    }
	    System.out.println("");	
	}
	
	//if there is no match then brackets will be replaced where user entered their coordinates
	public static void replace(String [] block, String [][] board)
	{
		int j=0;
		if (userChoice==1)
		{
			for (int y = 0; y<board.length; y++)
			{
				if (y==0)
				{
					System.out.println("     0    1");
				}
				System.out.println("  +----+----+");
				System.out.print( y + " ");
				for (int x=0; x<board.length;x++)
				{	
					if (board[y][x].equals(block[j]))
					{
						board[y][x]="()";
						block[j]="";
						System.out.print("| " +board[y][x] + " ");					
					}
					else if (board[y][x].equals(block[j+1]))
					{
						board[y][x]="()";
						block[j+1]="";
						System.out.print("| " +board[y][x] + " ");
					}
					else
					{
						System.out.print("| " +board[y][x] + " ");						
					}
				}			
				System.out.print("|");
				System.out.println("");				
			}			
			System.out.println("  +----+----+");			
		}
		else
		{
			for (int y = 0; y<board.length; y++)
			{
				if (y==0)
				{
					System.out.println("     0     1     2     3");
				}
				System.out.println("  +-----+-----+-----+-----+");
				System.out.print( y + " ");
				for (int x=0; x<board.length;x++)
				{	
					if (board[y][x].equals(block[j]))
					{
						board[y][x]="()";
						block[j]="";
						System.out.print("| " + board[y][x] + "  ");					
					}
					else if (board[y][x].equals(block[j+1]))
					{
						board[y][x]="()";
						block[j+1]="";
						System.out.print("| " + board[y][x] + "  ");
					}
					else
					{
						System.out.print("| " + board[y][x] + "  ");						
					}
				}			
				System.out.print("|");
				System.out.println("");				
			}			
			System.out.println("  +-----+-----+-----+-----+");		
		}
	
		
	}
	//After the user gets a match this will show board and the new values in the grid
	public static void keep(String [] block, String [][] board)
	{		
			int j =0;
			if (userChoice==1)
			{
				for (int y = 0; y<board.length; y++)
				{
					if (y==0)
					{
						System.out.println("     0    1");
					}
					System.out.println("  +----+----+");
					System.out.print( y + " ");
					for (int x=0; x<board.length;x++)
					{	
						if (board[y][x].equals(block[j]))
						{
							System.out.print("| " +board[y][x] + " ");					
						}
						else if (board[y][x].equals(block[j+1]))
						{
							System.out.print("| " +board[y][x] + " ");
						}
						else
						{
							System.out.print("| " +board[y][x] + " ");						
						}
					}			
					System.out.print("|");
					System.out.println("");				
				}			
				System.out.println("  +----+----+");			
			}
			else
			{
				for (int y = 0; y<board.length; y++)
				{
					if (y==0)
					{
						System.out.println("     0     1     2     3");
					}
					System.out.println("  +-----+-----+-----+-----+");
					System.out.print( y + " ");
					for (int x=0; x<board.length;x++)
					{	
						if (board[y][x].equals(block[j]))
						{
							System.out.print("| " + board[y][x] + "  ");					
						}
						else if (board[y][x].equals(block[j+1]))
						{
							System.out.print("| " + board[y][x] + "  ");
						}
						else
						{
							System.out.print("| " + board[y][x] + "  ");						
						}
					}			
					System.out.print("|");
					System.out.println("");				
				}			
				System.out.println("  +-----+-----+-----+-----+");		
			}
			
			
	}
	
	public static void checkBlock(int j, String [] user1, Scanner scan, int userX, int userY, String[][] board, String[] cards, String[] block)
	{
		while (block[0]!=block[1])
		{
			
			System.out.println("Try Again. Please wait");
			try{
				//Delay function that gives user time to see 
				//the values they inputted before its cleared out
				Thread.sleep(2000);
			}catch(InterruptedException iex){
				System.out.println(iex);	
			}
			clearScreen();
			replace(block, board);
			block[0]= "";
			block[1] ="";

			boardGame( 0,  user1,  scan,  userX,  userY,  board,  cards,  block);		
		}
		
		while (block[0]==block[1])
		{
			
			System.out.println("Good Job. Please wait");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException iex){
				System.out.println(iex);	
			}
			clearScreen();
			keep(block, board);
			block[0] = "";
			block[1] = "";
			if (gameOver(board)==true)
			{
				System.out.println("You won!!!");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException iex){
					System.out.println(iex);	
				}
				clearScreen();
				playAgain( "",  scan);
				break;
			}
			else
			{
				boardGame( 0,  user1,  scan,  userX,  userY,  board,  cards,  block);
			}
		}
	}
	//After the user gets all the matches, then user will have an option to play again or quit
	public static void playAgain(String user, Scanner scan)
	{
		boolean check = false;
		while (check== false)
		{
			System.out.println("Would you like to play again?");
			System.out.println("1-->Yes");
			System.out.println("2-->No");
			user=scan.nextLine();
			userChoice = Integer.parseInt(user);
			if (userChoice<3 && userChoice>0)
			{
				check = true;
			}
			else
			{
				System.out.println("Enter option again");
				check = false;
			}
		}
		if (userChoice == 1)
			main( new String[0]);
		else
			System.exit(0);
	}
	//This function below checks to see if any () on the board exist
	// This will determine if the game is over , or not.
	public static boolean gameOver(String [][] board)
	{
		int count = 0;
		if (userChoice==1)
		{
			for (int y = 0; y<board.length; y++)
			{
				for (int x=0; x<board.length;x++)
				{
					if (!board[y][x].equals("()"))
						count++;							
				}
							
			}
			if (count == 4)
				return true;
			else
				return false;
		}
		else
		{
			for (int y = 0; y<board.length; y++)
			{
				for (int x=0; x<board.length;x++)
				{
					if (!board[y][x].equals("()"))
						count++;							
				}
							
			}
			if (count == 16)
				return true;
			else
				return false;		
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String [] cards;
		String [][] board;
		int n ;
		int num = 0;
		int q =0;
		int j =0;
		int userX = -1 ;
		int userY = -1 ;
		String [] block = new String [2];
		String user = "";
		String brackets = "()";
		String [] user1 = new String [2];
		Random r = new Random();
		q = r.nextInt(10000)+1;

			if (menu("",scan)==1)
			{
				board = new String[2][2];
				cards = new String [] {"AA","BB","AA","BB"};
				n = cards.length;
				while(num<q)
				{
					heapsPer(cards, n);
					num++;
				}

				for (int y = 0; y<board.length; y++)
				{
					if (y==0)
					{
						System.out.println("     0    1");
					}
					System.out.println("  +----+----+");
					System.out.print( y + " ");
					for (int x=0; x<board.length;x++)
					{
						board[y][x]=brackets;
							
						
						System.out.print("| " +board[y][x] + " ");
					}
					System.out.print("|");
					System.out.println("");
					
					
				}
				System.out.println("  +----+----+");
			}
			else
			{
				cards = new String [] {"$$","%%","##","%%","##","$$","??","@@","??","&&","==","@@","&&","!!","==","!!"};
				board = new String[4][4];
				n = cards.length;
				while(num<q)
				{
					heapsPer(cards, n);
					num++;
				}

				for (int y = 0; y<board.length; y++)
				{
					if (y==0)
					{
						System.out.println("     0     1     2     3");
					}
					System.out.println("  +-----+-----+-----+-----+");
					System.out.print( y + " ");
					for (int x=0; x<board.length;x++)
					{
						board[y][x]= brackets;											
						System.out.print("| " + board[y][x] + "  ");			
					}
					System.out.print("|");
					System.out.println("");
									
				}
				System.out.println("  +-----+-----+-----+-----+");
				
			}		
			boardGame( 0,  user1,  scan,  userX,  userY,  board,  cards,  block);
					
	}

}
