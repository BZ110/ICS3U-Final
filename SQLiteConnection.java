import java.sql.*;
/**
 * Allows you to easily access SQLite.
 *
 * Everything was created by Bashar Zain in this class.
 *
 * @author Bashar Zain
 * @version 1.0
 */
public class SQLiteConnection
{
    /* The database name. */
    private String name;
    
    /* The database URL. */
    private String url;
    
    /* The connection for the database. */
    Connection conn;
    
    /**
     * Easy logging system to ensure a prefix.
     * 
     * @param text The text you want to log.
     */
    public void log(String text){
        System.out.println("SQLiteConnection > " + text);
    }
    
    /**
     * Default constructor for SQLiteConnection.
     * Set the necessary variables to get started.
     * 
     * @param name The name of the database.
     */
    public SQLiteConnection(String name){
        if(name == null){
            log("Name of the database can't be invalid.");
            return;
        }
        
        this.name = name;
        this.url = "jdbc:sqlite:" + name + ".db";
        
    }
    
    /**
     * Initialize the database.
     */
    public void init(){
        try {
            conn = DriverManager.getConnection(this.url);
        } catch (Exception e) {
            log("Unable to start database: " + e);
        }
    }
    
    /**
     * Close the database.
     */
    public void close(){
        try {
            conn.close();
        } catch (Exception e) {
            log("Unable to close database: " + e);
        }
    }
    
    /**
     * Execute an SQL String while the database is open.
     * 
     * @param sql The SQL string you would like to execute.
     * @return ResultSet containing the result. 
     */
    public ResultSet execute(String sql){
        // Define an empty ResultSet. (or null)
        ResultSet result = null;
        
        try {
            // Prepare a statement to execute.
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            // Statements can execute as an Update or a Query
            // If it is a SELECT statement, it is a query. You are "querying" the database.
            // If it is anything else, most likely it is an update. You are "updating" the database.
            if(sql.trim().toUpperCase().startsWith("SELECT")){
                result = stmt.executeQuery();
            } else {
                stmt.executeUpdate();
            }
        } catch (Exception e){
            log("Unable to execute SQL code: " + e);
        }
        return result;
    }
    
    /**
     * Get the connection for the database.
     * 
     * @return The connection for the database.
     */
    public Connection getConnection(){
        return conn;
    }
}
