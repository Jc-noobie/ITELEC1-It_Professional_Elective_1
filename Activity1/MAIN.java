import java.util.Scanner;
public class MAIN {

	public static void main(String[] args) {

		/* 
		 * This is a pretty useless program however it shows 
		 *  the different answers if we apply the order of precedence 
		 * */
		
		Scanner scan = new Scanner(System.in) ;
		
		int num1;
		int num2 = 2, num3 = 10;
		int answer ; 
		
		System.out.print("Enter a number : " ) ;
		num1 = scan.nextInt() ;
		
		if(num1 >= 5 ) {
			answer = (num2 + num3 ) * num1 ;
		} else if (num1 <= 5) {
			answer = num2 - (num3 * num1 ) ; 
		} else {
			answer = (num2 * num1) / num3;
		}
		
		System.out.println("The answer is : " + answer) ;

	}

}
