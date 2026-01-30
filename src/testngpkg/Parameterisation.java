package testngpkg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterisation {
	@Parameters("tool")
@Test
public void  test1(String tool)
{
	//to print values stored in xml 
	System.out.println("the tool i used is "+tool);
	
	
}

}
