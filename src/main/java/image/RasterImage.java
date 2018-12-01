package image;

import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage extends BaseImage {

  /**
   * Constructs a monochromatic image.
   *
   * @param color the color of the image
   * @param width the width of the image
   * @param height the height of the image
   */
  public RasterImage (Color color, int width, int height) {
    if (color == null) throw new NullPointerException();
    setHeight(height);
    setWidth(width);
    createRepresentation();
    setPixelsColor(color);
  }

  /**
   *  Constructs a color image with a given color matrix.
   *
   * @param colors the color matrix
   */
  public RasterImage (Color[][] colors) {
    Matrices.requiresNonNull(colors);
    Matrices.requiresNonZeroDimensions(colors);
    Matrices.requiresRectangularMatrix(colors);

    setHeight(Matrices.getRowCount(colors));
    setWidth(Matrices.getColumnCount(colors));
    createRepresentation();
    setPixelsColor(colors);
  }

  /**
   * A class that extends RasterImage must create its internal
   * data structure from this method.
   */
  public abstract void createRepresentation ();

  /**
   *  Change the color of a pixel.
   *
   * @param color the new color of the pixel
   * @param x the x coordinate of the pixel
   * @param y the y coordinate of the pixel
   */
  public abstract void  setPixelColor (Color color, int x, int y);

  /**
   * Change the color of each pixel of the image with the given color.
   *
   * @param color the new color of the image
   */
  protected void setPixelsColor (Color color) {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        setPixelColor(color, col, row);
      }
    }
  }

  /**
   * Change the color of each pixel of the image with a given color matrix.
   *
   * @param pixels the color matrix
   */
  private void setPixelsColor (Color[][] pixels) {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        setPixelColor(pixels[row][col], col, row);
      }
    }
  }

  /**
   *  Helper method.
   *  Make a copy of a given color.
   *
   * @param c the color to copy
   * @return the copy of the color
   */
  protected final Color colorCopy (Color c) {
    return new Color(c.getRed(), c.getGreen(), c.getBlue(), c.getOpacity());
  }
}
