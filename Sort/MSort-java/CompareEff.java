package MSort;

import java.util.Arrays;

public class CompareEff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1[]=new int [100000];
		int num2[]=new int [100000];
		int num3[]=new int [100000];
		int num4[]=new int [100000];
		int num5[]=new int [100000];
		int num6[]=new int [100000];
		int num7[]=new int [100000];
		int temp=-1;
		for (int i = 0; i < num1.length; i++) {
			temp=(int) Math.round(Math.random()*500000);
			num1[i]=temp;
			num2[i]=temp;
			num3[i]=temp;
			num4[i]=temp;
			num5[i]=temp;
			num6[i]=temp;
			num7[i]=temp;
		}
		long start=System.currentTimeMillis();
		SortCol.InsertSort(num1, num1.length);
		long end=System.currentTimeMillis();
		System.out.println("InsertSort:"+(end-start)*1.0/1000+"s");
		
		start=System.currentTimeMillis();
		SortCol.ShellSort(num2, num2.length);
		end=System.currentTimeMillis();
		System.out.println("ShellSort:"+(end-start)*1.0/1000+"s");
		
		start=System.currentTimeMillis();
		SortCol.BubbleSort2(num3, num3.length);
		end=System.currentTimeMillis();
		System.out.println("BubbleSort:"+(end-start)*1.0/1000+"s");
		
		start=System.currentTimeMillis();
		SortCol.BinaryInsertSort(num4, num4.length);
		end=System.currentTimeMillis();
		System.out.println("BinaryInsertSort:"+(end-start)*1.0/1000+"s");
		
		start=System.currentTimeMillis();
		Arrays.sort(num5);
		end=System.currentTimeMillis();
		System.out.println("Array:Sort:"+(end-start)*1.0/1000+"s");
		
		start=System.currentTimeMillis();
		SortCol.QuickSort(num6,0,num6.length-1);
		end=System.currentTimeMillis();
		System.out.println("QucikSort:"+(end-start)*1.0/1000+"s");
		
		start=System.currentTimeMillis();
		SortCol.MergeSort(num7,0,num7.length-1);
		end=System.currentTimeMillis();
		System.out.println("MergeSort:"+(end-start)*1.0/1000+"s");
		
	    for (int i = 0; i < 10; i++) {
			System.out.print(num1[i]+"  ");
		}
	    System.out.println();
	    for (int i = 0; i < 10; i++) {
			System.out.print(num2[i]+"  ");
		}
	    System.out.println();
	    for (int i = 0; i < 10; i++) {
			System.out.print(num3[i]+"  ");
		}
	    System.out.println();
	    for (int i = 0; i < 10; i++) {
			System.out.print(num4[i]+"  ");
		}
	    System.out.println();
	    for (int i = 0; i < 10; i++) {
			System.out.print(num5[i]+"  ");
		}
	    System.out.println(); 
	    for (int i = 0; i < 10; i++) {
			System.out.print(num6[i]+"  ");
		}
	    System.out.println();
	    
	    for (int i = 0; i < 10; i++) {
			System.out.print(num7[i]+"  ");
		}
	    System.out.println();
	}

}
