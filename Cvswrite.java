package CvsWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;



public class Cvswrite {
	public void Write(boolean b) throws IOException
	{
		try {
		if(b == true)
		{
			System.out.println("File exists");
		}
		else
		{	
			
			String csvFileName = "C:/Users/home/Desktop/list.csv";
			//String header = "이름,나이,주소,전화번호";
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(csvFileName),"MS949")
			);
			//writer.write(header);
			writer.close();
		}
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public void Owrite(Object [][] o) throws IOException
	{
		try {
			String csvFileName = "C:/Users/home/Desktop/list.csv";
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(csvFileName),"MS949")
			);
			String temp;
			for(int i = 0;i<o.length;i++)
			{
					temp = o[i][0]+","+o[i][1]+","+o[i][2]+","+o[i][3]+","+"\r\n";
					writer.append(temp);
			}
			
			
			writer.close();
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
