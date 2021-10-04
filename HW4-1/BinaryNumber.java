import java.util.Arrays;

public class BinaryNumber {
	
	private int data[];
	boolean overFlow;
	
	public BinaryNumber(int length) {
		
		data = new int[length];
		
		for (int i = 0; i < length; i++) {
			
			data[i] = 0;
		
		}
	}
	
	public BinaryNumber(String str) {
		
		data = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			
			int ch = Character.getNumericValue(str.charAt(i));
			
			if (ch != 0 && ch != 1) {
				
				System.out.print("Must enter a binary number");
				
			}else {
				
				data[i] = Character.getNumericValue(str.charAt(i));
			
			}
		}
				
		
	}
	
	public int getLength() {
		
		return data.length;
	
	}
	
	public int getDigit(int index){
		
		if (index >= data.length || index < 0){
			
			System.out.print("Index is out of bounds.");
			return index;
			
		}else {
			
			for (int i = 0; i < data.length; i++) {
				
				if (index == i) {
					
					return data[i];
					
				}	
			}
		}
		
		return index;
	}
	
	
	public void shiftR(int amount) {

		if (amount < 0) {
			
			System.out.print("Must enter a positive integer.");
		
		}else {


			int[] shifted = new int[data.length + amount];

			for (int i = 0; i < shifted.length;i++) {

				if (i < amount) {

					shifted[i] = 0;

				}else {

					shifted[i] = data[i - amount];
				}

			}

			data = shifted;

		}
	}
	
	public int toDecimal() {
		
		int sum = 0;
		int[] data1 = data;
		
		if (overFlow) {
			
			data1 = Arrays.copyOf(data, data.length+1);
			data1[data1.length-1] = 1;
			
		}
		
		for (int i = 0; i < data1.length; i++) {
			
			sum += data1[i]*(Math.pow(2, i));
			
		}
		
		System.out.print(sum);
		return sum;
		
		
	}
	
	public void add(BinaryNumber aBinaryNumber) {
		
		if (aBinaryNumber.getLength() != data.length) {
			
			System.out.print("Lengths of binary numbers do not coincide.");
			
		}else {
			
			int carriedDigit = 0;
			int temp = 0;
			
			for (int i = 0; i < data.length; i++) {
				
				temp = data[i] + aBinaryNumber.getDigit(i) + carriedDigit;
				if (temp > 1) {
					
					carriedDigit = 1;
					
					if (temp == 2) {
						
						data[i] = 0;
						
					} else if(temp == 3){
						
						data[i] = 1;
						
					}
				}else {
					
					data[i] = temp;
					
				}
				
			}
			
			if (carriedDigit >= 1) {
				
				overFlow = true;
				
			}
			
		}
		
	}
	
	public String toString() {
		
		
		String result = "";
		for (int i = 0; i < data.length; i++) {
			
			result += data[i];
			
		}
		
		if (overFlow) {
			
			return "Overflow";
		
		}
		else {
			return result;
		}
	}
	
	public void clearOverflow() {
		
		overFlow = false;
		
	}
	
	public static void main(String args[]) {
		
		BinaryNumber bina = new BinaryNumber("1011");
		System.out.print(bina);
		
		
		
		
		
	}
	
}
