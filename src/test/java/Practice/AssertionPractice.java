package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void hardAssert()  //mostly used - static methods
	{
		System.out.println("HardAssert step1");
		System.out.println("HardAssert step2");
		Assert.assertTrue(false);
		System.out.println("HardAssert step3");
		System.out.println("HardAssert step4");
	}
	@Test
	public void softAssert() //Non static methods
	{
		System.out.println("softAssert case1");
		System.out.println("softAssert case2");
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(false);
		System.out.println("softAssert case3");
		System.out.println("softAssert case4");
		sa.assertAll();
	}

}
