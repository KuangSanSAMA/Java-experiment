
public class ComputeTime 
{
	public static void main(String[] args) 
	{
		String classname = args[0];
		int a = Integer.valueOf(args[1]);
		int b = Integer.valueOf(args[2]);
		int c = Integer.valueOf(args[3]);
		Common t;
		try {
			t = (Common) Class.forName(classname).newInstance();
			double result = t.computeTime(a, b, c);
			System.out.println(result);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
