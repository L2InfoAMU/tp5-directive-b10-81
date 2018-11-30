package image;

import javafx.scene.paint.Color;

/**
 *
 */
public abstract class BaseImage implements Image {

  protected int width, height;

  @Override
  public abstract Color getPixelColor (int x, int y);

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
