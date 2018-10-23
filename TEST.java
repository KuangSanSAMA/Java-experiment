import java.util.Scanner;
public class TEST {
	public static void main(String args[])
	{
		int [] x,y;
		x = new int[3];
		y = new int[3];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<3;i++){
			System.out.printf("Please input the "+(i+1)+ " Point:");
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		Triangle t = new Triangle(x,y);
		if(t.isTriangle()){
			System.out.println("The triangle's area is "+t.getarea());
			
		}
		else{
			System.out.println("This is not a Triangle");
		}
	}

}
