package execption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sum {
	public static void main(String args[]) {
		Scanner c = new Scanner(System.in);
		int sum = 0;
		int i =0;
		while(true) {
			try {
				i = test(c);
			}catch(InputMismatchException e) {
				c.nextLine();
				continue;
			}catch(MyException e1) {
				c.nextLine();
				continue;
			}
			if(i==999) {
				c.close();
				break;
			}
			sum+=i;
		}
		System.out.println(sum);
	}
	static int test(Scanner c) throws MyException{
		int i = c.nextInt();
		if(i<0) {
			throw new MyException(""+i+"是一个负数");
		}
		return i;
	}
}
class MyException extends Exception{
	MyException(String message) {
		super(message);
	}
}
