package image;

import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 09/11/2018.
 */
public interface Image {

  Color getPixelColor (int x, int y);

  void setPixelColor (Color color, int x, int y);

  void setPixelsColor (Color[][] pixels);

  void setPixelsColor (Color color);

  int getWidth ();

  int getHeight ();

}
