
public class Main {

	public static void main(String[] args) {
		NeuralNetwork n1 = new NeuralNetwork(2, 2, 1);
		double[] inputA = {1, 2};
		n1.feedforward(inputA);
	}
}
