import java.lang.reflect.Array;
import java.lang.Math;

public class Matrix {

	public int rows, cols; 
	public double matrix[][];
	
	Matrix(int row, int col){ // initializes matrix 	
		rows = row;
		cols = col;
		matrix = new double[rows][cols];
		for(int i = 0; i < rows; i++) { 
			for(int j = 0; j < cols; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	
	public static Matrix fromArray(double[] array){ //turns array into 1 * x matrix 
		Matrix newM = new Matrix(1, array.length);
		for(int i = 0; i < array.length; i++) {
			newM.matrix[0][i] = array[i];
		}
		return newM;
	}
	
	public void randomize() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				double rand = (Math.random() * 1) + 0;
				matrix[i][j] = rand;
			}
		}
	}
	
	public Matrix add(Matrix m2){
		Matrix output = new Matrix(this.rows, this.cols);
		
		if(this.rows == m2.rows && this.cols == m2.cols) {
			for(int i = 0; i < output.rows; i++) {
				for(int j = 0; j < output.cols; j++) {
					output.matrix[i][j] = matrix[i][j] + m2.matrix[i][j];
				}
			}
			return output;
		}
		else {
			System.out.println("error: cannot add two matricies of different dimensions");
			return null;
		}
	}
	
	public Matrix subtract(Matrix m2){
		Matrix output = new Matrix(this.rows, this.cols);
		
		if(this.rows == m2.rows && this.cols == m2.cols) {
			for(int i = 0; i < output.rows; i++) {
				for(int j = 0; j < output.cols; j++) {
					output.matrix[i][j] = matrix[i][j] - m2.matrix[i][j];
				}
			}
			return output;
		}
		else {
			System.out.println("error: cannot subtract two matricies of different dimensions");
			return null;
		}
	}
	
	public Matrix multiply(Matrix m2){
		Matrix output = new Matrix(rows, m2.cols);
		if(this.cols == m2.rows) {
			for(int i = 0; i < output.rows; i++) {
				double product = 0; 
				for(int j = 0; j < output.cols; j++) {
					for(int k = 0; k < output.cols; k++) {
						product += matrix[i][k] * m2.matrix[k][0]; //set to 0 as all inputs will be x rows by 1 column 
					}
					output.matrix[i][j] = product;
				}
			}
			this.rows = output.matrix.length;
			this.cols = output.matrix[0].length; 
			return output;
		}
		else {
			System.out.println("error: matrix multiplication mismatch");
			return null;
		}
	}
	
	public Matrix actSig(){
		Matrix output = new Matrix(this.rows, this.cols);
		output.matrix = this.matrix;
		for(int i = 0; i < output.rows; i++) {
			for(int j = 0; j < output.cols; j++) {
				double x = 0, denominator = 0; 
				x = output.matrix[i][j];
				denominator = 1 + Math.pow(Math.E , -x) ;
				x = 1/denominator;
				output.matrix[i][j] = x;
			}
		}			
		return output; 
	}
}
