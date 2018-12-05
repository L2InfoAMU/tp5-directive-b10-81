package image.shapes;

import image.Point;
import javafx.scene.paint.Color;

/* composition over inheritance */
public class RingAlt implements Shape {

  private Disk outerDisk, innerDisk;

  public RingAlt (Point center, int outerRadius, int innerRadius, Color color) {
    outerDisk = new Disk(center, outerRadius, color);
    innerDisk = new Disk(center, innerRadius, color);
  }

  @Override
  public boolean contains (Point point) {
    return outerDisk.contains(point) && !innerDisk.contains(point);
  }

  @Override
  public Color getColor () {
    return outerDisk.getColor();
  }
}
