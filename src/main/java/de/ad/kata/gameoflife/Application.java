package de.ad.kata.gameoflife;

public class Application {
  public static void main(String... args) {
    GameOfLifeEngine engine = new GameOfLifeEngine();
    GameOfLifeDisplay display = new GameOfLifeDisplay.GameOfLifeConsoleDisplay(System.out);

    Grid currentPopulation = initPopulation();
    display.display(currentPopulation);

    for (int i = 0; i < 10; i++) {
      currentPopulation = engine.computeNextGeneration(currentPopulation);
      display.display(currentPopulation);
      sleep();
    }
  }

  private static Grid initPopulation() {
    Grid initialPopulation = new Grid(10);

    for (int x = 0; x < initialPopulation.size(); x++) {
      for (int y = 0; y < initialPopulation.size(); y++) {
        Grid.Cell cell = initialPopulation.cellAt(x, y);

        if (Math.random() >= 0.5) {
          cell.reproduce();
        }
      }
    }

    return initialPopulation;
  }

  private static void sleep() {
    try {
      Thread.sleep(480);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
