package de.ad.kata.gameoflife;

public class GameOfLifeEngine {
  public Grid computeNextGeneration(Grid currentGeneration) {
    Grid nextGeneration = new Grid(currentGeneration.size());

    for (int x = 0; x < currentGeneration.size(); x++) {
      for (int y = 0; y < currentGeneration.size(); y++) {
        Grid.Cell presentCell = currentGeneration.cellAt(x,y);
        Grid.Cell futureCell = nextGeneration.cellAt(x,y);
        
        int livingNeighborsCount = currentGeneration.countLivingNeighbors(x,y);
        
        if(livingNeighborsCount < 2)
          futureCell.die();
      }
    }
    
    return nextGeneration;
  }
}
