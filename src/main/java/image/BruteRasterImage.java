package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image {

  private Color[][] pixels;

  private int width, height;

  public BruteRasterImage (Color[][] colors) {
    Matrices.requiresNonNull(colors);
    Matrices.requiresNonZeroDimensions(colors);
    Matrices.requiresRectangularMatrix(colors);

    this.height = Matrices.getRowCount(colors);
    this.width = Matrices.getColumnCount(colors);
    this.pixels = colors.clone();
  }
  public BruteRasterImage (Color color, int width, int height) {
    this(createColorMatrix(color, width, height));
  }

  private static Color[][] createColorMatrix (Color color, int width, int height) {
    Color[][] colors = new Color[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        colors[row][col] = color;
      }
    }
    return colors;
  }

  @Override
  public Color getPixelColor (int x, int y) {
    return pixels[x][y];
  }

  @Override
  public int getWidth () {
    return width;
  }

  @Override
  public int getHeight () {
    return height;
  }
}
