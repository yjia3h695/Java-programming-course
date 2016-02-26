import java.util.Random;
 
public class Assignment2b { 
 
private static Random random = new Random(System.currentTimeMillis()); 
 
public static void main(String[] args) { 
 int[] myArray = createRandomArray(20);
 int[] revmyArray = new int[myArray.length];
 System.out.print("The old array is ");
 for (int i=0;i<myArray.length;i++){
	 revmyArray[i]=myArray[myArray.length- i - 1];
	 System.out.print(myArray[i] + ", ");
	  }
 System.out.print("The new array is ");
 for (int i=0;i<myArray.length;i++){
 System.out.print(+revmyArray[i] + ", "); 
} 
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