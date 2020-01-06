import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
*
*/
public class Solution {

  /*
   * Compute width (horizontal) view area.
   */
  static int widthView(int[][] A) {

    // **** ****
    int H = A.length;
    int W = A[0].length;

    // **** loop once per row ****
    int area = 0;
    for (int row = 0; row < H; row++) {

      // **** area of first column ****
      area += A[row][0];

      // **** compute area(s) for each column ****
      for (int col = 1; col < W; col++) {
        area += Math.abs(A[row][col] - A[row][col - 1]);
      }

      // **** area of last column ****
      area += A[row][W - 1];
    }

    // ???? ????
    System.out.println("widthView <<< area: " + area);

    // **** ****
    return area;
  }

  /*
   * Compute the area for height (vertical) view.
   */
  static int heightView(int[][] A) {

    // **** ****
    int H = A.length;
    int W = A[0].length;

    // **** loop once per column ****
    int area = 0;
    for (int col = 0; col < W; col++) {

      // **** area of first row ****
      area += A[0][col];

      // **** compute areas(s) for each row ****
      for (int row = 1; row < H; row++) {
        area += Math.abs(A[row][col] - A[row - 1][col]);
      }

      // **** area of last row ****
      area += A[H - 1][col];
    }

    // ???? ????
    System.out.println("heightView <<< area: " + area);

    // **** ****
    return area;
  }

  /*
   * Compute area for vertical view.
   */
  static int verticalView(int[][] A) {

    // **** ****
    int H = A.length;
    int W = A[0].length;

    // **** ****
    int area = 0;
    for (int row = 0; row < H; row++) {
      for (int col = 0; col < W; col++) {
        if (A[row][col] != 0)
          area++;
      }
    }

    // **** duplicate for opposite direction ****
    area *= 2;

    // ???? ????
    System.out.println("verticalView <<< area: " + area);

    // **** ****
    return area;
  }

  /*
   * Complete the surfaceArea function below.
   */
  static int surfaceArea(int[][] A) {

    // **** ****
    int area = 0;

    // **** compute width view area ****
    area += widthView(A);

    // **** compute height view area ****
    area += heightView(A);

    // **** compute vertical view area ****
    area += verticalView(A);

    // **** ****
    return area;
  }

  // **** open scanner ****
  private static final Scanner scanner = new Scanner(System.in);

  /*
   * Test scaffolding.
   */
  public static void main(String[] args) throws IOException {

    // **** output buffered writter ****
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    // **** get and parse the width and height ****
    String[] HW = scanner.nextLine().split(" ");
    int H = Integer.parseInt(HW[0]);
    int W = Integer.parseInt(HW[1]);

    // **** declare array ****
    int[][] A = new int[H][W];

    // **** populate array ****
    for (int i = 0; i < H; i++) {
      String[] ARowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      // **** ****
      for (int j = 0; j < W; j++) {
        int AItem = Integer.parseInt(ARowItems[j]);
        A[i][j] = AItem;
      }
    }

    // **** computer the surface area ****
    int result = surfaceArea(A);

    // **** display the result ****
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    // **** close buffered writer ****
    bufferedWriter.close();

    // **** close scanner ****
    scanner.close();
  }

}
