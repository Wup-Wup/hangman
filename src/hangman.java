import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;

public class hangman {

	public static void main(String[] args) {
		game();
	}

	public static void game() {
		int mistakes = 10;
		int answers = 0;
		int win = 0;
		int counter = 0;
		String zeile = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader("Wort.txt"));
			zeile = in.readLine();
			in.close();
		} catch (Exception e) {
			}

		for (int i = 0; i < zeile.length(); i++) {
			System.out.print("_");
		}
		char guessing[] = zeile.toCharArray();
		char letters[] = new char[guessing.length];

		for (int i = 0; i < letters.length; i++) {
			letters[i] = 0;
		}

		Scanner scanner = new Scanner(System.in);

		while (answers < guessing.length) {
			String s = scanner.nextLine();
			char word = s.charAt(0);
			for (int i = 0; i < guessing.length; i++) {
				if ((Character.toLowerCase(guessing[i]) == word) && letters[i] == 0) {
					letters[i] = word;
					counter++;
					answers++;
				}
			}
			if (counter < 1) {
				mistakes--;
				System.out.println(mistakes + " lives left");
			}
			if (mistakes == 0) {
				System.out.println("You lost");
				break;
			}
			counter = 0;
			for (int i = 0; i < letters.length; i++) {
				if (letters[i] == 0) {
					System.out.print("_");
				} else {
					System.out.print(letters[i]);
				}
			}
			System.out.println();
		}
		scanner.close();
		for (int i = 0; i < letters.length; i++) {
			if (Character.toLowerCase(letters[i]) == Character.toLowerCase(guessing[i])) {
				win++;
			}
		}
		if (win == letters.length) {
			System.out.println("You won");
		}
	}
}
