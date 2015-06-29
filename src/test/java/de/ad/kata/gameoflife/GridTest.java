package de.ad.kata.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GridTest {
  @Test
  public void testCellAt() throws Exception {
    Grid grid = new Grid(1);
    Grid.Cell cell = grid.cellAt(0,0);
    
    assertTrue(cell.isDead());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCellAtThrows() throws Exception {
    Grid grid = new Grid(1);
    
    grid.cellAt(1, 1);
  }

  @Test
  public void testSize() throws Exception {
    Grid grid = new Grid(10);
    
    assertEquals(grid.size(), 10);
  }

  @Test
  public void testCellCount() throws Exception {
    Grid grid = new Grid(10);

    assertEquals(grid.cellCount(), 100);
  }

  @Test
  public void testCountLivingCells() throws Exception {
    Grid grid = new Grid(10);
    
    grid.cellAt(0,0).reproduce();
    grid.cellAt(5,5).reproduce();
    grid.cellAt(9,9).reproduce();
    
    int actual = grid.countLivingCells();
    
    assertEquals(actual, 3);
  }

  @Test
  public void testCountLivingNeighborsWithOneLivingNeighbor() throws Exception {
    Grid grid = new Grid(3);

    grid.cellAt(1,1).reproduce(); //living cell
    grid.cellAt(0,0).reproduce(); //living neighbor
    
    int actual = grid.countLivingNeighbors(1, 1);
    
    assertEquals(actual, 1);
  }

  @Test
  public void testCountLivingNeighborsWithThreeLivingNeighbors() throws Exception {
    Grid grid = new Grid(3);

    grid.cellAt(1,1).reproduce(); //living cell
    grid.cellAt(0,0).reproduce(); //living neighbor
    grid.cellAt(0,2).reproduce(); //living neighbor
    grid.cellAt(2,0).reproduce(); //living neighbor

    int actual = grid.countLivingNeighbors(1,1);

    assertEquals(actual, 3);
  }
}
