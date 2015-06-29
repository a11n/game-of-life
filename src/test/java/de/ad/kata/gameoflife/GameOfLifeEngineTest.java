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

  /**
   * Rule 3:
   * Any live cell with more than three live neighbours dies, as if by overcrowding.
   *
   * @throws Exception
   */
  @Test
  public void testThirdRule() throws Exception {
    Grid grid = initGridWithOneLivingCellAndFourLivingNeighbors();

    Grid nextGeneration = engine.computeNextGeneration(grid);

    assertTrue(nextGeneration.cellAt(1,1).isDead());
  }

  /**
   * Rule 4:
   * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
   *
   * @throws Exception
   */
  @Test
  public void testFourthRule() throws Exception {
    Grid grid = initGridWithOneDeadCellAndThreeLivingNeighbors();

    Grid nextGeneration = engine.computeNextGeneration(grid);

    assertTrue(nextGeneration.cellAt(1,1).isAlive());
  }
  
  private Grid initGridWithOneLivingCellAndOneLivingNeighbor() {
    Grid grid = new Grid(3);
    
    grid.cellAt(1,1).reproduce(); //living cell
    grid.cellAt(0,0).reproduce(); //living neighbor
    
    return grid;
  }

  private Grid initGridWithOneLivingCellAndThreeLivingNeighbors() {
    Grid grid = new Grid(3);

    grid.cellAt(1,1).reproduce(); //living cell
    grid.cellAt(0,0).reproduce(); //living neighbor
    grid.cellAt(0,2).reproduce(); //living neighbor
    grid.cellAt(2,0).reproduce(); //living neighbor

    return grid;
  }

  private Grid initGridWithOneDeadCellAndThreeLivingNeighbors() {
    Grid grid = new Grid(3);

    grid.cellAt(1,1).die(); //dead cell
    grid.cellAt(0,0).reproduce(); //living neighbor
    grid.cellAt(0,2).reproduce(); //living neighbor
    grid.cellAt(2,0).reproduce(); //living neighbor

    return grid;
  }

  private Grid initGridWithOneLivingCellAndFourLivingNeighbors() {
    Grid grid = new Grid(3);

    grid.cellAt(1,1).reproduce(); //living cell
    grid.cellAt(0,0).reproduce(); //living neighbor
    grid.cellAt(0,2).reproduce(); //living neighbor
    grid.cellAt(2,0).reproduce(); //living neighbor
    grid.cellAt(2,2).reproduce(); //living neighbor

    return grid;
  }
}
