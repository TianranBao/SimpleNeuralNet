
public class NeuralNetwork {
	public int in, hn, on, guess;
	public Matrix w_ih, w_ho, b_ih, b_ho;
	NeuralNetwork(int inputN, int hiddenN, int outputN){
		in = inputN;
		hn = hiddenN;
		on = outputN;
		//declare and randomize weights for input and hidden layers
		w_ih = new Matrix(in, hn);
		w_ho = new Matrix(hn, on);
		w_ih.randomize();
		w_ho.randomize();
		//create bias matrices
		b_ih = new Matrix(1, hn);
		b_ho = new Matrix(1, on);
		b_ih.randomize();
		b_ho.randomize();
	}
	
	public Matrix feedforward(double[] input){
		Matrix inputMatrix = Matrix.fromArray(input);//inputs 
		Matrix hWeighted = new Matrix(w_ih.rows, inputMatrix.cols);//hidden layer weighted

		hWeighted = inputMatrix.multiply(w_ih);
		hWeighted = hWeighted.add(b_ih);
		hWeighted= hWeighted.actSig();
		
		Matrix oWeighted = new Matrix(w_ho.rows, hWeighted.cols);//output layer weighted
		oWeighted = hWeighted.multiply(w_ho);
		oWeighted = oWeighted.add(b_ho);
		oWeighted= oWeighted.actSig();
		
		return oWeighted;
	}
	
	public void train(double[] inputs, double[] targetsArr) {
		Matrix output = this.feedforward(inputs);
		Matrix targets = new Matrix(1, targetsArr.length);
		Matrix error = new Matrix(1, targetsArr.length);
		targets = Matrix.fromArray(targetsArr);
		
		error = output.subtract(targets);
	}
}
