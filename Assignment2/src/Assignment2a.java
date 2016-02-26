import java.util.Random;
 
public class Assignment2a { 
 
private static Random random = new Random(System.currentTimeMillis()); 
 
public static void main(String[] args) { 
 int[] myArray = createRandomArray(20);
 int sum=0;
 for (int i=0;i<myArray.length;i++){
	 System.out.print(myArray[i] + ", ");
	 sum=sum+myArray[i];
 }
 System.out.println("The sum is " + sum);
} 

private static int[] createRandomArray(int length) { 
	if (length <= 0) { 
		throw new IllegalArgumentException( 
    "Array length cannot be zero or below!"); 
    } 
 
int[] myArray = new int[length]; 
for (int i = 0; i < length; i++) { 
	myArray[i] = Math.abs(random.nextInt() % 5); 
    } 
 
return myArray; 
}  
} 