import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import CvsWrite.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Frame {
	private JTable table;
	private String[] columnNames = {"Name","Age","Address","Phone #"};
	private DefaultTableModel dm;
	private JScrollPane scroll;
	
	private JButton button1,button2,button3,button4,button5;
	private JLabel l1,l2,l3,l4;
	private JTextField t1,t2,t3,t4;
	
	
	private static Cvswrite w;
	Inven iv = new Inven();
	Center c = new Center();
	
	public Frame() throws IOException
	{
		//table frame fromat
		
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
		dm = new DefaultTableModel(iv.display(),columnNames);
		table.setModel(dm);
		scroll = new JScrollPane(table);
		scroll.setSize(500,450);
		scroll.setLocation(0,25);
		window.add(scroll);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(27);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		table.setRowHeight(50);
		c.align(table, l1, l2, l3, l4);//center align
		table.setFont(new Font("", Font.BOLD, 15));//set font

		//button1 
		button1 = new JButton("Search");
		button1.setSize(100,30);
		button1.setLocation(10, 550);
		button1.addActionListener(new Button1Clicked());
		window.add(button1);
		//Labels1
		l1 = new JLabel("Name");
		l1.setSize(100,30);
		l1.setLocation(600,25);
		window.add(l1);
		//Textbox1
		t1 = new JTextField(10);
		t1.setSize(100,30);
		t1.setLocation(600, 50); //50
		window.add(t1);
		
		//button2
		button2 = new JButton("Add");
		button2.setSize(100,30);
		button2.setLocation(125, 550);
		button2.addActionListener(new Button2Clicked());
		window.add(button2);
		//Label2
		l2 = new JLabel("Age");
		l2.setSize(100,30);
		l2.setLocation(600,80); 
		window.add(l2);
		//Textfield2
		t2 = new JTextField(10);
		t2.setSize(100,30);
		t2.setLocation(600, 105); //105
		window.add(t2);
		
		//button3
		button3 = new JButton("Delete");
		button3.setSize(100,30);
		button3.setLocation(240, 550);
		button3.addActionListener(new Button3Clicked());
		window.add(button3);
		//label3
		l3 = new JLabel("Address");
		l3.setSize(100,30);
		l3.setLocation(600,135);
		window.add(l3);
		//textfield3
		t3 = new JTextField(10);
		t3.setSize(100,30);
		t3.setLocation(600, 160);
		window.add(t3);
		
		//button4
		button4 = new JButton("Update");
		button4.setSize(100,30);
		button4.setLocation(355, 550);
		button4.addActionListener(new Button4Clicked());
		window.add(button4);
		//label4
		l4 = new JLabel("Phone # ");
		l4.setSize(100,30);
		l4.setLocation(600,190);
		window.add(l4);
		//textfield4
		t4 = new JTextField(10);
		t4.setSize(100,30);
		t4.setLocation(600, 220);
		window.add(t4);
		
		//button5
		button5 = new JButton("Refresh");
		button5.setSize(100,30);
		button5.setLocation(600, 400);
		button5.addActionListener(new Button5Clicked());
		window.add(button5);
		
		window.setVisible(true); //frame will appear in screen
	}
	private class Button1Clicked implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			try {
				dm.setDataVector(iv.search(t1.getText()),columnNames);//get data from external file and display on jtable
				dm.fireTableDataChanged();//refresh
				c.align(table, l1, l2, l3, l4);//center align
				table.getColumnModel().getColumn(0).setPreferredWidth(27);//set coulmn1 width = 27
				table.getColumnModel().getColumn(1).setPreferredWidth(15);//set col width = 15
				table.setRowHeight(50); //set table row height 50
				c.align(table, l1, l2, l3, l4);//align center
				table.setFont(new Font("", Font.BOLD, 15));//set font style and size
			}
			catch(IOException e1){
				e1.printStackTrace();
			}
		}
	}
	
	private class Button2Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				iv.add(t1.getText(), t2.getText(), t3.getText(), t4.getText());//call add function with 4 inputs
				dm.setDataVector(iv.display(), columnNames);
				dm.fireTableDataChanged();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				c.align(table, l1, l2, l3, l4);//Align text center
				table.getColumnModel().getColumn(0).setPreferredWidth(27);
				table.getColumnModel().getColumn(1).setPreferredWidth(15);
				table.setRowHeight(50);
				c.align(table, l1, l2, l3, l4);
				table.setFont(new Font("", Font.BOLD, 15));
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private class Button3Clicked implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			try {
				iv.delete(t1.getText()); //call delete function with one param
				dm.setDataVector(iv.display(), columnNames);
				dm.fireTableDataChanged();
				t1.setText("");
				c.align(table, l1, l2, l3, l4);//Align text center
				table.getColumnModel().getColumn(0).setPreferredWidth(27);
				table.getColumnModel().getColumn(1).setPreferredWidth(15);
				table.setRowHeight(50);
				c.align(table, l1, l2, l3, l4);
				table.setFont(new Font("", Font.BOLD, 15));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//
		}
	}
	private class Button4Clicked implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			try {
				iv.update(t1.getText(),t2.getText(),t3.getText(),t4.getText()); //call update function with 4 inputs
				dm.setDataVector(iv.display(), columnNames);
				dm.fireTableDataChanged();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				c.align(table, l1, l2, l3, l4);//Align text center
				table.getColumnModel().getColumn(0).setPreferredWidth(27);
				table.getColumnModel().getColumn(1).setPreferredWidth(15);
				table.setRowHeight(50);
				c.align(table, l1, l2, l3, l4);
				table.setFont(new Font("", Font.BOLD, 15));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//
		}
	}
	private class Button5Clicked implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			try {
				dm.setDataVector(iv.refresh(), columnNames); //call refresh function
				dm.fireTableDataChanged();
				c.align(table, l1, l2, l3, l4);//Align text center
				table.getColumnModel().getColumn(0).setPreferredWidth(27);
				table.getColumnModel().getColumn(1).setPreferredWidth(15);
				table.setRowHeight(50);
				c.align(table, l1, l2, l3, l4);
				table.setFont(new Font("", Font.BOLD, 15));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//check the file is exist or not
		File path = new File("C:/Users/home/Desktop/list.csv");
		boolean isExist = path.exists();
		w = new Cvswrite();
		w.Write(isExist);
		
		new Frame();//call frame function
		
		
	}
	class Inven{

		//import data to table frame
		public Object[][] display() throws IOException
		{
			Msort m = new Msort();
			BufferedReader bufferReader = new BufferedReader(new FileReader("C:/Users/home/Desktop/list.csv"));
			String input;
			int count = 0;
			//count amount of variables in external file
			while((input = bufferReader.readLine())!=null)
			{
				count++;
			}
			Object[][] obj = new Object[count][4];
			Object[][] cp = new Object[count][4];
			String[] sort = new String[count];
			String[] org = new String[count];
			int index = 0;
			BufferedReader br = null;
			String split = ","; //declare split string 
			
			int y = 0;
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/home/Desktop/list.csv"),"MS949"));
				while((input = br.readLine())!= null)
				{
					String[]temp = input.split(split);
					obj[y][0] = temp[0];
					obj[y][1] = temp[1];
					obj[y][2] = temp[2];
					obj[y][3] = temp[3];
					sort[index] = temp[0];
					org[index] = temp[0];
					index++;
					y++;
					temp = null;
				}
				Search s = new Search();
				m.mergesort(sort, 0, sort.length-1);
				for(int i = 0;i<count;i++)
				{
					String t = sort[i];
					int found = s.Lsearch(org, t);
					cp[i][0] = obj[found][0]; 
					cp[i][1] = obj[found][1]; 
					cp[i][2] = obj[found][2]; 
					cp[i][3] = obj[found][3]; 
				}
				
				obj = null;
			}catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			br.close();
			return cp;
		}
		public Object[][] search(String f1) throws IOException
		{
			Object [][] temp = display();
			Object[][] out = new Object[1][4];
			String [] list=new String[temp.length];
			for(int i = 0;i<temp.length;i++)
			{
				list[i] = (String) temp[i][0];
			}
			Search s = new Search();
			int ind = s.Bsearch(list, f1, 0, list.length-1);
			out[0][0] = temp[ind][0];
			out[0][1] = temp[ind][1];
			out[0][2] = temp[ind][2];
			out[0][3] = temp[ind][3];
			
			return out;
			
		}
		public void add(String f1,String f2,String f3, String f4) throws IOException {
			String input = f1+","+f2+","+f3+","+f4+"\n";
			String csvFileName = "C:/Users/home/Desktop/list.csv";
			try {
			if(f1.isEmpty()||f2.isEmpty()||f3.isEmpty()||f4.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please fill out all the inputs");
			}
			else
			{
					FileWriter cvsWriter = new FileWriter(csvFileName,true);
					cvsWriter.write(input);
					cvsWriter.close();
			}
			}catch(FileNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		
		public void delete(String f1) throws IOException
		{
			if(f1.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please fill out all the inputs");
			}
			else
			{
				Object[][] temp = display();
				Object[][] cp = new Object[temp.length-1][4];
				String [] name = new String[temp.length];
				for(int i = 0;i<temp.length;i++)
				{
					name[i] = (String) temp[i][0];
					
				}
				//binary search!
				Search m = new Search();
				int ind = m.Bsearch(name, f1, 0, name.length-1);
				int c=0;
				for(int i = 0;i<name.length;i++)
				{
					if(i==ind)
					{
						continue;
					}
					else
					{
						cp[c][0]=temp[i][0];
						cp[c][1]=temp[i][1];
						cp[c][2]=temp[i][2];
						cp[c][3]=temp[i][3];
						c++;
					}
					
				}
				temp = null;	
				w.Owrite(cp);
			}
		}
		public void update(String f1,String f2,String f3,String f4) throws IOException
		{
			if(f1.isEmpty()||f2.isEmpty()||f3.isEmpty()||f4.isEmpty())
			{	
				if(f1.isEmpty()&&f2.isEmpty()&&f3.isEmpty()&&f4.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please fill out all the inputs");
				}
				else if(f1.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter name");
				}
				else if(f2.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter Age");
				}
				else if(f3.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter Address");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Enter Please Enter Phone number");
				}
				
			}
			else
			{
				Object temp[][] = display();
			    String[] list = new String[temp.length];
			    for(int i = 0;i<temp.length;i++)
			    {
			    	list[i] = (String) temp[i][0];
			    }
			    Search s = new Search();
			    int ind = s.Bsearch(list, f1, 0, list.length-1);//found index
			    
			    
			    for(int i = 0;i<temp.length;i++)
			    {
			    	if(i==ind)
			    	{
			    		temp[i][0] = f1;
			    		temp[i][1] = f2;
			    		temp[i][2] = f3;
			    		temp[i][3] = f4;
			    		break;
			    	}
			    }
			    w.Owrite(temp);
			}
		}
		public Object[][] refresh() throws IOException
		{
			return display();
		}
		
		
	}
	
}
