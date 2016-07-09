package test;



public class Billify {

	// public static void main(String[] args){
	// 	int[] x = {1,1,1};
	// 	Billify billify = new Billify();
	// 	int[] y = billify.generateBillify(x);
	// 	for(int value:y){
	// 		System.out.println(value);
	// 	}
	// }

	public int[] generateBillify(int[] x) {	
		int sum = 0;
		int[] y = new int[x.length + 1];
		for (int i = 0; i < x.length; i++) {
			y[i] = (int) Math.pow(x[i], 2);
			sum += y[i];
		}
		y[x.length] = sum;
		return y;
	}

}
