package emailapp;

public class EmailApp{

    public static void main(String [] args)
    {
        Email someOne = new Email("firstName" , "lastName");

        System.out.println(someOne.showInto());
    }

}
