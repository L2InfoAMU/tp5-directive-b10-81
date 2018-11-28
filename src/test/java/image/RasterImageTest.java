package image;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RasterImageTest {

  private static int width = 500, height = 800;

  private static Color[][] zeroDimensionMatrix;

  private static Color[][] nullFilledMatrix;

  private static Color[][] goldMatrix, blueMatrix, redMatrix,  blackmatrix, whiteMatrix;

  private BruteRasterImage goldImage, blueImage;

  private PaletteRasterImage blackImage;

  private SparseRasterImage whiteImage, redImage;

  @BeforeAll
  static void init () {
    zeroDimensionMatrix = new Color[0][0];
    nullFilledMatrix = new Color[height][width];
    goldMatrix = new Color[height][width];
    blueMatrix = new Color[height][width];
    blackmatrix = new Color[height][width];
    whiteMatrix = new Color[height][width];
    redMatrix = new Color[height][width];
  }

  @BeforeEach
  void setUp () {
    for (int row = 0; row < height; row++) {
      for(int col = 0; col < width; col++) {
        goldMatrix[row][col] = Color.GOLD;
        blueMatrix[row][col] = Color.BLUEVIOLET;
        blackmatrix[row][col] = Color.BLACK;
        whiteMatrix[row][col] = Color.WHITESMOKE;
        redMatrix[row][col] = Color.RED;
      }
    }
    goldImage = new BruteRasterImage(goldMatrix);
    blueImage = new BruteRasterImage(blueMatrix);
    blackImage = new PaletteRasterImage(blackmatrix);
    whiteImage = new SparseRasterImage(whiteMatrix);
    redImage = new SparseRasterImage(redMatrix);
  }

  @Test
  void testConstructor () {
    assertThrows(RuntimeException.class, () -> new BruteRasterImage(zeroDimensionMatrix));
    assertThrows(RuntimeException.class, () -> new BruteRasterImage(nullFilledMatrix));
    assertThrows(RuntimeException.class, () -> new BruteRasterImage(null, width, height));
    assertThrows(RuntimeException.class, () -> new BruteRasterImage(Color.GRAY, -1, -2));
    assertNotNull(new BruteRasterImage(goldMatrix));
    assertNotNull(new BruteRasterImage(Color.GOLD, width, height));
  }

  @Test
  void getPixelColor () {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        assertEquals(Color.GOLD, goldImage.getPixelColor(col, row));
        assertEquals(Color.BLUEVIOLET, blueImage.getPixelColor(col, row));
        assertEquals(Color.BLACK, blackImage.getPixelColor(col, row));
        assertEquals(Color.WHITESMOKE, whiteImage.getPixelColor(col, row));
        assertEquals(Color.RED, redImage.getPixelColor(col, row));
      }
    }
  }

  @Test
  void getWidth () {
    assertEquals(width, goldImage.getWidth());
  }

  @Test
  void getHeight () {
    assertEquals(height, goldImage.getHeight());
  }

  @Test
  void setPixelColor () {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        goldImage.setPixelColor(blueImage.getPixelColor(col, row), col, row);
        blueImage.setPixelColor(Color.RED, col, row);
        blackImage.setPixelColor(Color.YELLOWGREEN, col, row);
        whiteImage.setPixelColor(Color.CYAN, col, row);
        redImage.setPixelColor(Color.CRIMSON, col, row);
        assertEquals(Color.BLUEVIOLET, goldImage.getPixelColor(col, row));
        assertEquals(Color.RED, blueImage.getPixelColor(col, row));
        assertEquals(Color.YELLOWGREEN, blackImage.getPixelColor(col, row));
        assertEquals(Color.CYAN, whiteImage.getPixelColor(col, row));
        assertEquals(Color.CRIMSON, redImage.getPixelColor(col, row));
      }
    }
  }

//  @Test
//  void setPixelsColorWithColorMatrix () {
//    assertThrows(RuntimeException.class, () -> goldImage.setPixelsColor(zeroDimensionMatrix));
//    assertThrows(RuntimeException.class, () -> goldImage.setPixelsColor(nullFilledMatrix));
//    goldImage.setPixelsColor(blueMatrix);
//    blueImage.setPixelsColor(goldMatrix);
//    for (int row = 0; row < height; row++) {
//      for (int col = 0; col < width; col++) {
//        assertEquals(Color.BLUEVIOLET, goldImage.getPixelColor(col, row));
//        assertEquals(Color.GOLD, blueImage.getPixelColor(col, row));
//      }
//    }
//  }
//
//  @Test
//  void setPixelsColorWithColor () {
//    goldImage.setPixelsColor(Color.BLACK);
//    blueImage.setPixelsColor(Color.WHITE);
//    for (int row = 0; row < height; row++) {
//      for (int col = 0; col < width; col++) {
//        assertEquals(Color.BLACK, goldImage.getPixelColor(col, row));
//        assertEquals(Color.WHITE, blueImage.getPixelColor(col, row));
//      }
//    }
//  }

  @Test
  void setWidth () {
    blueImage.setWidth(height);
    assertEquals(height, blueImage.getWidth());
  }

  @Test
  void setHeight () {
    blueImage.setHeight(width);
    assertEquals(width, blueImage.getHeight());
  }
}
