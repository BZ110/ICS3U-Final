import java.sql.*;

/**
 * Allows you to access User information using SQLite and SQLiteConnection.
 * 
 * Everything was created by Bashar Zain in this class.
 *
 * @author Bashar Zain
 * @version 1.0
 */
public class UserPortal extends SQLiteConnection
{
    /**
     * Get started on Users and helps us initialize the tables needed.
     * 
     * @param name The database name.
     */
    public UserPortal(String name){
        // Extends SQLiteConnection, pass name string.
        super(name);
        
        init();
        
        // Create the table, based on the class, what to save to the database.
        execute("CREATE TABLE IF NOT EXISTS users (" + 
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "username TEXT, " +
            "password TEXT, " +
            "full_name TEXT," +
            "phone_number TEXT, " +
            "email TEXT" +
            ");"
        ); 
        
        close();
    
    }
    
    /**
     * Get everything in the users table.
     * 
     * @return Array that has every user saved.
     */
    public User[] getEverything(){
        
        // First, declare the variable as null.
        User[] res = null;
        
        try {
            // Initialize the database
            init();
            
            // Identify the amount of users to create the set array.
            // https://www.w3schools.com/sql/sql_count.asp
            int amountOfUsers = execute("SELECT COUNT(*) AS rowcount FROM users;").getInt("rowcount");
            res = new User[amountOfUsers];
            
            // Select all from users, and make a user class for all of them.
            ResultSet rs = execute("SELECT * FROM users;");
            
            for(int i = 0; i < amountOfUsers; i++){
                // We can do this, because ResultSet pointers start at index before the first item.
                rs.next();
                
                // Create the user class for each item in the ResultSet, get the values.
                User user = new User();
                user.setID(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                res[i] = user;
            }
            close();
        } catch (Exception e){
            log("Unable to get everything: " + e);
        }
        
        return res;
    }
    
    /**
     * Get only by username in the users table.
     * Assuming only one username is allowed.
     * 
     * @param username The username you are fetching from the database.
     * @return The user class of that username.
     */
    public User getByUsername(String username){
        User user = new User();
        
        // Prevent SQL Injecion.
        if(username.contains("'")){
            log("Unable to execute with username: SQL-INJECT PREVENTION");
            return null;
        }
        
        try {
            init();
            // Get the user from the table.
            ResultSet rs = execute("SELECT * FROM users WHERE username = '" + username + "';");
            rs.next();
            
            user.setID(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPhoneNumber(rs.getString("phone_number"));
            user.setFullName(rs.getString("full_name"));
            user.setEmail(rs.getString("email"));
            close();
        } catch (Exception e){
            log("Unable to get user: " + e);
        }
        
        return user;
    }
    
    /**
     * Get only by ID in the users table.
     * Assuming only one ID is allowed.
     * 
     * @param id The ID you are fetching from the database.
     * @return The user class of that ID.
     */
    public User getByID(int id){
        User user = new User();
        
        try {
            init();
            // Get the user from the table.
            ResultSet rs = execute("SELECT * FROM users WHERE id = " + id + ";");
            rs.next();
            
            user.setID(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPhoneNumber(rs.getString("phone_number"));
            user.setFullName(rs.getString("full_name"));
            user.setEmail(rs.getString("email"));
            close();
        } catch (Exception e){
            log("Unable to get user: " + e);
        }
        
        return user;
    }
    
    /**
     * Add a user to the database.
     * 
     * @param user The user to add to the database.
     */
    public void addUser(User user){
        try {
            init();
            // Create a prepared statement here.
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO users (username, password, phone_number, full_name, email) VALUES (?, ?, ?, ?, ?);");

            // Set the values.
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setString(4, user.getFullName());
            stmt.setString(5, user.getEmail());
            
            // Execute the statement.
            stmt.executeUpdate();
            close();
        } catch (Exception e){
            log("Unable to save user: " + e);
        }
    }
    
    /**
     * Delete a user from the database.
     * 
     * @param user The user to delete from the database.
     */
    public void deleteUser(User user){
        try {
            init();
            // Create a prepared statement.
            // In practical situations, a unique identifier can be used to identify a user
            // We don't have that, so we use SQLite's AUTOINCREMENT as the UUID.
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM users WHERE id = ?");
            
            stmt.setInt(1, user.getID());
            stmt.executeUpdate();
            close();
        } catch (Exception e){
            log("Unable to delete user: " + e);
        }
    }
}
