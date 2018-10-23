import java.util.ArrayList;
public class MyThread {
	private final static Object lock = new Object();
	private static int count = 100;
	private static ArrayList <Thread> threads = new ArrayList<Thread>();
	public static void main(String args[]) {
		for(int i = 0;i<5 ;i++) {
			final int k =i;
			threads.add(new Thread(new Runnable() {
				private int m =k;
				public void run() {
					while(count>0) {
						synchronized(lock) {
							if(count==0)
								return;
							System.out.println(m+1+" "+count);
							count--;
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}));
		}
		for(int i = 0;i<5;i++) {
			threads.get(i).start();
		}
		while(count!=0);
	}
}