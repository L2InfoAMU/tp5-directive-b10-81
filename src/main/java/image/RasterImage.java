package image;

import javafx.scene.paint.Color;
import util.Matrices;

/**
 *
 */
public abstract class RasterImage extends BaseImage {

  /**
   * Constructs a monochromatic image
   *
   * @param color
   * @param width
   * @param height
   */
  public RasterImage (Color color, int width, int height) {
    if (color == null) throw new NullPointerException();
    this.height = height;
    this.width = width;
    createRepresentation();
    setPixelsColor(color);
  }

  /**
   *
   * @param colors
   */
  public RasterImage (Color[][] colors) {
    Matrices.requiresNonNull(colors);
    Matrices.requiresNonZeroDimensions(colors);
    Matrices.requiresRectangularMatrix(colors);

    this.height = Matrices.getRowCount(colors);
    this.width = Matrices.getColumnCount(colors);
    createRepresentation();
    setPixelsColor(colors);
  }

  /**
   *
   */
  public abstract void createRepresentation ();

  /**
   *
   * @param color
   * @param x
   * @param y
   */
  public abstract void  setPixelColor (Color color, int x, int y);

  /**
   *
   * @param color
   */
  protected void setPixelsColor (Color color) {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        setPixelColor(color, col, row);
      }
    }
  }

  /**
   *
   * @param pixels
   */
  private void setPixelsColor (Color[][] pixels) {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        setPixelColor(pixels[row][col], col, row);
      }
    }
  }

  /**
   *
   * @param c
   * @return
   */
  protected final Color colorCopy (Color c) {
    return new Color(c.getRed(), c.getGreen(), c.getBlue(), c.getOpacity());
  }
}
