package image.shapes;

import image.Point;
import javafx.scene.paint.Color;

public class Ring extends Circle {

  double innerRadius;

  public Ring (Point center, double radius, double innerRadius, Color color) {
    super(center, radius, color);
    this.innerRadius = innerRadius;
  }

  @Override
  public boolean contains (Point point) {
    return super.contains(point) && center.distanceTo(point) >= innerRadius;
  }
}
