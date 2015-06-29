package de.ad.kata.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameOfLifeEngineTest {
  /**
   * Rule 1:
   * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
   * 
   * @throws Exception
   */
  @Test
  public void testFirstRule() throws Exception {
    Grid grid = initGridWithOneLivingCellAndOneLivingNeighbor();
    GameOfLifeEngine engine = new GameOfLifeEngine();
    
    engine.computeNextGeneration(grid);
    
    assertTrue(grid.cellAt(1,1).isDead());
  }

  private Grid initGridWithOneLivingCellAndOneLivingNeighbor() {
    Grid grid = new Grid(9);
    
    grid.cellAt(1,1).reproduce(); //living cell
    grid.cellAt(0,0).reproduce(); //living neighbor
    
    return grid;
  }
}
