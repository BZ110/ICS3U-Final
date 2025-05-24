
/**
 * A test to use the Listing Portal.
 * 
 * @author Bashar Zain
 */
public class Test2
{
    public static void main(String[] args){
        ListingPortal portal = new ListingPortal("TEST2");
        
        Listing listing = new Listing();
 
        listing.setName("John Doe's Shirt");
        listing.setPublisherID(10);
        listing.setPublisherName("John Doe");
        listing.setDate("00-00-0000");
        listing.setType("Accessories");
        listing.setCost(10.99);
        listing.setConditionLevel(5);
        listing.setMaterials("100% Polyester");
        listing.setCO2Offset(10.32);
        listing.setDescription("A cool shirt!");
        listing.setSize("XXL");
        listing.setWeight(2.2);
        
        listing.display();
        portal.addListing(listing);
        
        Listing newListing = portal.getByID(1);
        System.out.println("\n\n\nSHIRT IN DB");
        newListing.display();
    }
}
