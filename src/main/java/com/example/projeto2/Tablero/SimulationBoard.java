package com.example.projeto2.Tablero;

import com.example.projeto2.Animals.Animal;

import java.util.concurrent.TimeUnit;

public class SimulationBoard extends Thread {
    private final Cell[][] board;

    private boolean finished;

    public SimulationBoard(int rows, int columns) {
        board = new Cell[rows][columns];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                board[r][c] = new Cell(c, r);
            }
        }

    }

    public Cell get(int row, int col) {
        return board[row][col];
    }

    public void run(){
        while(!finished) {
            for (Cell[] row : board) {
                for (Cell cell : row) {
                    cell.act(SimulationBoard.this);
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void moveAnimal(int x, int y, Direction direction, Animal animal) {
        int newX = direction == Direction.RIGHT ? x + 1 : (direction == Direction.LEFT ? x - 1 : x);
        int newY = direction == Direction.DOWN ? y + 1 : (direction == Direction.UP ? y - 1 : y);

        if(newX < 0 || newX >= board[0].length || newY < 0 || newY >= board.length){
            board[y][x].add(animal);
        } else {
            board[newY][newX].add(animal);
        }
    }

    public int getTotalRows() {
        return board.length;
    }

    public int getTotalColumns() {
        return board[0].length;
    }
}