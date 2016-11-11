class DerangementsOfN {
	int n; //length of set
	int[] referenceSet; //set [0, 1, ..., n - 1]

	public DerangementsOfN(int setLength) {
		// object wide set length
		n = setLength;
		// fill reference set with elements matching indices
		referenceSet = new int[n];
		for (int i = 0; i < n; i++) {
			referenceSet[i] = i;
		}
		



	}





	public boolean isDeranged(int[] set){
		for (int i = 0; i < set.length; i++) {
			if (i == set[i]) {return false;}
		}
		return true;
	}

	public static void printArray(int[] nums) {
		/**converts array of numbers to a string*/
		if (nums.length == 0) {System.out.println();}
		String result = "[";
		for (int i = 0 ; i < nums.length ; i++ ) {
			if (i == nums.length - 1) {
				result += nums[i] + "]";
			} else {
				result += nums[i] + ", ";
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		int length = Integer.parseInt(args[0]);
		new DerangementsOfN(length);
	}
}