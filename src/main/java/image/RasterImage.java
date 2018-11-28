package image;

import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage implements Image {

  protected int width, height;

  public RasterImage (Color color, int width, int height) {
    if (color == null) throw new NullPointerException();
    this.height = height;
    this.width = width;
    createRepresentation();
    setPixelsColor(color);
  }

  public RasterImage (Color[][] colors) {
    Matrices.requiresNonNull(colors);
    Matrices.requiresNonZeroDimensions(colors);
    Matrices.requiresRectangularMatrix(colors);

    this.height = Matrices.getRowCount(colors);
    this.width = Matrices.getColumnCount(colors);
    createRepresentation();
    setPixelsColor(colors);
  }

  public abstract void createRepresentation ();

  @Override
  public abstract Color getPixelColor (int x, int y);

  @Override
  public abstract void  setPixelColor (Color color, int x, int y);

  protected void setPixelsColor (Color color) {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        setPixelColor(color, col, row);
      }
    }
  }

  private void setPixelsColor (Color[][] pixels) {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        setPixelColor(pixels[row][col], col, row);
      }
    }
  }

  @Override
  public int getWidth () {
    return width;
  }

  @Override
  public int getHeight () {
    return height;
  }

  protected void setWidth (int width) {
    this.width = width;
  }

  protected void setHeight (int height) {
    this.height = height;
  }
}
