/***************************
*  Checking for Divisible by Nth number 
*
*
*    - num%n = 0
*    - part of end of year problems
*
*
*
*****************************/
import java.util.ArrayList;
class Divisibility {
	long num;
	public long SMALLEST = 1000500000l;
	public long BIGGEST  = 9999599990l;

	public Divisibility(){
		num = 9900000000l;

	}

	public long getNum() {return num;}
	public void setNum(long number) {num = Math.abs(number);}





	/*
	*	take (num % 10 ^n) / 10 ^ n-1
	* 	where n is the place
	*/
	public static int getDigit(long number, int n) throws IndexOutOfBoundsException {
		int place = length(number) - n + 1;
		if (place > length(number) || place < 1) {
			throw new IndexOutOfBoundsException("Asked for a nonsensical place");
		} else {
			int digit = (int)(number % (long)(Math.pow(10, place)));
			digit /= Math.pow(10, place - 1);
			return digit;
		}

	} 

	/* no number given implies use the current num */
	public int getDigit(int n){ return getDigit(num, n);}

	/***
	*
	* Checks if each digit is unique
	*
	*/

	

	public boolean hasUniqueDigits(long num) {
		long number = num;

		//Always 10 for digits 0-10
		boolean[] digits = new boolean[10];
		// go through each digit
			for (int i = 0; i < length(number); i++) {
				//find digit corresponding value;
				int val = getDigit(num, i + 1);
				if (!digits[val]) {
					digits[val] = true;
				} else {
					return false;
				}
			}
			return true;
	}

	/*
	*	Finds nums that satisfy known rules
	*	10th place = 0
	*	5th place = 5
	*	4th place =/=4
	* 	has unique digits
	*	even places are even
	*	odd places odd
	*	
	*/
	public ArrayList findNums() {
		ArrayList<Long> numbers = new ArrayList<Long>();
		long start = 100000000l;
		long end   = 1000000000l;
		for (long i = start; i < end; i++) {
			//	  ends in 10         and 5th place is 5	   and  4th place isn't 4
			if ( (0 == getDigit(i, 10)) &&  (5 == getDigit(i, 5)) && (4 != getDigit(i, 4)) ) {
				if (hasEvenEvens(i) && hasOddOdds(i)) {
					if (hasUniqueDigits(i)){
						numbers.add(Long.valueOf(i));
					}
				}
			}
		}


		return numbers;
	}









	public static int length(long number){
		String testStr = Long.toString(Math.abs((int) number));
		return testStr.length();
	}

	public static boolean hasEvenEvens(long number) {
		for (int i = 2; i <= length(number); i += 2) {
			if ( (getDigit(number, i) % 2) == 1) {
				return false;
			}
		}
		return true;
	}
	public static boolean hasOddOdds(long number) {
		for (int i = 1; i <= length(number); i +=2) {
			if ( (getDigit(number, i) %2) == 0) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		long n = Long.parseLong(args[0]);
		Divisibility test = new Divisibility();
		test.setNum(n);
	
		System.out.println(test.findNums());
		
	}

}
