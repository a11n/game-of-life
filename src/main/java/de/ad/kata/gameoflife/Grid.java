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
    if (x < 0 || y < 0 || x >= size() || y >= size()) {
      throw new IllegalArgumentException(
          String.format("Coordinates (%d, %d) out of grid bounds (%d, %d)", x, y, size(), size()));
    }

    return grid[x][y];
  }

  public int size() {
    return grid.length;
  }

  public int countLivingNeighbors(int x, int y) {
    int livingNeighborsCount = 0;

    for (int i = x - 1; i < x + 1; i++) {
      for (int j = y - 1; j < y + 1; j++) {
        try {
          Cell cell = cellAt(i,j);
          if(cell.isAlive)
            livingNeighborsCount++;
        } catch (IllegalArgumentException e){
          //Cells outside of the grid are considered as dead.
        }
      }
    }

    return livingNeighborsCount;
  }

  public static class Cell {
    private boolean isAlive;

    private Cell(boolean isAlive) {
      this.isAlive = isAlive;
    }

    public static Cell createLivingCell() {
      return new Cell(true);
    }

    public static Cell createDeadCell() {
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

    public void die() {
      isAlive = false;
    }
  }
}
