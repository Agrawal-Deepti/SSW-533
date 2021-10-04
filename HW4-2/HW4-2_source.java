public class hw2_Paris {

	
	public static void method1(int n) {
		int counter = 0;
		
		for(int i = 0; i < n;i++) {
			
			for(int j = 0; j < n;j++) {
				
				System.out.println("Operation " + counter);
				counter++;
			}
		}
		
	}
	
	public static void method2(int n) {
		int counter = 0;
		
		for(int i = 0; i < n;i++) {
			
			for(int j = 0; j < n;j++) {
				
				for(int k = 0; k < n; k++) {
					
					System.out.println("Operation " + counter);	
					counter++;
				
				}
			}
		}
	}
	
	public static void method3(int n) {
		
		int counter = 0;
		
		for(int i = 1; i < n; i *= 2) {
			
				System.out.println("Operation " + counter);
				counter++;
			
		}
		
		
	}
	
	public static void method4(int n) {
		
		int counter = 0;
		for(int i = 0; i < n; i++) {
			
			for(int k = 1; k < n; k *= 2) {
			
				System.out.println("Operation " + counter);
				counter++;
			
			}
		
		}
		
	}
	
	public static void method5(int n) {

		int counter = 0;

		for(int i = 2; i < n; i *= i) {

			System.out.println("Operation " + counter);
			counter++;

		}


	}
	
	public static int method6(int n) {
		
		if (n == 0) {
			return -1;
		}else {
			int count = 1 + method6(n-1);
			System.out.println("Operation " + count);
			return count;
		}
		
	}
			
	
}
