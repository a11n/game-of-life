package de.ad.kata.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameOfLifeEngineTest {
  @Test
  public void testComputeNextGeneration() throws Exception {
    Grid grid = new Grid(16);
    Grid expected = new Grid(16);
    GameOfLifeEngine engine = new GameOfLifeEngine();
    
    engine.computeNextGeneration(grid);
    
    assertTrue(expected.equals(grid));
  }
}
