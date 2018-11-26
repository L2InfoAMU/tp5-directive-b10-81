package util;

import java.util.Objects;

/**
 * Created by Arnaud Labourel on 23/11/2018.
 */
public class Matrices {

  /**
   * Ensures that the given matrix does not have null parts : itself being null, having null row or having
   * null values.
   *
   * @param matrix the matrix to be tested.
   * @throws NullPointerException if there are null parts in the matrix.
   */

  public static void requiresNonNull (Object[][] matrix) {
    Objects.requireNonNull(matrix, "The matrix must not be null.");
    for (int x = 0; x < getRowCount(matrix); x++) {
      Objects.requireNonNull(matrix[x], "The matrix must not have rows equals to null.");
      for (int y = 0; y < matrix[x].length; y++) {
        Objects.requireNonNull(matrix[x][y], "The matrix must not have values equals to null.");
      }
    }
  }

  /**
   * Ensures that the given matrix (assumed to be rectangular) does not have zero rows or zero columns.
   *
   * @param matrix the matrix to be tested.
   * @throws IllegalArgumentException if the matrix have zero rows or zero columns.
   */
  public static void requiresNonZeroDimensions (Object[][] matrix) {
    if (getRowCount(matrix) == 0) {
      throw new IllegalArgumentException("The matrix must not have zero rows.");
    }
    if (getColumnCount(matrix) == 0) {
      throw new IllegalArgumentException("The matrix must not have zero columns.");
    }
  }


  /**
   * Ensures that the given matrix is rectangular, i.e., all rows have the same size.
   *
   * @param matrix the matrix to be tested.
   * @throws IllegalArgumentException if the matrix have rows with different sizes.
   */
  public static void requiresRectangularMatrix (Object[][] matrix) {
    for (int x = 1; x < getRowCount(matrix); x++) {
      if (matrix[x].length != matrix[0].length)
        throw new IllegalArgumentException("The matrix must be rectangular.");
    }
  }

  /**
   * Give the number of rows of a matrix.
   *
   * @param matrix the matrix.
   * @return the number of rows of the matrix.
   */
  public static int getRowCount (Object[][] matrix) {
    return matrix.length;
  }

  /**
   * Give the number of columns of a matrix (assumed to be rectangular).
   *
   * @param matrix the matrix.
   * @return the number of rows of the matrix.
   */
  public static int getColumnCount (Object[][] matrix) {
    return matrix[0].length;
  }

}
