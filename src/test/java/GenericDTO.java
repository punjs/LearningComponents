
public class GenericDTO
{
    private String FirstName;

    private String LastName;

    private int age;

    public String getFirstName()
    {
        return FirstName;
    }

    public void setFirstName(String firstName)
    {
        FirstName = firstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public void setLastName(String lastName)
    {
        LastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    GenericDTO(String FirstName, String LastName, int age)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.age = age;
    }

}
