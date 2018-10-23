import java.awt.Point;
public class newtriangle {
	public static void main(String args[]) {
		Point a = new Point(0,1);
		Point b = new Point(1,1);
		Point c = new Point(0,0);
		double l1 = a.distance(b),l2=b.distance(c),l3=c.distance(a);
		double p = (l1+l2+l3)/2;
		double area = Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
		System.out.println(area);
	}
}
