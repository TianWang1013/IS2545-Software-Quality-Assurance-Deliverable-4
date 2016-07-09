package test;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class BillifyTest {
	
	
	public Billify billify;		
	
	@Before
	public void initialize() {
	   billify = new Billify();
	}	
	
	private Random random = new Random();

//	 generate an array with random size from 1 to 100 (include 1 and 100)
//	 values with integers from 1 - 100 only (include 1 and 100)
	private int[] generateArray() {
		int len = random.nextInt(3) + 1;
		int[] array = new int[len];
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(1) + 1;
		}		
		return array;
	}

//	 ------------------------------------------------------------------------------
//	 1. Property Test: Square Check
//	 ------------------------------------------------------------------------------
//	 Test the value, except the sum value in the output array is always the square of the input
	@Test
	public void squareTest() {
//		 generate 100 arrays
//		 run the test for 100 times
		for(int i = 0; i < 100; i++) {
			int[] arr = generateArray();
			int[] billifyarr = billify.generateBillify(arr);		
			for(int j = 0; j < billifyarr.length - 1; j++) {
				assertEquals(billifyarr[j], arr[j] * arr[j]);
			}
		}
	}
	
	
	
//	 ------------------------------------------------------------------------------
//	 2. Property Test: Output Array Size Is Larger Than Input Array Size
//	 ------------------------------------------------------------------------------
//	 Test the length of output array is larger than the length of input array by one

	@Test
	public void sizeLargerByOneTest() {
//		 generate 100 arrays
//		 run the test for 100 times
		for(int i = 0; i < 100; i++) {
			int[] arr = generateArray();
			int[] billifyarr = billify.generateBillify(arr);
			if(billifyarr.length != (arr.length + 1)) {
				fail();
			}
		}
	}
	
	
//	 ------------------------------------------------------------------------------
//	 3. Property Test: Sum Value Is The Largest
//	 ------------------------------------------------------------------------------
//	 Test the sum value in the output array is always larger than the other values
	@Test
	public void sumIsLargestTest() {
//		 generate 100 arrays
//		 run the test for 100 times
		for(int i = 0; i < 100; i++) {
			int[] arr = generateArray();
			int[] billifyarr = billify.generateBillify(arr);		
			for(int j = 0; j < arr.length; j++) {
				if(billifyarr[j] > billifyarr[arr.length]) {
					fail();
				}
			}
		}
	}
}