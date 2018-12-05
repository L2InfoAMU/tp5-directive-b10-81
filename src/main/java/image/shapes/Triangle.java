package image.shapes;

import image.Point;
import javafx.scene.paint.Color;

public class Triangle implements Shape {

  private Point a, b, c;

  private Rectangle boundingBox;

  public Triangle (Point a, Point b, Point c, Color color) {
    if (color == null || a.equals(b) || a.equals(c) || b.equals(c))
      throw new IllegalArgumentException();

    this.a = a;
    this.b = b;
    this.c = c;

    this.boundingBox = createBoundingBox(a, b, c, color);
  }

  private Rectangle createBoundingBox (Point a, Point b, Point c, Color color) {
    int minX, maxX, minY, maxY;

    minX = Math.min(a.x, Math.min(b.x, c.x));
    minY = Math.min(a.y, Math.min(b.y, c.y));
    maxX = Math.max(a.x, Math.max(b.x, c.x));
    maxY = Math.max(a.y, Math.max(b.y, c.y));
    return new Rectangle(minX, minY, maxX - minX, maxY - minY, color);
  }

  @Override
  public boolean contains (Point point) {
    if (boundingBox.contains(point)) {
      // @TODO : understand these lines
      double denominator = ((b.y - c.y) * (a.x - c.x) + (c.x - b.x) * (a.y - c.y));
      double lambda = ((b.y - c.y) * (point.x - c.x) + (c.x - b.x) * (point.y - c.y)) / denominator;
      double beta = ((c.y - a.y) * (point.x - c.x) + (a.x - c.x) * (point.y - c.y)) / denominator;
      double phi = 1 - lambda - beta;
      return 0 <= lambda && lambda <= 1 && 0 <= beta && beta <= 1 && 0 <= phi && phi <= 1;
    }
    return false;
  }

  @Override
  public Color getColor () {
    return boundingBox.getColor();
  }
}
