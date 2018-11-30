package image;

import java.util.Objects;

/**
 * Created by Arnaud Labourel on 09/11/2018.
 */
public class Point {

  public final int x, y;

  public Point (int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public final boolean equals (Object o) {
    if (this == o) return true;
    if (!(o instanceof Point)) return false;
    Point point = (Point) o;
    return x == point.x &&
      y == point.y;
  }

  @Override
  public final int hashCode () {
    return Objects.hash(x, y);
  }

  public final double distanceTo (Point p) {
    return Math.hypot(x - p.x, y - p.y);
  }

}
