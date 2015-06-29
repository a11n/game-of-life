package de.ad.kata.gameoflife;

import java.util.Arrays;

public class Grid {
  private final Cell[][] grid;

  public Grid(int size) {
    grid = new Cell[size][size];

    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++) {
        grid[x][y] = Cell.createDeadCell();
      }
    }
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Grid grid1 = (Grid) o;

    return Arrays.deepEquals(grid, grid1.grid);
  }

  @Override public int hashCode() {
    return Arrays.deepHashCode(grid);
  }

  public Cell cellAt(int x, int y) {
    return grid[x][y];
  }

  public static class Cell {
    private boolean isAlive;

    private Cell(boolean isAlive) {
      this.isAlive = isAlive;
    }

    public static Cell createLivingCell(){
      return new Cell(true);
    }
    
    public static Cell createDeadCell(){
      return new Cell(false);
    }

    public boolean isAlive() {
      return isAlive;
    }

    public boolean isDead() {
      return !isAlive;
    }

    public void reproduce() {
      isAlive = true;
    }
  }
}
