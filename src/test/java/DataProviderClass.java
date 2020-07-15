import org.testng.annotations.DataProvider;

public class DataProviderClass
{

    @DataProvider(name = "dp1")
    public Object[][] getdata()
    {
        // Array [][] arr = new Array[2][2]; Understanding Array to define Object data type array
        Object[][] data = new Object[3][2];

        data[0][0] = "Test 00";
        data[0][1] = "Test 01 ";
        data[1][0] = "Test 10";
        data[1][1] = "Test 11 ";
        data[2][0] = "Test 20";
        data[2][1] = "Test 21";

        return data;
    }

}
