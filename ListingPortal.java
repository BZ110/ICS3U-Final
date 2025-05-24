import java.sql.*;
/**
 * Allows you to access Listing information using SQLite and SQLiteConnection.
 *
 * Everything was created by Bashar Zain in this class.
 *
 * @author Bashar Zain
 * @version 1.0
 */
public class ListingPortal extends SQLiteConnection
{
    /**
     * Get started on listings and helps us initialize the tables needed.
     * 
     * @param name The database name.
     */
    public ListingPortal(String name){
        // Extends SQLiteConnection, pass name string.
        super(name);
        
        init();
        
        // Create the table, based on the class, what to save to the database.
        execute("CREATE TABLE IF NOT EXISTS listings (" + 
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT, " +
            "publisher_id INT," +
            "publisher_name TEXT," +
            "date TEXT, " +
            "type TEXT, " +
            "cost DECIMAL(10, 2), " +
            "condition_level INT, " +
            "materials TEXT, " +
            "co2_offset DECIMAL(10, 2), " +
            "description TEXT, " +
            "size TEXT, " +
            "weight DECIMAL(10, 2)" +
            ");"
        ); 
        
        close();
    
    }
    
    /**
     * Get everything in the listings table.
     * 
     * @return Array that has every listing saved.
     */
    public Listing[] getEverything(){
        
        // First, declare the variable as null.
        Listing[] res = null;
        
        try {
            // Initialize the database
            init();
            
            // Identify the amount of listings to create the set array.
            // https://www.w3schools.com/sql/sql_count.asp
            int amountOfListings = execute("SELECT COUNT(*) AS rowcount FROM listings;").getInt("rowcount");
            
            res = new Listing[amountOfListings];
            
            // Select all from listings, and make a listing class for all of them.
            ResultSet rs = execute("SELECT * FROM listings;");
            for(int i = 0; i < amountOfListings; i++){
                // We can do this, because ResultSet pointers start at index before the first item.
                rs.next();
                
                // Create the listing class for each item in the ResultSet, get the values.
                Listing listing = new Listing();
                listing.setID(rs.getInt("id"));
                listing.setName(rs.getString("name"));
                listing.setPublisherID(rs.getInt("publisher_id"));
                listing.setPublisherName(rs.getString("publisher_name"));
                listing.setDate(rs.getString("date"));
                listing.setType(rs.getString("type"));
                listing.setCost(rs.getBigDecimal("cost").doubleValue()); // We must first get a BigDecimal Class, and use the doubleValue conversion.
                listing.setConditionLevel(rs.getInt("condition_level"));
                listing.setMaterials(rs.getString("materials"));
                listing.setCO2Offset(rs.getBigDecimal("co2_offset").doubleValue());
                listing.setDescription(rs.getString("description"));
                listing.setSize(rs.getString("size"));
                listing.setWeight(rs.getBigDecimal("weight").doubleValue());
                
                res[i] = listing;
            }
            close();
        } catch (Exception e){
            log("Unable to get everything: " + e);
        }
        
        return res;
    }
    

    /**
     * Get only by ID in the listings table.
     * Assuming only one ID is allowed.
     * 
     * @param id The ID you are fetching from the database.
     * @return The listing class of that ID.
     */
    public Listing getByID(int id){
        Listing listing = new Listing();
        
        try {
            init();
            // Get the listing from the table.
            ResultSet rs = execute("SELECT * FROM listings WHERE id = " + id + ";");
            rs.next();
            
            listing.setID(rs.getInt("id"));
            listing.setName(rs.getString("name"));
            listing.setPublisherID(rs.getInt("publisher_id"));
            listing.setPublisherName(rs.getString("publisher_name"));
            listing.setDate(rs.getString("date"));
            listing.setType(rs.getString("type"));
            listing.setCost(rs.getBigDecimal("cost").doubleValue()); // We must first get a BigDecimal Class, and use the doubleValue conversion.
            listing.setConditionLevel(rs.getInt("condition_level"));
            listing.setMaterials(rs.getString("materials"));
            listing.setCO2Offset(rs.getBigDecimal("co2_offset").doubleValue());
            listing.setDescription(rs.getString("description"));
            listing.setSize(rs.getString("size"));
            listing.setWeight(rs.getBigDecimal("weight").doubleValue());
            close();
        } catch (Exception e){
            log("Unable to get listing: " + e);
        }
        
        return listing;
    }
    
    /**
     * Add a listing to the database.
     * 
     * @param listing The listing to add to the database.
     */
    public void addListing(Listing listing){
        try {
            init();
            // Create a prepared statement here.
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO listings (name, publisher_id, publisher_name, date, type, cost, condition_level, materials, co2_offset, description, size, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            // Set the values.
            stmt.setString(1, listing.getName());
            stmt.setInt(2, listing.getPublisherID());
            stmt.setString(3, listing.getPublisherName());
            stmt.setString(4, listing.getDate());
            stmt.setString(5, listing.getType());
            stmt.setDouble(6, listing.getCost());
            stmt.setInt(7, listing.getConditionLevel());
            stmt.setString(8, listing.getMaterials());
            stmt.setDouble(9, listing.getCO2Offset());
            stmt.setString(10, listing.getDescription());
            stmt.setString(11, listing.getSize());
            stmt.setDouble(12, listing.getWeight());

            // Execute the statement.
            stmt.executeUpdate();
            close();
        } catch (Exception e){
            log("Unable to save listing: " + e);
        }
    }
    
    /**
     * Delete a listing from the database.
     * 
     * @param listing The listing to delete from the database.
     */
    public void deleteListing(Listing listing){
        try {
            init();
            
            // Create a prepared statement.
            // Delete by the ID of the listing, since it is the unique identifier of it.
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM listings WHERE id = ?");
            
            stmt.setInt(1, listing.getID());
            stmt.executeUpdate();
            close();
        } catch (Exception e){
            log("Unable to delete listing: " + e);
        }
    }
}
