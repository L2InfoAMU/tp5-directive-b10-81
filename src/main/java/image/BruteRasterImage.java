package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image {

  private Color[][] pixels;

  private int width, height;

  public BruteRasterImage (Color[][] colors) {
    checkMatrix(colors);
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

  private void checkMatrix (Object[][] matrix) {
    Matrices.requiresNonNull(matrix);
    Matrices.requiresNonZeroDimensions(matrix);
    Matrices.requiresRectangularMatrix(matrix);
  }

  public void createRepresentation () {}

  @Override
  public Color getPixelColor (int x, int y) {
    return pixels[y][x];
  }

  @Override
  public void setPixelColor (Color color, int x, int y) {
    pixels[y][x] = color;
  }

  private void setPixelsColor (Color[][] pixels) {
    checkMatrix(pixels);
    this.pixels = pixels.clone();
  }

  private void setPixelsColor (Color color) {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        setPixelColor(color, col, row);
      }
    }
  }

  @Override
  public int getWidth () {
    return width;
  }

  protected void setWidth (int width) {
    this.width = width;
  }

  @Override
  public int getHeight () {
    return height;
  }

  protected void setHeight (int height) {
    this.height = height;
  }
}
