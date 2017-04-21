package MSort;

public class SortCol {
     public static void BinaryInsertSort(int temp[],int length) {//折半插入排序
    	 int left,right,tem,mid;
		 for (int i = 1; i < length; i++) {
			left=0; right=i-1;
			mid=(left+right)/2;
			tem=temp[i];
			while(left<=right)
			{
				if (tem<temp[mid]) {
					right=mid-1;
				}
				else{
					left=mid+1;
				}
				mid=(left+right)/2;
			}
			for (int j = i-1; j >=left; j--) {
				temp[j+1]=temp[j];
			}
			temp[left]=tem;
		}
	}
     public static void BubbleSort(int temp[],int length) {
    	 int tt=-1;
    	 for (int i = 0; i < length-1; i++) {
			for (int j = 0; j < length-i-1; j++) {
				if (temp[j]>temp[j+1]) {
					tt=temp[j];
					temp[j]=temp[j+1];
					temp[j+1]=tt;
				}
			}
		}
     }
     public static void BubbleSort2(int temp[],int length) {//带标记的冒泡排序
    	 int tt=-1;
    	 boolean flag=false;
    	 for (int i = 0; i < length-1; i++) {
			for (int j = 0; j < length-i-1; j++) {
				if (temp[j]>temp[j+1]) {
					tt=temp[j];
					temp[j]=temp[j+1];
					temp[j+1]=tt;
					flag=true;
				}	
			}
			if (flag) {
				flag=false;
			}
			else {
				break;
			}
			
		}
     }
     
     public static void InsertSort(int temp[],int length) {//直接插入排序
    	 int tem=-1,trans=-1;
    	 for (int i =1; i <length; i++) {
			tem=temp[i];
			int j=i-1;
			while((j>=0)&&tem<temp[j])
			{		
				temp[j+1]=temp[j];
				j--;
			}
			temp[++j]=tem;
			
		}
     }
      public static void ChooseSort(int temp[],int length) {//选择排序
    	  int min=-1,count=-1,trans=-1;
    	  for (int i = 0; i < length-1; i++) {
    		min=  temp[i];
    		count=i;
			for (int j = i+1; j < length; j++) {
				if (temp[j]<min) {
					min=temp[j];
					count=j;
				}
			}
			if (count!=i) {
				trans=temp[i];
				temp[i]=min;
				temp[count]=trans;
			}
		}
     }
      public static void ShellSort(int temp[],int length) {
    	  int d=length/2;
    	  int tem=-1,i=-1;
    	  while(d>=1)
    	  {
    		  for (int k = 0; k < d; k++) {
				for (int j = k+d; j < length; j+=d) {
					tem=temp[j];
					i=j-d;
					while((i>=0)&&tem<temp[i])
					{
						temp[i+d]=temp[i];
						i-=d;
					}
					temp[i+d]=tem;
				}
			}
    		d=d/2;
    	  }
	}
      public static void QuickSort(int temp[],int low,int high)
      {
    	  int mid=0;
    	  if (high<=low) {
			return;
		}
    	else {
    		  mid=Partition(temp,low,high);
    		  QuickSort(temp, low, mid-1);
    		  QuickSort(temp, mid+1, high);
    	 }
      }
      
      public  static int Partition(int temp[],int low,int high) {//快速排序使用到的分割算法
		  int tem=temp[low];
		  while(low<high)
		  {
			  while((low<high)&&temp[high]>=tem)
			  {
				  high--;	  
			  }
			  temp[low]=temp[high];
			  while((low<high)&&temp[low]<=tem)
			  {
				  low++;	  
			  } 
			  temp[high]=temp[low];
		  }
		  temp[low]=tem;
    	  return low;
	}
     public static void MergeSort(int temp[],int start,int end)//end为后一个数的下标
     {
    	 if (start>=end) {
			return;
		}
    	 else {
			int mid=(start+end)/2;
			MergeSort(temp, start, mid);
			MergeSort(temp, mid+1, end);
			Merge(temp, start, mid, end);
		}
     }
     public static void Merge(int temp[],int start,int mid,int end)
     {
    	 int len1=mid-start+1;                                                
    	 int len2=end-mid;
    	 int leftT[]=new int[len1];
    	 int rightT[]=new int[len2];
    	 for (int i = 0; i <len1; i++) {
			leftT[i]=temp[start+i];
		}
    	 for (int j = 0; j< len2; j++) {
			rightT[j]=temp[mid+1+j];
		}
    	 int l=0,r=0,i=0;
    	 for (i = start; i < end; i++) {//合并两个序列
			if (l==len1||r==len2) {
				break;
			}
			if (leftT[l]<=rightT[r]) {
				temp[i]=leftT[l++];
			}
			else {
				temp[i]=rightT[r++];
			}
		}
    	 while(l<len1)
    	 {
    		 temp[i++]=leftT[l++];
    	 }
    	 while(r<len2)
    	 {
    		 temp[i++]=rightT[r++];
    	 }
    	 
     }
      public static int halfLook(int temp[],int length,int value)
      {
      	int left=0,right=length-1;
      	int mid=length/2;
      	int pos=-1;
      	while(left<=right){
      		if (temp[mid]==value) {
      			pos=mid;
  				break;
  			} 
      		else if (temp[mid]<value) {
  				left=mid+1;	
  			}
      		else {
  				right=mid-1;
  			}
      		mid=(left+right)/2;
      	}
      	return pos;
      }
}