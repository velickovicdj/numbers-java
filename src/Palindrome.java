import java.util.*;

public class Palindrome {
	private int[] numbers;
	public Palindrome(int[] nuumbers) {
		numbers = nuumbers;
	}
	public String[] integersToStrings() {
		String[] strings = new String[numbers.length];
		
		for(int i=0; i<numbers.length; i++) {
			strings[i] = Integer.toString(numbers[i]);
		}
		return strings;
	}
	public int[] stringsToIntegers(String[] strings) {
		int[] numbers = new int[strings.length];
		
		for(int i=0; i<strings.length; i++) {
			numbers[i] = Integer.parseInt(strings[i]);
		}
		return numbers;
	}
	public String[][] palindromes(String[] numbers) {
		int numOfPalins = 0;
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(int i=0; i<numbers.length; i ++) {
			int lo = 0;
			int hi = numbers[i].length()-1;
			
			if(Integer.parseInt(numbers[i])<10) {
				numOfPalins++;
				palindromes.add(numbers[i]);
			}
			while(hi>lo) {
				if(numbers[i].charAt(lo++) == numbers[i].charAt(hi--)) {
					numOfPalins++;
					palindromes.add(numbers[i]);
				}
			}
		}
		return new String[][] {palindromes.toArray(new String[palindromes.size()]), {Integer.toString(numOfPalins)}};
		
	}
}
