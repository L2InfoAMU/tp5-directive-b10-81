package image.shapes;

import image.Point;
import javafx.scene.paint.Color;

public class Circle implements Shape {

  Point center;

  double radius;

  Color color;

  public Circle (Point center, double radius, Color color) {
    this.center = center;
    this.radius = radius;
    this.color = color;
  }

  @Override
  public boolean contains (Point point) {
    return center.distanceTo(point) <= radius;
  }

  @Override
  public Color getColor () {
    return color;
  }
}
