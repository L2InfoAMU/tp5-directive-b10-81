package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class VectorImage implements Image {

  private List<Shape> shapes;

  private int width, height;

  public VectorImage (List<Shape> shapes, int width, int height) {
    if (shapes.isEmpty() || width <= 0 || height <= 0) throw new IllegalArgumentException();
    this.shapes = new ArrayList<>(shapes);
    this.width = width;
    this.height = height;
  }

  @Override
  public Color getPixelColor (int x, int y) {
    Point point = new Point(x, y);
    for (Shape shape : shapes) {
      if (shape.contains(point)) return shape.getColor();
    }

    return Color.WHITE;
  }

  @Override
  public int getWidth () {
    return width;
  }

  @Override
  public int getHeight () {
    return height;
  }

  protected void setWidth (int width) {
    this.width = width;
  }

  protected void setHeight (int height) {
    this.height = height;
  }
}
