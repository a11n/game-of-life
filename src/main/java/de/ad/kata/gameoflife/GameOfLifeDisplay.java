package de.ad.kata.gameoflife;

import de.ad.kata.gameoflife.gif.AnimatedGifEncoder;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public interface GameOfLifeDisplay {
  void switchOn();

  void display(Grid grid);

  void switchOff();

  class GameOfLifeConsoleDisplay implements GameOfLifeDisplay {

    private final PrintStream out;

    public GameOfLifeConsoleDisplay(PrintStream out) {
      this.out = out;
    }

    @Override public void switchOn() {

    }

    @Override public void display(Grid grid) {
      System.out.println();

      for (int x = 0; x < grid.size(); x++) {
        for (int y = 0; y < grid.size(); y++) {
          Grid.Cell cell = grid.cellAt(x, y);

          String output = cell.isAlive() ? "o " : ". ";
          out.print(output);
        }

        out.println();
      }
    }

    @Override public void switchOff() {

    }
  }

  class GameOfLifeGifDisplay implements GameOfLifeDisplay {

    private final int size;
    private final List<BufferedImage> frames;

    GameOfLifeGifDisplay(int size) {
      this.size = size;
      this.frames = new ArrayList<>();
    }

    @Override public void switchOn() {

    }

    @Override public void display(Grid grid) {
      int cellSize = size / grid.size();

      BufferedImage frame = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics2D = frame.createGraphics();

      for (int x = 0; x < grid.size(); x++) {
        for (int y = 0; y < grid.size(); y++) {
          Color color = grid.cellAt(x, y).isAlive() ? Color.BLACK : Color.WHITE;
          graphics2D.setPaint(color);

          Shape shape = new Rectangle(x * cellSize, y * cellSize, cellSize, cellSize);
          graphics2D.fill(shape);
        }
      }

      frames.add(frame);
    }

    @Override public void switchOff() {
      AnimatedGifEncoder animatedGifEncoder = new AnimatedGifEncoder();
      try {
        animatedGifEncoder.start(new FileOutputStream(new File("game.gif")));
        animatedGifEncoder.setDelay(250);
        for (BufferedImage frame : frames) {
          animatedGifEncoder.addFrame(frame);
        }
        animatedGifEncoder.finish();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
  }
}
