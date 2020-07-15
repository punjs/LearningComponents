import org.testng.annotations.Test;

public class GenericDTODemo // extends ReflectionDemo
/*
 * The above commented code extends ReflectionDemo is for showing the capabilty of reflection with ReflectionDemo.java*
 */
{

    @Test
    public void learndto()
    {
        GenericDTO g = new GenericDTO("sandeep", "Punj", 30);
        System.out.println(g.getAge());
        g.setFirstName("Sandeep");
        System.out.println(g.getFirstName());

    }
}
