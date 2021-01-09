import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class mediumWords {

	private static String[] wordsMedium = new String[100];
	private static File fileEasy = new File("Words-ez.txt");
	private static int i;
	private static int lineCounterForMedium = 0;

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

	public static String mediumWords() throws IOException {

		Scanner scanLineForFileMedium = new Scanner(fileEasy);

		while (scanLineForFileMedium.hasNextLine()) {
			lineCounterForMedium = lineCounterForMedium + 1;
			scanLineForFileMedium.next();
		}

		for (i = 0; i < lineCounterForMedium; i++) {

			String wordMedium = Files.readAllLines(Paths.get("Words-ez.txt")).get(i);
			wordsMedium[i] = wordMedium;

		}

		int randomNumber = RandomNumberGenerator();
		
		return wordsMedium[randomNumber];

	}

}