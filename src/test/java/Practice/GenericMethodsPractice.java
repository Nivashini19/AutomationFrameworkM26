package Practice;

public class GenericMethodsPractice {

	public static void main(String[] args) //calling function
	{
		//hard coding
//		int a=20;
//		int b=30;
//		int c= a+b;
//		System.out.println(c);
		int sum=add(20,40);
		System.out.println(sum);
		System.out.println(add(sum,70));
		System.out.println(add(100,sum));


		int diff=sub(50,25);
		System.out.println(diff);
		System.out.println(sub(100,diff));
		System.out.println(sub(diff,75));
	}

	public static int add(int a,int b) //Called function - generic methods
	{
		int c = a+b;
		return c;
	}
	public static int sub(int x,int y)
	{
		int z = x-y;
		return z;
	}

}
