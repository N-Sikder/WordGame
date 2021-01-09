import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class hardWords {

	private static String[] wordsHard = new String[100];
	private static File fileHard = new File("Words hard.txt");
	private static int i;
	private static int lineCounterForHARD = 0;

	public static int RandomNumberGenerator() {

		Random rand = new Random();

		int rand_int1 = rand.nextInt(99);

		return rand_int1;

	}

	public static String getShuffledWord(String original) {

		String shuffledWord = original; 

		int wordSize = original.length();
		int shuffleCount = 10; 

		for (int i = 0; i < shuffleCount; i++) {

			
			int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
			int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);

			shuffledWord = swapCharacters(shuffledWord, position1, position2);

		}

		return shuffledWord;

	}

	private static String swapCharacters(String shuffledWord, int position1, int position2) {

		char[] charArray = shuffledWord.toCharArray();

		

		char temp = charArray[position1];

		charArray[position1] = charArray[position2];
		charArray[position2] = temp;

		return new String(charArray);

	}

	public static String hardWords() throws IOException {

		Scanner scanLineForFileHard = new Scanner(fileHard);

		while (scanLineForFileHard.hasNextLine()) {
			lineCounterForHARD = lineCounterForHARD + 1;
			scanLineForFileHard.next();
		}

		for (i = 0; i < lineCounterForHARD; i++) {

			String wordHard = Files.readAllLines(Paths.get("Words hard.txt")).get(i);
			wordsHard[i] = wordHard;

		}

		int randomNumber = RandomNumberGenerator();

		return wordsHard[randomNumber];

	}

}
