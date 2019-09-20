
public class Msort {
	public void mergesort(String arr[],int l,int r)
	{
		if(l<r)
		{
			int mid = (l+r)/2;
			mergesort(arr,l,mid);
			mergesort(arr,mid+1,r);
			merge(arr,l,mid,r);
		}
	}
	public void merge(String arr[],int l,int mid, int r)
	{
		String [] temp = new String[arr.length];
		int i = l;
		int j = mid+1;
		int k = l;
		while(i<=mid && j<=r)
		{
			if(arr[i].compareTo(arr[j])<0)
			{
				temp[k++] = arr[i++];
			}
			else
			{
				temp[k++] = arr[j++];
			}
		}
		while(i<=mid)
		{
			temp[k++] = arr[i++];
		}
		while(j<=r)
		{
			temp[k++]=arr[j++];
		}
		for(int i1 = l;i1<k;i1++)
		{
			arr[i1] = temp[i1];
		}
	}
}
