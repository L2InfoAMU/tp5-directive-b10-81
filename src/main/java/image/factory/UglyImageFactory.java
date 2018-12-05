package image.factory;

import image.Image;
import image.Point;
import image.VectorImage;
import image.shapes.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class UglyImageFactory implements ImageFactory {

  @Override
  public Image makeImage () {
    List<Shape> shapes = new ArrayList<>();

    shapes.add(new Triangle(new Point(150, 0), new Point(210, 100), new Point(90, 120), Color.BURLYWOOD));
    shapes.add(new Disk(new Point(430, 110), 30, Color.YELLOWGREEN));
    shapes.add(new Ring(new Point(500, 110), 30, 25, Color.YELLOWGREEN));
    shapes.add(new RingAlt(new Point(560, 110), 30, 25, Color.YELLOWGREEN));

    return new VectorImage(shapes, 800, 300);
  }
}
