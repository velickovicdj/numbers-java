import java.util.*;

public class Program {	
	public static void numReverse(int[] numbers) {
		System.out.print("\nNumbers in reversed order: ");
		for(int i=numbers.length-1; i>=0; i--) {
			System.out.print(String.format("%d, ", numbers[i]));
		}
	}
	public static int largestPalinNum(int[] numbers) {
		int largest = largest(numbers);
		int largestPalinNum = 0;
		Palindrome palindrome = new Palindrome(numbers);
		int[] allPalins = palindrome.stringsToIntegers(palindrome.palindromes(palindrome.integersToStrings())[0]);
		
		Arrays.sort(allPalins);
		
		for(int i=0; i<allPalins.length; i++) {
			if(allPalins[i]<largest) {
				largestPalinNum = allPalins[i];
			}
		}
		
		return largestPalinNum;
	}
	public static int numOfPalinNums(int[] numbers) { 
		Palindrome palindrome = new Palindrome(numbers);
		String[] numOfPalins = palindrome.palindromes(palindrome.integersToStrings())[1];
		
		return Integer.parseInt(numOfPalins[0]);
	}
	public static int sumAllNum(int[] numbers) {
		int result = 0;
		
		for(int i=0; i<numbers.length; i++) {
			result+=numbers[i];
		}
		return result;
	}
	public static String median(int[] numbers) {	
		double result;
		
		if(numbers.length % 2 == 0) {
			int sumMidNums = numbers[numbers.length/2]+numbers[numbers.length/2-1];
			result = ((double) sumMidNums)/2;
		}else {
			return Integer.toString(numbers[numbers.length/2]);
		}
		return Double.toString(result);
	}
	public static double stdDev(int[] numbers) {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numbers.length;

        for(double num : numbers) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: numbers) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
	}
	public static String average(int[] numbers) { 
		double sum = 0.0;
		
		for(int i=0; i<numbers.length; i++) {
			sum = sum + numbers[i];
		}
		if(sum%numbers.length%2 == 0) {
			return Double.toString(Math.round(sum/numbers.length));
		}
		return Double.toString(sum/(double)numbers.length);
	}
	public static String secondSmallest(int[] numbers) {
		if(numbers.length<2) {
		    return "There is only one number.";
		}
		Arrays.sort(numbers);
		
		return Integer.toString(numbers[1]);
	}
	public static int largest(int[] numbers) {
		int num = numbers[0];
		
		for(int i=1; i<numbers.length; i++) {
			if(num<numbers[i]) {
				num = numbers[i];
			}
		}
		return num;
	}
	public static String numMaxOcc(int[] numbers, int x) {
		int maxCount = 1;
		int result = numbers[0];
		int currCount = 1;
		
		if(numbers.length<2) {
			return "There is only one number.";
		}
		
		for(int i=1; i<x; i++) {
			if(numbers[i] == numbers[i-1]) {
				currCount++;
			}else {
				if(currCount>maxCount) {
					maxCount = currCount;
					result = numbers[i-1];
				}
				currCount =1;
			}
		}
		if(currCount>maxCount) {
			maxCount = currCount;
			result = numbers[x-1];
		}
		return Integer.toString(result);
	}
	public static void numRepetition(int[] numbers) {
		int[] tmp = new int[numbers.length];
		for(int i=0; i<numbers.length; i++) {
			tmp[i] = numbers[i];
		}
		for(int i=0; i<tmp.length; i++) { 
	         if(tmp[i]>0){
	            int repeatNumber = 1; 
	            for (int j=i+1; j<tmp.length; j++) { 
	                if(tmp[i] == tmp[j]) {  
	                      tmp[j]=tmp[j]*(-1);
	                      repeatNumber++; 
	                } 
	            } 
	            System.out.print("\nFrequency of repetition for " +tmp[i]+ ": "+(float)(((float)repeatNumber/(float)tmp.length)*(float)100)+"%. "); 
	          }
	    } 
	}
	public static void numEvenOdd(int[] numbers) {
		int even = 0;
		int odd = 0;
		
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] % 2 == 0) {
				even++;
			}else {
				odd++; 
			}
		}
		System.out.print("\nNumber of even numbers: " +even);
		System.out.print("\nNumber of odd numbers: " +odd);
	}
	public static String numOfDiff(int[] numbers) {
		if(numbers.length<2) {
		    return "There is only one number."; 
		}
	    int cnt = 0;

	    ArrayList<Integer> diffNum = new ArrayList<>();

	    for(int i=0; i<numbers.length; i++) {
	        if(!diffNum.contains(numbers[i])) {
	            diffNum.add(numbers[i]);
	        }
	    }
	    
	    cnt = diffNum.size();
	    
	    return Integer.toString(cnt);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many numbers do you want to store? ");
		System.out.print("\n\t: ");
		int n = scan.nextInt();
		System.out.print("\n");
		
		final int[] numbers = new int[n];
								
		for(int i=0; i<n; i++) {
			switch(i) {
				case 0: 
					System.out.print("Enter the 1st number: ");
					break;
				case 1: 
					System.out.print("Enter the 2nd number: ");
					break;
				case 2:
					System.out.print("Enter the 3rd number: ");
					break;
				default:
					System.out.print(String.format("Enter the %dth number: ", i+1));
						
			}
			numbers[i] = scan.nextInt();
		}
		
		final int[] numbers1 = new int[n];
		
		for(int i=0; i<n; i++) {
			numbers1[i] = numbers[i]; 
		}
		
		System.out.print("\n\n");
		System.out.print("Number of elements: " +numbers.length);
		System.out.print("\nNumber of different numbers: " +numOfDiff(numbers));
		numEvenOdd(numbers);
		numRepetition(numbers);
		System.out.print("\nThe number with the maximum occurence: " +numMaxOcc(numbers, numbers.length));
		System.out.print("\nLargest number: " +largest(numbers));
		System.out.print("\nSecond smallest number: " +secondSmallest(numbers));
		System.out.print("\nThe average of all numbers: " +average(numbers));
		System.out.print("\nStandard deviation: " +stdDev(numbers));
		System.out.print("\nMedian: " +median(numbers1));
		System.out.print("\nSum of all numbers: " +sumAllNum(numbers));
		System.out.print("\nNumber of palindromic number numbers: " +numOfPalinNums(numbers));
		System.out.print("\nLargest palindromic number, that is smaller than the greatest number in the list: " +largestPalinNum(numbers));
		numReverse(numbers1);
	}
}
