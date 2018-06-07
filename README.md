# Minefield
A simple java game where the player navigates through an ASCII minefield using console commands.

====DETAILS====

The program will build a 10x10 grid of characters " * " and "O". 
Asteriks represent mines in the field and have a 25% chance of occuring at any given space.
"O" represents a free space and has a 75% chance of occuring.
Also spawned at random locations are a goal "G" and the player character "M".

The objective is to navigate a path through the minefield from the start to the goal without moving onto a mine tile.
This is done by entering a string of characters "U", "D", "L", or "R" (representing Up, Down, Left, Right).
These characters are interpreted as consecutive movements.

After the input is given and the movement is done, the program prints out the board again, with the path taken shown.
'-' represents horizontal movement. '|' represents vertical movement.

Finally, a closing message is printed, telling the player if they succeeded or not.
