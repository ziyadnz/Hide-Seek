package hw1;

import java.util.Random;

public class HideAndSeekGame {

	public static void main(String[] args) {

		System.out.println("Game started at 18:00 ");

		/* TO TAKE RANDOM NUMBERS */
		Random random = new Random();

		/* PERSON */
		person mother = new person("mother", 0, 1);
		person father = new person("father", 100, 1);
		person girl = new person("girl", 0, 1);

		int hp = 0;
		int cry = 0;
		int time = 0;

		do {
			int number1 = random.nextInt(5);
			int number2 = 1 + random.nextInt(5);
			int number3 = random.nextInt(5);

			girl.setRoomNumber(number1);

			girl.setRoomNumber(number1);
			mother.setRoomNumber(number3);

			System.out.println("Mother at room " + (mother.getRoomNumber() + 1));
			System.out.println("Daughter at room " + (girl.getRoomNumber() + 1));
			System.out.println("Daughter is hiding in the box " + number2);

			for (int i = 0; i < 5; i++) {
				if (mother.getRoomNumber() == i && girl.getRoomNumber() == i) {
					System.out.println("Mother gave the infant to Father");
					for (int j = 1; j < 6; j++) {
						if (number2 == j) {
							hp = i * 5 + j * 2;
							time += i * 5 + j;
							cry++;

							// case1
						}
					}
				} else if (mother.getRoomNumber() <= i) {
					if (mother.getRoomNumber() < girl.getRoomNumber() && mother.getRoomNumber() == i) {
						System.out.println("Mother gave the infant to Father.");
					} else {
						for (int j = 1; j < 6; j++) {
							if (girl.getRoomNumber() == i && number2 == j) {
								hp = mother.getRoomNumber() * 5 + (girl.getRoomNumber() - mother.getRoomNumber()) * 10
										+ number2 * 2;
								time += i * 5 + j;
								cry++;
								continue;
								// annenin olduğu odaya kadar 5 kutu 1 er can 5er azaldı
								// kızın olduğu odaya kadar 2 şerden 10ar azaldı
								// kutuya kadar da 2 şer azaldı j 1 den başladı
								// case2
							}
						}
					}

				} else {
					for (int j = 1; j < 6; j++) {
						if (girl.getRoomNumber() == i && number2 == j) {
							hp = (i * 5) + j;
							time += i * 5 + j;
							// case3
						}
					}
				}

			}
			father.setHealth(father.getHealth() - hp);
			if (cry == 3) {
				System.out.println("Daughter starts crying please stop the game");
			}
		} while (father.getHealth() > 0 && cry < 3);
		System.out.println("Father's left energy is " + father.getHealth());
		System.out.println("Father and Daughter played " + time + " minute(s) hide and seek");

	}
}