package de.ad.kata.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameOfLifeEngineTest {

  private GameOfLifeEngine engine;

  @Before
  public void setUp() throws Exception {
    engine = new GameOfLifeEngine();
  }

  /**
   * Rule 1:
   * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
   * 
   * @throws Exception
   */
  @Test
  public void testFirstRule() throws Exception {
    Grid grid = initGridWithOneLivingCellAndOneLivingNeighbor();
    
    Grid nextGeneration = engine.computeNextGeneration(grid);
    
    assertTrue(nextGeneration.cellAt(1,1).isDead());
  }

  /**
   * Rule 2:
   * Any live cell with two or three live neighbours lives on to the next generation.
   *
   * @throws Exception
   */
  @Test
  public void testSecondRule() throws Exception {
    Grid grid = initGridWithOneLivingCellAndThreeLivingNeighbors();

    Grid nextGeneration = engine.computeNextGeneration(grid);

    assertTrue(nextGeneration.cellAt(1, 1).isAlive());
  }

  private Grid initGridWithOneLivingCellAndOneLivingNeighbor() {
    Grid grid = new Grid(9);
    
    grid.cellAt(1,1).reproduce(); //living cell
    grid.cellAt(0,0).reproduce(); //living neighbor
    
    return grid;
  }

  private Grid initGridWithOneLivingCellAndThreeLivingNeighbors() {
    Grid grid = new Grid(9);

    grid.cellAt(1,1).reproduce(); //living cell
    grid.cellAt(0,2).reproduce(); //living neighbor
    grid.cellAt(2,0).reproduce(); //living neighbor

    return grid;
  }
}
