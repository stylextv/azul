<div align="center">
  <img src="https://github.com/stylextv/azul/raw/main/assets/logo.png" width="120" height="120">
  
  # Azul
</div>

## Overview

Azul is a small program designed to solve the somewhat famous [Kitty Solitaire](https://layton.fandom.com/wiki/Puzzle:Kitty_Solitaire) puzzle known from the [Professor Layton](https://layton.fandom.com/wiki/Professor_Layton_Wiki) series.
The game is played on an `n x m` board consisting of cells arranged in a grid, which are either `empty`, `blocked`, `occupied by a normal piece` or `by a king piece`. Each turn, a piece is selected to jump over a *horizontally*, *vertically* or *diagonally* adjacent piece and land on an empty square. King pieces **cannot** be jumped over. The game is won when only one piece is left, and lost when no more moves are possible but several pieces are left.
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
> print
. . . . .
. O O O .
. O K O .
. O O O .
. . . . .

> solve
. . . . .
. . . . .
. . . . K
. . . . .
. . . . .

4, SOUTH
. . . . K
. . . . O
. . . . .
. . . . .
. . . . .

17, NORTH_EAST
. . . . K
. . . . .
. . . O .
. . O . .
. . . . .

5, SOUTH_EAST
. . . . K
O . . . .
. O . O .
. . . . .
. . . . .

21, NORTH
. . . . K
O . . . .
. . . O .
. O . . .
. O . . .

18, WEST
. . . . K
O . . . .
. . . O .
. . O O .
. O . . .

12, NORTH_EAST
. . . . .
O . . O .
. . K O .
. . O O .
. O . . .

11, SOUTH
. . . . .
O . . O .
. O K O .
. O O O .
. . . . .

7, WEST
Position solved.
```
