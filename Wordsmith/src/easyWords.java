import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class easyWords {

	private static String[] wordsEZ = new String[100];
	private static File fileEasy = new File("Words-ez.txt");
	private static int lineCounterForEZ = 0;

	public static int RandomNumberGenerator() {

		Random random = new Random();

		int randomNumber = random.nextInt(99);

		return randomNumber;

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

	public static String easyWords() throws IOException {

		Scanner scanLineForFileEasy = new Scanner(fileEasy);

		while (scanLineForFileEasy.hasNextLine()) {
			lineCounterForEZ = lineCounterForEZ + 1;
			scanLineForFileEasy.next();
		}

		for (int i = 0; i < lineCounterForEZ; i++) {

			String wordEasy = Files.readAllLines(Paths.get("Words-ez.txt")).get(i);
			wordsEZ[i] = wordEasy;

		}

		int randomNumber = RandomNumberGenerator();

		return wordsEZ[randomNumber];

	}

}
