package image;

import image.shapes.Shape;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class VectorImage extends BaseImage {

  private List<Shape> shapes;

  public VectorImage (List<Shape> shapes, int width, int height) {
    if (width <= 0 || height <= 0) throw new IllegalArgumentException();
    this.shapes = new ArrayList<>(shapes);
    setWidth(width);
    setHeight(height);
  }

  @Override
  public Color getPixelColor (int x, int y) {
    Point point = new Point(x, y);
    for (Shape shape : shapes) {
      if (shape.contains(point)) return shape.getColor();
    }

    return Color.WHITE;
  }
}
