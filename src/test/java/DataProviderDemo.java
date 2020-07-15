import org.testng.annotations.Test;

public class DataProviderDemo
{

    @Test(dataProvider = "dp1", dataProviderClass = DataProviderClass.class)
    public void dpdemo(String s1, String s2)
    {
        System.out.println("Value of s1   " + s1 + "   Value of s2 " + s2);
    }

}
