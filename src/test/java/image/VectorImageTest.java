package image;

import image.shapes.Rectangle;
import image.shapes.Shape;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VectorImageTest {

  List<Shape> shapes = new ArrayList<>();

  Image whiteImage, otherWhiteImage, blackImage, stripeImage;

  @BeforeEach
  void setUp () {
    shapes.add(new Rectangle(0, 0, 200, 100, Color.WHITE));
    whiteImage = new VectorImage(shapes, 200, 100);
    shapes.clear();
    otherWhiteImage = new VectorImage(shapes, 200, 100);
    shapes.add(new Rectangle(0, 0, 200, 100, Color.BLACK));
    blackImage = new VectorImage(shapes, 200, 100);
    shapes.clear();
    for (int col = 0; col < 200; col++) {
      if (col % 10 == 0)
        shapes.add(new Rectangle(col, 0, 4, 300, Color.BLUE));
    }
    stripeImage = new VectorImage(shapes, 200, 300);
  }

  @Test
  void constructorTest () {
    assertThrows(RuntimeException.class, () -> new VectorImage(null, 10, 10));
    assertThrows(RuntimeException.class, () -> new VectorImage(shapes, -10, 10));
    assertThrows(RuntimeException.class, () -> new VectorImage(shapes, 10, -10));
  }

  @Test
  void getPixelColor () {
    for (int row = 0; row < 100; row++) {
      for (int col = 0; col < 200; col++) {
        assertEquals(Color.WHITE, whiteImage.getPixelColor(col, row));
        assertEquals(Color.WHITE, otherWhiteImage.getPixelColor(col, row));
        assertEquals(Color.BLACK, blackImage.getPixelColor(col, row));
      }
    }
    for (int row = 0; row < 300; row++) {
      for (int col = 0; col < 200; col++) {
        if (col % 10 > 4)
          assertEquals(Color.WHITE, stripeImage.getPixelColor(col, row));
        else
          assertEquals(Color.BLUE, stripeImage.getPixelColor(col, row));
      }
    }
  }
}
