## PegJump
# Objective
Clear the board of pegs (X's) by jumping pegs over adjacent pegs into free spaces (O's)
#Input/Output
The topmost row starts at 0 and the increase downwards; the rightmost spot in each row starts at 0 and increases across the row.  
Specify the jumping from piece (rowIndex columnIndex) and the destination (rowIndex columnIndex).  
Press <Enter> to undo the previous move.  

## Example Gameplay
```
      O 
     X X 
    X X X 
   X X X X 
  X X X X X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 2 0 0 0
 
      X 
     O X 
    O X X 
   X X X X 
  X X X X X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 4 0 2 0
 
      X 
     O X 
    X X X 
   O X X X 
  O X X X X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 4 2 4 0
 
      X 
     O X 
    X X X 
   O X X X 
  X O O X X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 2 0 4 2
 
      X 
     O X 
    O X X 
   O O X X 
  X O X X X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 4 3 4 1
 
      X 
     O X 
    O X X 
   O O X X 
  X X O O X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 2 2 2 0
 
      X 
     O X 
    X O O 
   O O X X 
  X X O O X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 0 0 2 2
 
      O 
     O O 
    X O X 
   O O X X 
  X X O O X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 2 2 4 2
 
      O 
     O O 
    X O O 
   O O O X 
  X X X O X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 
 
      O 
     O O 
    X O X 
   O O X X 
  X X O O X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 
 
      X 
     O X 
    X O O 
   O O X X 
  X X O O X 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 4 4 2 2
 
      X 
     O X 
    X O X 
   O O X O 
  X X O O O 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 1 1 3 3
 
      X 
     O O 
    X O O 
   O O X X 
  X X O O O 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 4 0 4 2
 
      X 
     O O 
    X O O 
   O O X X 
  O O X O O 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 4 2 2 2
 
      X 
     O O 
    X O X 
   O O O X 
  O O O O O 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 3 3 1 1
 
      X 
     O X 
    X O O 
   O O O O 
  O O O O O 
 Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: 0 0 2 2
 
      O 
     O O 
    X O X 
   O O O O 
  O O O O O 
 	***GAME OVER***

Process finished with exit code 0
```
