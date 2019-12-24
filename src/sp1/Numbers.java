package sp1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Numbers {
	static List<Integer> myGuess = new ArrayList<Integer>();
	static int attempts;
	static List<Integer> allNumbers = new ArrayList<Integer>();
	static List<Integer> data = new LinkedList<Integer>();
	static int overview[] = new int[8];

	public static void main(String[] args) {

		myGuess.add(8);
		myGuess.add(13);
		myGuess.add(15);
		myGuess.add(27);
		myGuess.add(30);
		myGuess.add(33);
		myGuess.add(34);

		attempts = 0;
		List<Integer> result = new ArrayList<Integer>();
        int oldValue=0;
        long start = System.currentTimeMillis();
		while (attempts <5000000) {
			result.clear();
			result.addAll(draw(attempts));

			overview[checkRow(myGuess, result)]++;
			if (overview[7] > oldValue) {
			System.out.println("Yes I got all right in attempt " + attempts + " so I just have to wait "
					+ attempts / 52 + " years before I become a millionare on Lotto");
			oldValue=oldValue+1;
			}
		}
		System.out.println("0:" + overview[0] + " 1:" + overview[1] + " 2:" + overview[2] + " 3:" + overview[3] + " 4:"
				+ overview[4] + " 5:" + overview[5] + " 6:" + overview[6] + " 7:" + overview[7]);
		
		long slut = System.currentTimeMillis();
		System.out.println("It took " + (slut - start) + " ms " + "to scan " + attempts + " attempts");	
	}

	private static List<Integer> draw(int cnt) {
		//Comment Got to write something

		attempts++;

		allNumbers.clear();
		data.clear();
		for (int i = 1; i < 36; i++) {
			allNumbers.add(i);
		}
		Random r = new Random();
		int number;

		for (int i = 0; i < 7; i++) {
			number = r.nextInt(35 - i);
			data.add(allNumbers.get(number));
			allNumbers.remove(number);

		}

		Collections.sort(data);
//		System.out.println(data.toString());
		return data;
	}

	private static int checkRow(List<Integer> myGuess, List<Integer> result) {
		int sum = 0;
		for (Integer i : myGuess) {
			for (Integer j : result) {
				if (j.equals(i)) {
					sum = sum + 1;
				}
			}
		}
		return sum;
	}
}