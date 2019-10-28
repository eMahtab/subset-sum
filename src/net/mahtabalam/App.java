package net.mahtabalam;

public class App {

	public static void main(String[] args) {
		int[] numbers = { 5, 2, 1, 3 };
		int sum = 12;

		SubsetSumProblem subsetSumProblem = new SubsetSumProblem(numbers, sum);
		subsetSumProblem.solveProblem();
		if (subsetSumProblem.hasSolution()) {
			subsetSumProblem.printSolution();
		}
	}
}


