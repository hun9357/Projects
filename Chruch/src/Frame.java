import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import Labels.*;


public class Frame {
	private JTable table;
	private String[] columnNames = {"Name","Age","Address","Phone #"};
	private Object[][] data = {{"","","",""}};
	private DefaultTableModel dm;
	private JScrollPane scroll;
	
	
	
	private JLabel l1,l2,l3,l4;
	private JTextField t1,t2,t3,t4;
	
	private Labels l;
	private Buttons b;
	
	
	public Frame()
	{
		final int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 700;
		JFrame window = new JFrame("Έν΄ά");
		window.setResizable(true); //user can resize frame
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //set Frame size
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close window
		window.setLocationRelativeTo(null); //set frame location in middle 
		
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - window.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - window.getHeight()) / 2);
		window.setLocation(x, y); 		
		window.setLayout(null);
		
		table = new JTable();
		dm = new DefaultTableModel(data,columnNames);
		table.setModel(dm);
		scroll = new JScrollPane(table);
		scroll.setSize(500,450);
		scroll.setLocation(0,25);
		window.add(scroll);
		
		b= new Buttons();
		b.Button1(window);
		b.Button2(window);
		b.Button3(window);
		b.Button4(window);
		
		
		l = new Labels();
		l.Label1(window);
		l.Label2(window);
		l.Label3(window);
		l.Label4(window);
		
		window.setVisible(true); //frame will appear in screen
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Frame();
	}

}
