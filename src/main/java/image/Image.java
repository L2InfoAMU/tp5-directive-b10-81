package image;

import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 09/11/2018.
 */
public interface Image {

  /**
   *
   * @param x
   * @param y
   * @return
   */
  Color getPixelColor (int x, int y);

  /**  */
  int getWidth ();

  /**  */
  int getHeight ();

}
