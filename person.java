package hw1;

import java.util.Arrays;
import java.util.Random;

public class person {

	public person() {

	}

	public static void hide(int number3) {

		// saklanma yeri mom
		int[][] box = new int[5][5];
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box.length; j++) {
				if (i == number3) {
					box[i][j] = 1;
				} else
					box[i][j] = 0;
			}
		}
	}

	public static void hide(int number1, int number2) {
		// saklanma yeri girl
		int[][] box = new int[5][5];
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box.length; j++) {
				box[i][j] = 0;
			}
		}
		box[number1][number2] = 1;
	}

	public static void father(int hp) {
		int health = 100;
		int[][] find = new int[5][5];
		for (int i = 0; i < find.length; i++) {
			for (int j = 0; j < find.length; j++) {
				find[i][j] = 1;
				health = health - hp;

			}
		}

	}

	public static void mother(int number3) {
		hide(number3);
	}

	public static void doughter(int number1, int number2) {
		hide(number1, number2);
	}

}
