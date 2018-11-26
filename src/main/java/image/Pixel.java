package image;

import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 09/11/2018.
 */
public class Pixel extends Point {

  private Color color;

  Pixel (int x, int y, Color color) {
    super(x, y);
    this.color = color;
  }

  public Color getColor () {
    return color;
  }
}
