package com.tobias.saul;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		List<String> headTailsList;
		double streakCount = 0.0;
		int iterations = 9999;
		
		for (int index = 0; index < iterations; index++) {
			headTailsList = Main.generateRandomHeadTailsList();
			streakCount = Main.streakCounter(headTailsList);
		}
		double percent = (double) (streakCount/100);
		System.out.println("Sample Size: " + iterations + " iterations");
		System.out.println("Chance of streak for streak of six for a face " + percent + "%");

	}

	public static List<String> generateRandomHeadTailsList() {

		List<String> headTailsList = new ArrayList<>();
		Random randomOrdinalCoin = new Random();

		for (int index = 0; index < 100; index++) {

			int coinOrdinal = randomOrdinalCoin.nextInt(2);
			switch (coinOrdinal) {
			case 0:
				headTailsList.add(COINFACE.HEADS.toString());
				break;
			case 1:
				headTailsList.add(COINFACE.TAILS.toString());
				break;
			}

		}
		
		return headTailsList;
	}

	public static int streakCounter(List<String> headTailsList) {

		int streakCount = 0;
		int currentHeadStreak = 0;
		int currentTailsStreak = 0;

		for (String face : headTailsList) {
			if (face.equals("HEADS")) {
				currentTailsStreak = 0;
				currentHeadStreak++;
			} else if (face.equals("TAILS")) {
				currentHeadStreak = 0;
				currentTailsStreak++;
			}

			if (currentHeadStreak == 6) {
				currentHeadStreak = 0;
				streakCount++;
			} else if (currentTailsStreak == 6) {
				currentTailsStreak = 0;
				streakCount++;
			}

		}
		
		return streakCount;

	}

	enum COINFACE {
		HEADS, TAILS
	}

}
