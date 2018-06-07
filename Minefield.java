import java.util.*;

public class Minefield {

	public static void main(String[] args) {
		Random rand = new Random();
		int num = 0;
		Scanner scan = new Scanner(System.in);
		char[][] field = new char[10][10];
		boolean success = true;
		
		//Building the mine field based on random selection
		//Mines (* characters) occur 25% of the time
		//Free spaces (O characters) occur 75% of the time
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				num = rand.nextInt(100);
				
				if (num < 75)
					field[i][j] = 'O';
				else
					field[i][j] = '*';
			}
		}
		
		//Generating a random position for the goal (marked G)
		int goalX = rand.nextInt(10);
		int goalY = rand.nextInt(10);
		
		field[goalY][goalX] = 'G';
		
		
		//Generating a random position for the starting point (marked M)
		int startX = rand.nextInt(10);
		int startY = rand.nextInt(10);
		
		field[startY][startX] = 'M';
		
		
		//Printing the field at the start to the console
		System.out.println("This is the field: ");
		for (int i = 0; i < 10; i++){
			System.out.println();
			for (int j = 0; j < 10; j++)
				System.out.print(field[i][j]);
		}
		
		
		//Asking for input for the path.
		//Valid commands are U, D, L, R (for Up, Down, Left, Right respectively)
		System.out.print("\n\nInput commands to reach the goal: ");
		String path = scan.next();
		
		int pathLength = path.length();
		
		System.out.println("\n");
		Character move;
		
		
		//Tracks the movement of the player through the field.
		//If the player reaches the end or moves to a mine, movement stops.
		for (int i = 0; i < pathLength; i++){
			move = path.charAt(i);
			
			//Up
			if (move.equals('U')){
				//Handling the case of movement onto a mine
				if (field[startY-1][startX] == '*'){
					field[startY-1][startX] = 'X';
					field[startY][startX] = '|';
					System.out.println("You exploded!");
					break;
				}
				//Handling the case of movement onto the goal
				else if (field[startY-1][startX] == 'G'){
					field[startY-1][startX] = 'M';
					field[startY][startX] = '|';
					System.out.println("You reached the goal!");
					break;
				}
				
				//The general case where movement will continue after
				field[startY][startX] = '|';
				field[startY-1][startX] = 'M';
				
				startY = startY-1;
			}
			//Down
			else if (move == 'D'){
				if (field[startY+1][startX] == '*'){
					field[startY+1][startX] = 'X';
					field[startY][startX] = '|';
					System.out.println("You exploded!");
					break;
				}
				else if (field[startY+1][startX] == 'G'){
					field[startY+1][startX] = 'M';
					field[startY][startX] = '|';
					System.out.println("You reached the goal!");
					break;
				}
				
				field[startY][startX] = '|';
				field[startY+1][startX] = 'M';
				
				startY = startY+1;
			}
			//Left
			else if (move == 'L'){
				if (field[startY][startX-1] == '*'){
					field[startY][startX-1] = 'X';
					field[startY][startX] = '-';
					System.out.println("You exploded!");
					break;
				}
				else if (field[startY][startX-1] == 'G'){
					field[startY][startX-1] = 'M';
					field[startY][startX] = '-';
					System.out.println("You reached the goal!");
					break;
				}
				
				field[startY][startX] = '-';
				field[startY][startX-1] = 'M';
				
				startX = startX-1;
			}
			//Right
			else if (move == 'R'){
				if (field[startY][startX+1] == '*'){
					field[startY][startX+1] = 'X';
					field[startY][startX] = '-';
					System.out.println("You exploded!");
					break;
				}
				else if (field[startY][startX+1] == 'G'){
					field[startY][startX+1] = 'M';
					field[startY][startX] = '-';
					System.out.println("You reached the goal!");
					break;
				}
				
				field[startY][startX] = '-';
				field[startY][startX+1] = 'M';
				
				startX = startX+1;
			}
		}
		
		
		//Printing the field after movement has ended.
		//'-' indicates horizontal movement, '|' indicates vertical movement
		System.out.println("\nHere is the field and path you took: ");
		for (int i = 0; i < 10; i++){
			System.out.println();
			for (int j = 0; j < 10; j++){
				System.out.print(field[i][j]);
				
				//If the goal character still appears in the field, the player
				//did not win.
				if (field[i][j] == 'G')
					success = false;
			}
		}
		
		//Closing messages
		if (success)
			System.out.println("\n\nCongratulations! You successfully navigated the minefield!");
		else
			System.out.println("\n\nYou did not successfully navigate the minefield."
					+ "\nBetter luck next time!");
		
		scan.close();
	}

}
