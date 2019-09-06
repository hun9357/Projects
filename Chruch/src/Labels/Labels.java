package Labels;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Labels {
	private JLabel l1,l2,l3,l4;
	private JTextField t1,t2,t3,t4;
	
	public void Label1(JFrame w)
	{
		l1 = new JLabel("Name");
		l1.setSize(100,30);
		l1.setLocation(600,25);
		w.add(l1);
		t1 = new JTextField(10);
		t1.setSize(100,30);
		t1.setLocation(600, 50); //50
		w.add(t1);
	}
	
	public void Label2(JFrame w)
	{
		l2 = new JLabel("Age");
		l2.setSize(100,30);
		l2.setLocation(600,80); 
		w.add(l2);
		t2 = new JTextField(10);
		t2.setSize(100,30);
		t2.setLocation(600, 105); //105
		w.add(t2);
	}
	
	public void Label3(JFrame w)
	{
		l3 = new JLabel("Address");
		l3.setSize(100,30);
		l3.setLocation(600,135);
		w.add(l3);
		t3 = new JTextField(10);
		t3.setSize(100,30);
		t3.setLocation(600, 160);
		w.add(t3);
	}
	
	public void Label4(JFrame w)
	{
		l4 = new JLabel("Phone # ");
		l4.setSize(100,30);
		l4.setLocation(600,190);
		w.add(l4);
		t4 = new JTextField(10);
		t4.setSize(100,30);
		t4.setLocation(600, 220);
		w.add(t4);
	}
}
