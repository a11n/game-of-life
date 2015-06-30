package de.ad.kata.gameoflife;

public class GameOfLifeEngine {

  private int generation;

  public GameOfLifeEngine() {
    generation = 0;
  }

  public Grid computeNextGeneration(Grid currentGeneration) {
    logGridDetails(currentGeneration);

    Grid nextGeneration = new Grid(currentGeneration.size());

    for (int x = 0; x < currentGeneration.size(); x++) {
      for (int y = 0; y < currentGeneration.size(); y++) {
        Grid.Cell presentCell = currentGeneration.cellAt(x, y);
        Grid.Cell futureCell = nextGeneration.cellAt(x, y);
        int livingNeighborsCount = currentGeneration.countLivingNeighbors(x, y);

        logCellDetails(x, y, presentCell, livingNeighborsCount);

        applyRules(presentCell, futureCell, livingNeighborsCount);
      }
    }

    generation++;

    return nextGeneration;
  }

  private void applyRules(Grid.Cell presentCell, Grid.Cell futureCell, int livingNeighborsCount) {
    applyRule1(presentCell, futureCell, livingNeighborsCount);
    applyRule2(presentCell, futureCell, livingNeighborsCount);
    applyRule3(presentCell, futureCell, livingNeighborsCount);
    applyRule4(presentCell, futureCell, livingNeighborsCount);
  }

  private void applyRule1(Grid.Cell presentCell, Grid.Cell futureCell, int livingNeighborsCount) {
    if (presentCell.isAlive() && livingNeighborsCount < 2) {
      log("...dies in next generation :-( (under-population)");
      futureCell.die();
    }
  }

  private void applyRule2(Grid.Cell presentCell, Grid.Cell futureCell, int livingNeighborsCount) {
    if (presentCell.isAlive() && (livingNeighborsCount == 2 || livingNeighborsCount == 3)) {
      log("...lives in next generation :-)");
      futureCell.reproduce();
    }
  }

  private void applyRule3(Grid.Cell presentCell, Grid.Cell futureCell, int livingNeighborsCount) {
    if (presentCell.isAlive() && livingNeighborsCount > 3) {
      log("...dies in next generation :-( (overcrowding)");
      futureCell.die();
    }
  }

  private void applyRule4(Grid.Cell presentCell, Grid.Cell futureCell, int livingNeighborsCount) {
    if (presentCell.isDead() && livingNeighborsCount == 3) {
      log("...lives in next generation :-) (reproduction)");
      futureCell.reproduce();
    }
  }

  private void logGridDetails(Grid currentGeneration) {
    log("Generation #%d: population %d/%d", generation, currentGeneration.countLivingCells(),
        currentGeneration.cellCount());
  }

  private void logCellDetails(int x, int y, Grid.Cell presentCell, int livingNeighborsCount) {
    String status = presentCell.isAlive() ? "alive" : "dead";
    log("Cell (%d,%d) is %s and has %d living neighbor(s).", x, y, status,
        livingNeighborsCount);
  }

  private void log(String pattern, Object... values) {
    //System.out.println(String.format(pattern, values));
  }
}
