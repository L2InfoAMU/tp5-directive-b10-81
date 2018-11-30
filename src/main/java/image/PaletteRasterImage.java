package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage {

  private List<Color> palette;

  private byte[][] indexesOfColors;


  public PaletteRasterImage (Color color, int width, int height) {
    super(color, width, height);
  }

  public PaletteRasterImage (Color[][] pixels) {
    super(pixels);
  }

  @Override
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
      palette.add(colorCopy(color));
      index = palette.size() -1;
    }
    indexesOfColors[y][x] = (byte) index;
  }

  @Override
  protected void setPixelsColor (Color color) {
    palette.clear();
    palette.add(colorCopy(color));

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        indexesOfColors[row][col] = 0;
      }
    }
  }
}
