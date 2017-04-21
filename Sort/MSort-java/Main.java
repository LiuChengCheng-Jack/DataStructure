package MSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num[]={1,3,2,6,7,4};
        int num2[]={1,3,2,6,7,4,2};
        int num3[]={8,1,2,3,4,5,9};
        int num4[]={8,1,2,6,4,5,5,9};
        int num5[]={8,1,2,6,4,5,5};
        int num6[]={8,1,2,6,4,5,5,33,22,1,67,78,4};
        SortCol.BinaryInsertSort(num, 6);
        SortCol.BubbleSort(num2, 7);
        SortCol.BubbleSort2(num3, 7);
        SortCol.InsertSort(num4, 8);
        SortCol.ChooseSort(num5, num5.length);
        SortCol.ShellSort(num6, num6.length);
        for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
        System.out.println();
        for (int i = 0; i < num2.length; i++) {
        	System.out.print(num2[i]+" ");
		}
        System.out.println();
        for (int i = 0; i < num3.length; i++) {
        	System.out.print(num3[i]+" ");
		}
        System.out.println();
        for (int i = 0; i < num4.length; i++) {
        	System.out.print(num4[i]+" ");
		}
        System.out.println();
        for (int i = 0; i < num5.length; i++) {
        	System.out.print(num5[i]+" ");
		}
        System.out.println();
        
        for (int i = 0; i < num6.length; i++) {
        	System.out.print(num6[i]+" ");
		}
        System.out.println();
	}

}
