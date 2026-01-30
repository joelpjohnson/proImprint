package testngpkg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngDemo {
	@BeforeTest  //activities that have to be done b4 every test  eg: browser opening
	//@BeforeTest → Runs once before all test methods in a <test> tag
	public void setUp()
	{
		System.out.println("browser details");
	}
	@BeforeMethod //things to be done b4 individual test 
	//@BeforeMethod → Runs before every @Test method
	public void url()
	{
		System.out.println(" url loading");
	}
	
	@Test (priority =3) // test activites 
	public void test1()
	{
		System.out.println("test1");
	}
	@Test (priority =2 ,groups= {"smoke"})
	public void test2()
	{
		System.out.println("test2");
	}	@Test (priority =1,  groups={"sanity", "smoke"}) //enabled=false skips the test 
	public void test3()
	{
		System.out.println("test3");
	}@Test (priority=0,groups= {"regression"})
	public void test4()
	{ 
		System.out.println("test4");
	}
	@AfterMethod
	public void aftermthd()
	{
		System.out.println("after method");
	}
	
	@AfterTest
	public void teardown()
	{
		System.out.println("browser quit");
	}

}
