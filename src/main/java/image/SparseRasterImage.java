package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class SparseRasterImage extends RasterImage {

  private Map<Point, Color> pixelsMap;

  public SparseRasterImage (Color color, int width, int height) {
    super(color, width, height);
  }

  public SparseRasterImage (Color[][] pixels) {
    super(pixels);
  }

  @Override
  public void createRepresentation () {
    pixelsMap = new HashMap<>();
  }

  @Override
  public Color getPixelColor(int x, int y) {
    return pixelsMap.getOrDefault(new Point(x, y), Color.WHITE);
  }

  @Override
  public void setPixelColor(Color color, int x, int y) {
    Point point = new Point(x, y);
    if (color.equals(Color.WHITE)) {
      pixelsMap.remove(point);
      return;
    }
    if (pixelsMap.replace(point, colorCopy(color)) == null) pixelsMap.put(point, colorCopy(color));
  }

  @Override
  protected void setPixelsColor (Color color) {
    pixelsMap.clear();
    if (color.equals(Color.WHITE))
      return;

    super.setPixelsColor(color);
  }
}
