import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

public class OwnerAPIDemo
{

    public static ConfigProperties config = null;

    @Test
    public void test1()
    {
        config = ConfigFactory.create(ConfigProperties.class);
        System.out.println(config.getbasePath());
    }

}
