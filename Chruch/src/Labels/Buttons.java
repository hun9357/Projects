package Labels;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Buttons {
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	public void Button1(JFrame window) {
		// TODO Auto-generated method stub
		button1 = new JButton("Search");
		button1.setSize(100,30);
		button1.setLocation(10, 550);
		window.add(button1);
	}
	
	public void Button2(JFrame window){
		button2 = new JButton("Add");
		button2.setSize(100,30);
		button2.setLocation(125, 550);
		window.add(button2);
	}
	public void Button3(JFrame window){
		button3 = new JButton("Delete");
		button3.setSize(100,30);
		button3.setLocation(240, 550);
		window.add(button3);
	}
	public void Button4(JFrame window){
		button4 = new JButton("Update");
		button4.setSize(100,30);
		button4.setLocation(355, 550);
		window.add(button4);
	}
	
	
}
