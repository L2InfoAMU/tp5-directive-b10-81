package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

  private List<Color> palette;

  private byte[][] indexesOfColors;

  private int width, height;

  public PaletteRasterImage (Color color, int width, int height) {
    this.height = height;
    this.width = width;
    createRepresentation();
    setPixelsColor(color);
  }

  public PaletteRasterImage (Color[][] pixels) {
    setPixelsColor(pixels);
  }

  public void createRepresentation () {
    palette = new ArrayList<>();
    indexesOfColors = new byte[height][width];
  }

  @Override
  public Color getPixelColor (int x, int y) {
    return palette.get(indexesOfColors[y][x]);
  }

  @Override
  public void setPixelColor (Color color, int x, int y) {
    int index = palette.indexOf(color);
    if (index == -1) {
      palette.add(color);
      index = palette.size() -1;
    }
    indexesOfColors[y][x] = (byte) index;
  }

  private void setPixelsColor (Color[][] pixels) {
    Matrices.requiresNonNull(pixels);
    Matrices.requiresNonZeroDimensions(pixels);
    Matrices.requiresRectangularMatrix(pixels);

    this.height = Matrices.getRowCount(pixels);
    this.width = Matrices.getColumnCount(pixels);

    createRepresentation();

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        setPixelColor(pixels[row][col], col, row);
      }
    }
  }

  private void setPixelsColor (Color color) {
    palette.clear();
    palette.add(color);

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        indexesOfColors[row][col] = 0;
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
