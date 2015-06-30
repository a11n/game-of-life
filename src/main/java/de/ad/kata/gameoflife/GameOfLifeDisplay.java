package de.ad.kata.gameoflife;

import java.io.PrintStream;

public interface GameOfLifeDisplay {
  void display(Grid grid);

  class GameOfLifeConsoleDisplay implements GameOfLifeDisplay {
  
    private final PrintStream out;
  
    public GameOfLifeConsoleDisplay(PrintStream out) {
      this.out = out;
    }
  
    @Override public void display(Grid grid) {
      System.out.println();
      
      for (int x = 0; x < grid.size(); x++) {
        for (int y = 0; y < grid.size(); y++) {
          Grid.Cell cell = grid.cellAt(x,y);
          
          String output = cell.isAlive() ? "o " : ". ";
          out.print(output);
        }
        
        out.println();
      }
    }
  }
}
