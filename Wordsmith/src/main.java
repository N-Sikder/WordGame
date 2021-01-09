import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {

		String getEasyWord, getMediumWord, getHardWord, shuffleThatEasyWord, shuffleThatMediumWord, shuffleThatHardWord;

		easyWords easy = new easyWords();
		mediumWords medium = new mediumWords();
		hardWords hard = new hardWords();

		getEasyWord = easy.easyWords();
		getMediumWord = medium.mediumWords();
		getHardWord = hard.hardWords();

		//System.out.println(getEasyWord);
		//System.out.println(getMediumWord);
		//System.out.println(getHardWord);

		shuffleThatEasyWord = easy.getShuffledWord(getEasyWord);
		shuffleThatMediumWord = medium.getShuffledWord(getMediumWord);
		shuffleThatHardWord = hard.getShuffledWord(getHardWord);

		while (shuffleThatEasyWord == getEasyWord) {

			shuffleThatEasyWord = easy.getShuffledWord(getEasyWord);

		}

		System.out.println(shuffleThatEasyWord);
		System.out.println("");

		while (shuffleThatMediumWord == getMediumWord) {

			shuffleThatMediumWord = medium.getShuffledWord(getMediumWord);

		}

		//System.out.println(shuffleThatMediumWord);
		//System.out.println("");

		while (shuffleThatHardWord == getHardWord) {

			shuffleThatHardWord = hard.getShuffledWord(getHardWord);

		}

		//System.out.println(shuffleThatHardWord);
		//System.out.println("");

	}

}
