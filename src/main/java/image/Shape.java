package image;

import javafx.scene.paint.Color;

public interface Shape {

  /**
   * Tests if a specified Point is inside the boundary of the Shape.
   *
   * @return true if the point is inside the shape and false otherwise.
   */
  boolean contains (Point point);

  /**
   * Return the color of the interior of the Shape.
   *
   * @return the color of the shape.
   */
  Color getColor ();
}
