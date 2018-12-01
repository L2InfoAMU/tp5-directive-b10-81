package image.shapes;

import image.Point;
import javafx.scene.paint.Color;

public class Disk implements Shape {

  protected Point center;

  private double radius;

  private Color color;

  public Disk (Point center, double radius, Color color) {
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
