<div align="center">
  <img src="https://github.com/stylextv/azul/raw/main/assets/logo.png" width="120" height="120">
  
  # Azul
</div>

## Overview

Azul is a small program designed to solve the somewhat famous [Kitty Solitaire](https://layton.fandom.com/wiki/Puzzle:Kitty_Solitaire) puzzle known from the [Professor Layton](https://layton.fandom.com/wiki/Professor_Layton_Wiki) series.
The game is played on an `n x m` board consisting of cells arranged in a grid, which are either `empty`, `blocked`, `occupied by a normal piece` or `by a king piece`. Each turn, a piece is chosen to jump over a *horizontally*, *vertically* or *diagonally* adjacent piece and land on an empty square. King pieces **cannot** be jumped over. The game is won when only one piece is left, and lost when no more moves are possible but several pieces are left.
Note that a board with two or more kings is impossible due to the design of the rules, since none of the kings can be removed from the board.
A solvable board would, for example, look like this:
```console
B . . . B
. O O O .
. O K O .
. O O O .
B . . . B
```

## Commands

A table with all commands is given below.
Note that the `solve` command requires an argument that represents the board as a series of rows of cells separated by slashes (e.g. `B...B/.OOO./.OKO./.OOO./B...B`).

| Command | Arguments   | Description                                                         |
|---------|-------------|---------------------------------------------------------------------|
| print   | -           | Prints the board setup                                              |
| setup   | `<board>`   | Sets up the board                                                   |
| solve   | -           | Attempts to solve the board and, if successful, prints the solution |
| stop    | -           | Exits the program                                                   |

## Example dialogue

Below you will find an example on how to interact with the program.

```console
Azul v1.0.0 by StylexTV
> setup B...B/.OOO./.OKO./.OOO./B...B
Position set-up.
> print
B . . . B
. O O O .
. O K O .
. O O O .
B . . . B

> solve
B . K . B
. . . . .
. . . . .
. . . . .
B . . . B

14, NORTH_WEST
B . . . B
. . . O .
. . . . K
. . . . .
B . . . B

12, EAST
B . . . B
. . . O .
. . K O .
. . . . .
B . . . B

21, NORTH_EAST
B . . . B
. . . O .
. . K . .
. . O . .
B O . . B

5, SOUTH_EAST
B . . . B
O . . O .
. O K . .
. . . . .
B O . . B

23, NORTH_WEST
B . . . B
O . . O .
. . K . .
. . O . .
B O . O B

13, SOUTH
B . . . B
O . . O .
. . K O .
. . O O .
B O . . B

11, SOUTH
B . . . B
O . . O .
. O K O .
. O O O .
B . . . B

7, WEST
Position solved.
```
