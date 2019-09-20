import javax.swing.JOptionPane;

public class Search {
	int Lsearch(String arr[],String t) {
		int index = 0;
		for(int i = 0;i<arr.length;i++)
		{
			if(t.equals(arr[i]))
			{
				index = i;
			}
		}
		return index;
	}
	
	int Bsearch(String arr[],String t,int l, int r)
	{
		if(l>r)
		{
			
			return -1;
		}
		else
		{
			int mid = (l+r)/2;
			if(t.equals(arr[mid]))
			{
				return mid;
			}
			else if(t.compareTo(arr[mid])<0)
			{
				return Bsearch(arr,t,l,mid);
			}
			else
			{
				return Bsearch(arr,t,mid+1,r);
			}
		}
	}
}
