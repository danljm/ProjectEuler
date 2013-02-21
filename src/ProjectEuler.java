import java.util.ArrayList;
import java.util.List;

public class ProjectEuler implements Runnable {
	
	public static void main (String [] args) {
		(new Thread(new ProjectEuler())).start();
	}

	@Override
	public void run() {
		eulerProblem6();		
	}
	
	private void eulerProblem1() {
		int sum = 0;
		
		for (int i = 1; i < 1000; ++i) {
			if (i % 3 == 0 || i % 5 == 0) { sum += i; }
		}
		
		System.out.println("sum: " + sum);
	}
	
	private void eulerProblem2() {
		List<Integer> fibonacci = new ArrayList<Integer>();
		int sum = 0;
		
		fibonacci.add(1);
		fibonacci.add(2);
		
		while (fibonacci.get(fibonacci.size() - 1) < 4000000) {
			
			if (fibonacci.get(fibonacci.size() - 1) % 2 == 0) {
				sum += fibonacci.get(fibonacci.size() - 1);
			}
			
			int nextValue = fibonacci.get(fibonacci.size() - 2) + fibonacci.get(fibonacci.size() - 1);
			fibonacci.add(nextValue);
		}
		
		System.out.println("sum: " + sum);
	}
	
	private void eulerProblem3() {
		
		long num = 600851475143L;	
		findSmallestFactor(num);
	}
	
	private int findSmallestFactor(final long num) {
		System.out.println("finding factor of " + num);
		int divisor = 0;
		
		for(int i = 2; i <= num; ++i) {
			
			//we have a factor
			if (num % i == 0) {
				divisor = i;
				break;
			}
		}
		
		//We have a prime
		if (divisor == num) {
			System.out.println("prime factor: " + divisor);
			return divisor;
		} else {
			System.out.println("divisor: " + divisor);
			return findSmallestFactor(num/divisor);
		}
	}
	
	private void eulerProblem4() {
		
		int largest = 0;
		
		for(int i = 999; i > 0; --i) {
			for(int j = 999; j > 0; --j) {
				
				Integer product = new Integer(i * j);
				System.out.println(product);

				if (product == Integer.reverse(product) && product > largest) { 
					largest = product;
				}				
			}
		}
		
		System.out.println("Largest Palendrome: " + largest);
	}
	
	private void eulerProblem5() {
		
	}
	
	private void eulerProblem6() {
		
		long difference = squareOfSums(100) - sumOfSquares(100);
		System.out.println("difference: " + difference);
	}
	
	private long sumOfSquares(final long num) {
		
		long sum = 0L;
		
		for (int i = 1; i <= num; ++i) {
			sum += square(i);
		}
		
		return sum;
	}
	
	private long squareOfSums(final long num) {
		
		long sum = 0L;
		
		for (int i = 1; i <= num; ++i) {
			sum += i;
		}
		
		return square(sum);
	}
	
	private long square(final long num) {
		return num * num;
	}
}
