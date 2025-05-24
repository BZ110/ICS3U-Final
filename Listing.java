
/**
 * Stores information for a listing.
 *
 * Everything was created by Bashar Zain in this class.
 *
 * @author Bashar Zain
 * @version 1.0
 */
public class Listing
{
    /* The ID of the listing. Used by the database. */
    private int id;
    
    /* The name of the listing. */
    private String name;
    
    /* The publisher's name of the listing. */
    private String publisherName;
    
    /* The publisher's ID of the listing. */
    private int publisherID;
    
    /* The date of the listing. */
    private String date;
    
    /* The type of listing. */
    private String type;
    
    /* The cost of item in the listing. */
    private double cost;
    
    /* The condition level of the item in the listing. */
    private int conditionLevel;
    
    /* The materials used for the item of the listing. */
    private String materials;
    
    /* The CO2 Offset when purchasing the item in the listing. */
    private double co2Offset;
    
    /* The description of the listing. */
    private String description;
    
    /* The size of the item in the listing. */
    private String size;
    
    /* The weight of the item. */
    private double weight;
    
    /**
     * Display the user information to console.
     */
    public void display(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Publisher Name: " + publisherName);
        System.out.println("Publisher ID: " + publisherID);
        System.out.println("Date: " + date);
        System.out.println("Type: " + type);
        System.out.println("Cost: " + cost);
        System.out.println("Condition Level: " + conditionLevel);
        System.out.println("Materials: " + materials);
        System.out.println("CO2 Offset: " + co2Offset);
        System.out.println("Description: " + description);
        System.out.println("Size: " + size);
        System.out.println("Weight: " + weight);
    }
    
    /**
     * Get the ID.
     * 
     * @return The ID of the listing.
     */
    public int getID(){
        return this.id;
    }
    
    /**
     * Get the name.
     * 
     * @return The name of the listing.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Get the publisher.
     * 
     * @return The publisher of the listing.
     */
    public String getPublisherName(){
        return this.publisherName;
    }
    
    /**
     * Get the publisher's ID.
     * 
     * @return The publisher ID for the listing.
     */
    public int getPublisherID(){
        return this.publisherID;
    }
    
    /**
     * Get the date.
     * 
     * @return The date of the listing.
     */
    public String getDate(){
        return this.date;
    }
    
    /**
     * Get the type.
     * 
     * @return The type of listing.
     */
    public String getType(){
        return this.type;
    }
    
    /**
     * Get the cost.
     * 
     * @return The cost of the listing.
     */
    public double getCost(){
        return this.cost;
    }
    
    /**
     * Get the condition level.
     * 
     * @return The condition level of the item for the listing.
     */
    public int getConditionLevel(){
        return this.conditionLevel;
    }
    
    /**
     * Get the materials.
     * 
     * @return The materials of item for the listing.
     */
    public String getMaterials(){
        return this.materials;
    }
    
    /**
     * Get the CO2 Offset.
     * 
     * @return The CO2 Offset when purchasing the item, of the listing.
     */
    public double getCO2Offset(){
        return this.co2Offset;
    }
    
    /**
     * Get the description.
     * 
     * @return The description of the listing.
     */
    public String getDescription(){
        return this.description;
    }
    
    /**
     * Get the size.
     * 
     * @return The size of the item in the listing.
     */
    public String getSize(){
        return this.size;
    }
    
    /**
     * Get the weight.
     * 
     * @return The weight of the item in the listing.
     */
    public double getWeight(){
        return this.weight;
    }
    
    /**
     * Get the worded condition level.
     * 
     * @return The worded condition level of the listing.
     */
    public String getWordedConditionLevel(){
        String result;
        
        // See if the conditional level is 0 - The worst / 10 - The best. Give a string based on that.
        switch(conditionLevel){
            case 0:
                result = "Horrible";
            break;
            
            case 1:
                result = "Very Bad";
            break;
            
            case 2:
                result = "Bad";
            break;
            
            case 3:
                result = "Mediocre";
            break;
            
            case 4:
                result = "Okay";
            break;
            
            case 5:
                result = "Okay";
            break;
            
            case 6:
                result = "Okay";
            break;
            
            case 7:
                result = "Good";
            break;
            
            case 8:
                result = "Very Good";
            break;
            
            case 9:
                result = "Almost Perfect";
            break;
            
            case 10:
                result = "Perfect";
            break;
            
            // The condition may not be set. As a fallback, set it to Okay.
            default:
                result = "Okay";
            break;
        }
        
        return result;
    }
    
    /**
     * Set the ID of the listing.
     * 
     * @param id The ID.
     */
    public void setID(int id){
        this.id = id;
    }
    
    
    /**
     * Set the name of the listing.
     * 
     * @param name The Name.
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Set the publisher's name of the listing.
     * 
     * @param publisherName The Publisher's name.
     */
    public void setPublisherName(String publisherName){
        this.publisherName = publisherName;
    }
    
    /**
     * Set the publisher's ID of the listing.
     * 
     * @param publisherID The Publisher's ID.
     */
    public void setPublisherID(int publisherID){
        this.publisherID = publisherID;
    }
    
    /**
     * Set the date of the listing.
     * 
     * @param date The date.
     */
    public void setDate(String date){
        this.date = date;
    }
    
    /**
     * Set the type of the listing.
     * 
     * @param type The type.
     */
    public void setType(String type){
        this.type = type;
    }
    
    /**
     * Set the cost of the listing. In CAD.
     * 
     * @param cost The cost.
     */
    public void setCost(double cost){
        this.cost = cost;
    }
    
    /**
     * Set the condition level of the item in the listing.
     * 
     * @param conditionLevel The condition level.
     */
    public void setConditionLevel(int conditionLevel){
        this.conditionLevel = conditionLevel;
    }
    
    /**
     * Set the materials of the item in the listing.
     * 
     * @param materials The materials.
     */
    public void setMaterials(String materials){
        this.materials = materials;
    }
    
    /**
     * Set the CO2 Offset of the listing. In grams.
     * 
     * @param co2Offset The CO2 Offset.
     */
    public void setCO2Offset(double co2Offset){
        this.co2Offset = co2Offset;
    }
    
    /**
     * Set the description of the listing.
     * 
     * @param description The description.
     */
    public void setDescription(String description){
        this.description = description;
    }
    
    /**
     * Set the size of the item in the listing.
     * 
     * @param size The size.
     */
    public void setSize(String size){
        this.size = size;
    }
    
    /**
     * Set the weight of the item in the listing. In grams.
     * 
     * @param weight The weight.
     */
    public void setWeight(double weight){
        this.weight = weight;
    }
}
