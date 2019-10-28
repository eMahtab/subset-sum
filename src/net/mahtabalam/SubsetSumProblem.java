package net.mahtabalam;

public class SubsetSumProblem {

	private boolean[][] dpTable;
	private int[] numbers;
	private int sum;

	public SubsetSumProblem(int[] numbers, int sum) {
		this.numbers = numbers;
		this.sum = sum;
		this.dpTable = new boolean[numbers.length + 1][sum + 1];
	}

	public void solveProblem() {

		for(int j=1; j <=this.sum; j++){ // if sum is not zero and subset is 0 -> no feasible solution
			this.dpTable[0][j] = false;
		}

		for (int i = 0; i <= this.numbers.length; i++) { // if sum is 0 then we can make the empty subset to make sum 0
			this.dpTable[i][0] = true;
		}

		for (int rowIndex = 1; rowIndex <= numbers.length; ++rowIndex) {
			for (int columnIndex = 1; columnIndex <= sum; ++columnIndex) {

				if (numbers[rowIndex - 1] > columnIndex  ) {
					this.dpTable[rowIndex][columnIndex] = this.dpTable[rowIndex - 1][columnIndex];
				} else {
					if (this.dpTable[rowIndex - 1][columnIndex]) {
						this.dpTable[rowIndex][columnIndex] = true;
					} else {
						this.dpTable[rowIndex][columnIndex] = this.dpTable[rowIndex - 1]
								[columnIndex - numbers[rowIndex - 1]];
					}
				}
			}
		}
	}

	public boolean hasSolution() {

		if (this.dpTable[numbers.length][sum]) {
			System.out.println("A subset with sum "+ sum + " exists.");
			return true;
		} else {
			System.out.println("No feasible solution");
			return false;
		}
	}

	public void printSolution() {

		int columnIndex = this.sum;
		int rowIndex = this.numbers.length;

		while (columnIndex > 0 || rowIndex > 0) {

			if (this.dpTable[rowIndex][columnIndex] == this.dpTable[rowIndex - 1][columnIndex]) {
				rowIndex = rowIndex - 1;
			} else {
				System.out.println("We include number: " + numbers[rowIndex - 1]);
				columnIndex = columnIndex - numbers[rowIndex - 1];
				rowIndex = rowIndex - 1;
			}
		}
	}
}
