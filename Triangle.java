import java.awt.Point;
import java.util.Arrays;
class Triangle {
	private Point a;
	private Point b;
	private Point c;
	Triangle()
	{
		a = new Point(0,0);
		b = new Point(1,1);
		c = new Point(1,0);
	}
	Triangle(int x[],int y[])
	{
		a = new Point(x[0],y[0]);
		b = new Point(x[1],y[1]);
		c = new Point(x[2],y[2]);
	}
	Boolean isTriangle(){
		double [] s;
		s = new double[3];
		s[0]=a.distance(b);
		s[1]=b.distance(c);
		s[2]=c.distance(a);
		Arrays.sort(s);
		if((s[0]+s[1])>s[2])
			return true;
		else
			return false;
	}
	double getarea()
	{
		double l1=a.distance(b),l2=b.distance(c),l3=c.distance(a);
		double p = (l1+l2+l3)/2;
		return Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
	}
}
