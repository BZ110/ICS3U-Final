
/**
 * A test to use the User Portal.
 * 
 * @author Bashar Zain
 */
public class Test
{
    public static void main(String args[]){
        UserPortal portal = new UserPortal("TEST2");
        
        User user = new User();
 
        user.setUsername("john_doe");
        user.setPassword("12345678");
        user.setPhoneNumber("1234567890");
        user.setFullName("John Doe");
        user.setEmail("john_doe@gmail.com");
        
        user.display();
        portal.addUser(user);
        
        User newUser = portal.getByUsername("john_doe");
        
        newUser.display();
        
        portal.deleteUser(newUser);
        portal.getByUsername("john_doe");
    }
}
