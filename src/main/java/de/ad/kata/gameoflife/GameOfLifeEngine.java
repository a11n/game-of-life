package de.ad.kata.gameoflife;

public class GameOfLifeEngine {
  public Grid computeNextGeneration(Grid currentGeneration) {
    log("Current population (%d,%d).", currentGeneration.countLivingCells(),
        currentGeneration.size());

    Grid nextGeneration = new Grid(currentGeneration.size());

    for (int x = 0; x < currentGeneration.size(); x++) {
      for (int y = 0; y < currentGeneration.size(); y++) {
        Grid.Cell presentCell = currentGeneration.cellAt(x, y);
        Grid.Cell futureCell = nextGeneration.cellAt(x, y);

        int livingNeighborsCount = currentGeneration.countLivingNeighbors(x, y);

        String status = presentCell.isAlive() ? "alive" : "dead";
        log("Cell (%d,%d) is %s and has %d living neighbor(s).", x, y, status, livingNeighborsCount);

        if (presentCell.isAlive() && livingNeighborsCount < 2) {
          log("...dies in next generation :-( (under-population)");
          futureCell.die();
        }
      }
    }

    return nextGeneration;
  }

  private void log(String pattern, Object... values) {
    System.out.println(String.format(pattern, values));
  }
}
