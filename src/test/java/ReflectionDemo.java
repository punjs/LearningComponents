import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;

public class ReflectionDemo
{
    /* To understand this you need to uncomment and extend this class to GenericDTODemo* */

    @BeforeMethod
    public static void beforemehod(Method method)
    {
        System.out.println("The upcoming method for Execution is  " + method);

    }

}
