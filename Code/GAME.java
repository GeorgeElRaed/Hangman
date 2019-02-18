
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GAME {

	public static void Game(String Word) {
		HangMan Ali = new HangMan(Word);
		CharSequence Try;
		Scanner input = new Scanner(System.in);
		System.out.println(Ali.getRemaining());
		while (!Ali.isDead() && !Ali.hasWon()) {

			System.out.print("charracter : ");
			Try = input.next();
			if (Ali.isLetter(Try)) {
				Ali.winCondition(Try);
			} else {
				Ali.Kill();
				System.out.println("Wrong");
				Ali.StartTheKillin();
			}
			System.out.println(Ali.getRemaining());
		}
		if (Ali.isDead()) {
			System.out.println("Ali is dead :( ");
			System.out.println("The Word Was " + Word);
		}
		if (Ali.hasWon()) {
			System.out.println("Ali Survived :D !!");
			System.out.println("    o\n   \\|/\n    |\n   / \\");
		}
		input.close();
	}

	public static int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	public static void main(String[] args) {

		String fileName = "WordDictionary.txt";
		String Line = null;
		int lineNums = 0;

		ArrayList<String> Words = new ArrayList<String>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			while ((Line = bufferedReader.readLine()) != null) {
				Words.add(Line);
				// System.out.println(Line);
				lineNums++;
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		/* System.out.println("chosen word is : "); */
		int i = randomWithRange(0, lineNums - 1);
		/*
		 * System.out.println(Words.toArray()[i]);
		 * System.out.println("*********************");
		 * System.out.println("*********************");
		 */
		Game((String) Words.toArray()[i]);
	}

}
