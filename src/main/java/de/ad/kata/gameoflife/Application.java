package de.ad.kata.gameoflife;

public class Application {

  static Application application = new Application(new GameOfLifeEngine(),
      new GameOfLifeDisplay.GameOfLifeConsoleDisplay(System.out), generateInitialPopulation());

  private final GameOfLifeEngine engine;
  private final GameOfLifeDisplay display;
  private final Grid initialPopulation;

  public Application(GameOfLifeEngine engine, GameOfLifeDisplay display, Grid initialPopulation) {
    this.engine = engine;
    this.display = display;
    this.initialPopulation = initialPopulation;
  }

  public static void main(String... args) {
    application.run();
  }

  private void run() {
    Grid currentPopulation = initialPopulation;
    display.display(currentPopulation);

    for (int i = 0; i < 10; i++) {
      currentPopulation = engine.computeNextGeneration(currentPopulation);
      display.display(currentPopulation);
      sleep();
    }
  }

  static Grid generateInitialPopulation() {
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

  private void sleep() {
    try {
      Thread.sleep(480);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
