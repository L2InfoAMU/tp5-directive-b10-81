package image;

import javafx.scene.paint.Color;

public class BruteRasterImage extends RasterImage {

  private Color[][] pixels;

  public BruteRasterImage (Color color, int width, int height) {
    super(color, width, height);
  }

  public BruteRasterImage (Color[][] colors) {
    super(colors);
  }

  @Override
  public void createRepresentation () {
    pixels = new Color[height][width];
  }

  @Override
  public Color getPixelColor (int x, int y) {
    return pixels[y][x];
  }

  @Override
  public void setPixelColor (Color color, int x, int y) {
    pixels[y][x] = colorCopy(color);
  }
}
