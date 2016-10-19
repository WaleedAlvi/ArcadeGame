package coreServlets;

public class GGHelper {
	public static boolean checkGuess(Object mystery, String guess) {
		// System.out.println(mystery);
		boolean correct = false;
		int guessNum = Integer.parseInt(guess);
		System.out.println(guessNum);
		int mysteryNum = (Integer) mystery;
		System.out.println(mysteryNum);
		if (guessNum == mysteryNum) {
			correct = true;
		} else {
			correct = false;
		}
		return correct;
	}

	public static int getRandNum() {
		int num = 1 + ((int) (Math.random() * 100));
		return num;
	}
}