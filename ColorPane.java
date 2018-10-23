import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
public class ColorPane extends JFrame implements ActionListener{
	private boolean flag = false;
	int cnt = 1;
	JButton jbuttons [];
	boolean flagList []={false,false,false,false,false,false,false,false,false}; 
	JButton buttons [];
	String colorText [] = {"blue","cyan","green","magenta","orange","pink","red","white","yellow"};
	Color colorful [] = {Color.blue,Color.cyan,Color.green,Color.magenta,Color.orange,Color.pink,Color.red,Color.white,Color.yellow};
	ColorPane(){
		super("ColorPane");
		final Color colorBefore = (new JButton()).getBackground();
		final String colortext1 [] = {"blue","cyan","green","magenta","pink","red","white","yellow"};
		final Color colors1 [] ={Color.blue,Color.cyan,Color.green,Color.magenta,Color.pink,Color.red,Color.white,Color.yellow};
		//final 
		buttons = new JButton [colorText.length];
		getContentPane().setLayout(new GridLayout(3,3));
		for(int i =0;i<colorText.length;i++) {
			buttons[i] = new JButton(colorText[i]);
			buttons[i].addActionListener(this);
			getContentPane().add(buttons[i]);
		}
		jbuttons = new JButton[colorText.length-1];
		jbuttons[0] = buttons[0];
		jbuttons[1] = buttons[1];
		jbuttons[2] = buttons[2];
		jbuttons[3] = buttons[5];
		jbuttons[4] = buttons[8];
		jbuttons[5] = buttons[7];
		jbuttons[6] = buttons[6];
		jbuttons[7] = buttons[3];
		KeyListener handler = new KeyAdapter(){
				 public void keyPressed(KeyEvent e){
					flag = false;
					if (e.getKeyCode() == KeyEvent.VK_SPACE){
				 		if(test()){
				 			flag = true;
				 		Thread thread = new Thread(){
				 			public void run(){
				 				while(flag){
				 					try {
				 						Thread.sleep(500);
				 					} catch (InterruptedException e) {
				 						// TODO Auto-generated catch block
				 						e.printStackTrace();
				 					}
				 				for(int i =0;i<jbuttons.length;i++){
				 					int k = (i-cnt+jbuttons.length)%jbuttons.length;

				 					jbuttons[i].setText(colortext1[k]);
				 					jbuttons[i].setBackground(colors1[k]);
				 				}
				 				cnt=(cnt+1)%jbuttons.length;
				 				}
				 			}
				 		};
				 		thread.start();
				 		}
				 	}
				 	if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
				 		for(int i = 0; i< colorText.length;i++){
				 			buttons[i].setBackground(colorBefore);
				 			flagList[i]=false;
				 		}
				 	}
				 }
			};
		for(int i = 0;i<colorText.length;i++){
			buttons[i].addKeyListener(handler);
		}
		setSize(400,400);
		setVisible(true);
		}
	public void actionPerformed(ActionEvent e) {
		String temp = e.getActionCommand();
		int j = Arrays.binarySearch(colorText,temp);
		((JButton) e.getSource()).setBackground(colorful[j]);
		JButton b=(JButton)e.getSource();
		int k=0;
		for(int i =0;i<buttons.length;i++){
			if(buttons[i].equals(b))
				k=i;
		}
		flagList[k]=true;
	}
	public boolean test(){
		for(int i=0;i<flagList.length;i++){
			if(!flagList[i])
				return false;
		}
		return true;
	}
	public static void main(String args[]) {
		ColorPane colorpane = new ColorPane();
		colorpane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
