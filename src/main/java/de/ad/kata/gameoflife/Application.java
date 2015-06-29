package de.ad.kata.gameoflife;

public class Application {
  public static void main(String... args){
    GameOfLifeEngine engine = new GameOfLifeEngine();
    GameOfLifeDisplay display = new GameOfLifeDisplay.GameOfLifeConsoleDisplay(System.out);
    
    Grid currentPopulation = initPopulation();
    display.display(currentPopulation);
    
    for (int i = 0; i < 10; i++) {
      currentPopulation = engine.computeNextGeneration(currentPopulation);
      display.display(currentPopulation);
    }
  }

  private static Grid initPopulation() {
    Grid initialPopulation = new Grid(3);
    
    initialPopulation.cellAt(1,1).reproduce();
    initialPopulation.cellAt(1,2).reproduce();
    initialPopulation.cellAt(2,2).reproduce();
    
    return initialPopulation;
  }
}
