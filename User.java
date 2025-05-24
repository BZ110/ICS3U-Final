
/**
 * Stores information for a user.
 *
 * Everything was created by Bashar Zain in this class.
 *
 * @author Bashar Zain
 * @version 1.0
 */
public class User
{
    /* The ID of the user. Used by the database.*/
    private int id;
    
    /* The username of the user. Used to sign in. */
    private String username;
    
    /* The password of the user. Used to sign in. May face cryptography. */
    private String password;
    
    /* The full name of the user. Part of the data returned when signed in. */
    private String fullName;
    
    /* The phone nmber of the user. Part of the data returned when signed in. */
    private String phoneNumber;
    
    /* The email of the user. Part of the data returned when signed in. */
    private String email;
    
    /**
     * Display the user information to console.
     */
    public void display(){
        System.out.println("ID: " + id);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Full Name: " + fullName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
    }
    /**
     * Returns the ID of the user.
     * 
     * @return The ID of the user.
     */
    public int getID(){
        return this.id;
    }
    
    /**
     * Returns the username of the user.
     * 
     * @return The username of the user.
     */
    public String getUsername(){
        return this.username;
    }
    
    /**
     * Returns the password of the user.
     * 
     * @return The password of the user.
     */
    public String getPassword(){
        return this.password;
    }
    
    /**
     * Returns the full name of the user.
     * 
     * @return The full name of the user.
     */
    public String getFullName(){
        return this.fullName;
    }
    
    /**
     * Returns the phone number of the user.
     * 
     * @return The phone number of the user.
     */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    /**
     * Returns the email of the user.
     * 
     * @return The email of the user.
     */
    public String getEmail(){
        return this.email;
    }
    
    /**
     * Set the ID of the user.
     * 
     * @param id The ID.
     */
    public void setID(int id){
        this.id = id;
    
    }
    
    /**
     * Set the username of the user.
     * 
     * @param username The username.
     */
    public void setUsername(String username){
        this.username = username;
    
    }
    
    /**
     * Set the password of the user.
     * 
     * @param password The password.
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    /**
     * Set the full name of the user.
     * 
     * @param fullName The full name.
     */
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    
    /**
     * Set the phone number of the user.
     * 
     * @param phoneNumber The phone number.
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Set the email of the user.
     * 
     * @param email The email.
     */
    public void setEmail(String email){
        this.email = email;
    }
    
}
