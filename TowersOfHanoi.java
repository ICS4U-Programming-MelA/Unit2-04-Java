// Import modules.
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.Scanner;

/** Copyright (c) 2022 Mel Aguoth All rights reserved.
 * This displays the movement of discs in "Towers of Hanoi" using recursion.
 *
 * @author  Mel Aguoth
 * @version 11.0.13
 * @since 2022-01-21
 */

final class TowersOfHanoi {
  private static void discMovement(final int discNum, final int startRod, final int endRod) {
    // Display the formatted disc movement.
    System.out.print("Disc " + discNum + ": Tower " + startRod + " to Tower " + endRod + "\n");
  }

  private static void hanoi(final int discNum, final int startRod, final int endRod) {
    // Display the movements of 'Towers of Hanoi' for only 1 disc.
    if (discNum == 1) {
      discMovement(discNum, startRod, endRod);

    // Display the movements of 'Towers of Hanoi' for 2 or more discs.
    } else {
      final int middleRod = 6 - (startRod + endRod);
      hanoi(discNum - 1, startRod, middleRod);
      discMovement(discNum, startRod, endRod);
      hanoi(discNum - 1, middleRod, endRod);
    }
  }

  public static void main(final String[] args) {

    // Declare an empty string for a NumberFormatException.
    String userString = "";

    try {

      System.out.print("This program displays the movement of discs in 'Towers of Hanoi.'" + "\n");

      // Get the user's number of discs.
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of discs on Tower 1 (positive integer): ");
      userString = input.next();
      final int userInt = Integer.parseInt(userString);
      input.close();

      // If the user's integer isn't above 0, display an error to the user.
      if (userInt < 0) {
        System.out.print("\n" + userInt + " isn't a positive integer. Please enter an integer"
                       + " above 0." + "\n");
      } else {

        // Call hanoi.
        System.out.print("\n");
        hanoi(userInt, 1, 3);
        System.out.print("Finished." + "\n");
      }

      // If the user's input isn't an integer, display an error to the user.
    } catch (NumberFormatException e2) {
      System.out.print("\n" + "'" + userString + "' isn't an integer."
                       + " Please enter a proper integer." + "\n");
    }
  }
}
