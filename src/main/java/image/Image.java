package image;

import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 09/11/2018.
 */
public interface Image {

  /**
   * Return the color of a pixel
   *
   * @param x the x coordinate of the pixel
   * @param y the y coordinate of the pixel
   * @return the color of the pixel
   */
  Color getPixelColor (int x, int y);

  /** @return the width of the image */
  int getWidth ();

  /** @return the height of the image */
  int getHeight ();

}
