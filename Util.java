package automationTest;




import java.util.*;


public class Util {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Random r = new Random();
		int rand =r.nextInt(10);
		System.out.println(rand);
		System.out.println(randomString(rand));
		

	}
	public static String randomString(int n)
	{
		String result="";
		Random r = new Random();
		for(int i=0;i<n;i++)
		{
			char ch= (char)(97+r.nextInt(27));
			result+=ch;
		}
	 return result;
	}
	
}
