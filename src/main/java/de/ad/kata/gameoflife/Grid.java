package de.ad.kata.gameoflife;

import java.util.Arrays;

public class Grid {
  private final boolean [][] grid;
  
  public Grid(int size) {
    grid = new boolean[size][size];
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
}
