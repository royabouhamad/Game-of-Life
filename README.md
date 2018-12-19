# Conway's Game of Life

Conway's Game of Life is a 'cellular automaton'. It is played on a rectangular board with square spaces. Each space is assigned a value, either alive(1) or dead(0). This program represents the first 100 states generated from a first randomly generated state. The game then follows these simple rules:
* Any live cell with 0 or 1 live neighbors becomes dead, because of underpopulation.
* Any live cell with 2 or 3 live neighbors stays alive, because its neighborhood is just right.
* Any live cell with more than 3 live neighbors becomes dead, because of overpopulation.
* Any dead cell with exactly 3 live neighbors becomes alive, by reproduction.

Installation
------------

To install the program, clone this repository and navigate to it's directory in the terminal. Then run `javac GameLogic.java`, followed by `java GameLogic` to run.

Key
----

0 - Dead
1 - Alive
