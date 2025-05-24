import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.lang.Integer;

/**
 * This shows a frame to a user with various fields where the user can enter information about their listing, allowing them to create the listing.
 *
 * @author Lakshmanan Ramanathan
 */

public class CreateProductPage extends JFrame{
    Homepage home;
    User user;
    
    /**
     * Creating a listing, requiring multiple fields.
     * 
     * @author Lakshmanan Ramanathan
     */
    public CreateProductPage(Homepage thisHome, int id, String state, User newUser) {
        home = thisHome;
        user = newUser;

        if(state.equals("New")) {  // Temporarily calling this New, we need to use ints latter this is a new creation and not an edit creation so checks the state of it
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setTitle("Create a New Listing");
            setSize(600, 800);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(); // Setting up a panel to occupy most of the frame so that we can add elements on to the panal then put the panel on the frame
            panel.setLayout(new GridBagLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);

            JLabel titleFill = new JLabel("Fill out the Following Feilds"); // Label title
            titleFill.setFont(new Font("Arial", Font.PLAIN, 24));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            panel.add(titleFill, gbc); // xx title

            JLabel titleAbout = new JLabel("About this Product"); // Label Subtitle
            titleAbout.setFont(new Font("Arial", Font.ITALIC, 18));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            panel.add(titleAbout, gbc); //xx subtitle

            JLabel listingTitleLabel = new JLabel("Enter your Listings Title:");
            listingTitleLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Listing Title Label
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(listingTitleLabel, gbc); // 00 label

            JTextField listingTitleField = new JTextField(15); // Listing field
            listingTitleField.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(listingTitleField, gbc);// 01 Field

            JLabel descriptionLabel = new JLabel("Enter a Short Description:"); // Label Description
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(descriptionLabel, gbc); // 10 label

            JTextField descriptionField = new JTextField(15); // Description field
            descriptionField.setFont(new Font("Arial", Font.PLAIN, 14));
            descriptionField.setColumns(40); // ASKED CHATGPT HOW TO MAKE A TEXT FEILD WIDER BUT CHOSE NOT TO DO THAT CAUSE IT WAS EXTEMLY COMPLEX AND MADE IT LONGER INSTEAD
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(descriptionField, gbc);// 11 Field

            JLabel listingPriceLabel = new JLabel("Item Price $"); // Label Price
            listingTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(listingPriceLabel, gbc);// 20 label

            JTextField listingPriceField = new JTextField(15); // Field Price
            listingPriceField.setFont(new Font("Arial", Font.BOLD, 14));
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.anchor = GridBagConstraints.EAST;
            listingPriceField.setColumns(5);
            panel.add(listingPriceField, gbc); // 21 Field

            JLabel productDetails = new JLabel("Product Details"); // label Subtitle
            productDetails.setFont(new Font("Arial", Font.ITALIC, 18));
            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            panel.add(productDetails, gbc);// xx

            JLabel sizeLabel = new JLabel("Item Size :"); // label size
            sizeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 8;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(sizeLabel, gbc);// 00

            JTextField sizeField = new JTextField(15); // Field size
            sizeField.setFont(new Font("Arial", Font.BOLD, 14));
            gbc.gridx = 0;
            gbc.gridy = 8;
            gbc.anchor = GridBagConstraints.EAST;
            sizeField.setColumns(5);
            panel.add(sizeField, gbc); //01

            JLabel weightLabel = new JLabel("Wight of Item in Grams :"); // label weight
            weightLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 9;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(weightLabel, gbc);// 10

            JTextField weightField = new JTextField(15);// Field weight
            sizeField.setFont(new Font("Arial", Font.BOLD, 14));
            gbc.gridx = 0;
            gbc.gridy = 9;
            gbc.anchor = GridBagConstraints.EAST;
            weightField.setColumns(5);
            panel.add(weightField, gbc); // 11

            JLabel conditionLevel = new JLabel("Enter the condition of the item, 10 best - 1 worst"); // label condition
            conditionLevel.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 10;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(conditionLevel, gbc); // 20

            JTextField conditionField = new JTextField(15);
            sizeField.setFont(new Font("Arial", Font.BOLD, 14));
            gbc.gridx = 0;
            gbc.gridy = 10;
            gbc.anchor = GridBagConstraints.EAST;
            conditionField.setColumns(5);
            panel.add(conditionField, gbc); // 21

            JLabel matrials = new JLabel("Enter the fabrication as percents of the items if present"); // Subtitle
            matrials.setFont(new Font("Arial", Font.BOLD, 14));
            gbc.gridx = 0;
            gbc.gridy = 11;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(matrials, gbc); // xx

            JLabel cottonLabel = new JLabel("Cotton Percent (Out of 100%, NA if not present)"); // label cotton
            cottonLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 12;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(cottonLabel, gbc); // 00

            JTextField cottonAmount = new JTextField(15); // Field Cotton
            cottonAmount.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 12;
            gbc.anchor = GridBagConstraints.EAST;
            cottonAmount.setColumns(5);
            panel.add(cottonAmount, gbc); // 01

            JLabel nylonLabel = new JLabel("Nylon Percent (Out of 100%, NA if not present) "); // label nylon
            nylonLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 13;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(nylonLabel, gbc); // 10

            JTextField nylonAmount = new JTextField(15); // field nylon
            nylonAmount.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 13;
            gbc.anchor = GridBagConstraints.EAST;
            nylonAmount.setColumns(5);
            panel.add(nylonAmount, gbc); // 11

            JLabel polyesterLabel = new JLabel("Polyester Percent (Out of 100%, else NA)         "); // label polyester
            polyesterLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 14;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(polyesterLabel, gbc); // 20

            JTextField polyesterAmount = new JTextField(15); // Field Polyester
            polyesterAmount.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 14;
            gbc.anchor = GridBagConstraints.EAST;
            polyesterAmount.setColumns(5);
            panel.add(polyesterAmount, gbc); // 21

            JLabel dropDownLabel = new JLabel("What Kind of Clothing Item is this?"); // learn from the source on main for combo box
            dropDownLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 15;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(dropDownLabel, gbc);

            // found this on google for the above box on how to integrate a drop down box Linked above in main

            String[] options = {"Accessories", "Tops", "Bottoms", "Shoes"};
            JComboBox<String> dropdown = new JComboBox<>(options); // This line is direct copy and paste from the site on   https://www.javatpoint.com/java-jcombobox
            dropdown.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc.gridx = 0;
            gbc.gridy = 15;
            gbc.anchor = GridBagConstraints.EAST;
            panel.add(dropdown,gbc);

            JButton createProduct = new JButton("Create LISTING!"); // Button to submit what is in the fields
            createProduct.setFont(new Font("Arial", Font.BOLD, 14));
            gbc.gridx = 0;
            gbc.gridy = 16;        
            gbc.anchor = GridBagConstraints.CENTER;
            createProduct.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
            createProduct.setBackground(Color.WHITE);
            panel.add(createProduct, gbc);

            createProduct.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // extracting the information and parsing the information if needed
                        String listingTitle = listingTitleField.getText();
                        String description = descriptionField.getText();
                        double price = Double.parseDouble(listingPriceField.getText());

                        String size = sizeField.getText();
                        int cotton = 0;
                        int nylon = 0;
                        int polyester = 0;
                        double weight = Double.parseDouble(weightField.getText());
                        int conditionLevel = Integer.parseInt(conditionField.getText());

                        if (!cottonAmount.getText().equals("NA")) {
                            cotton = Integer.parseInt(cottonAmount.getText());
                        }
                        if (!nylonAmount.getText().equals("NA")) {
                            nylon = Integer.parseInt(nylonAmount.getText());
                        }
                        if (!polyesterAmount.getText().equals("NA")) {
                            polyester = Integer.parseInt(polyesterAmount.getText());
                        }

                        String selectedOption = (String) dropdown.getSelectedItem();

                        // Adding everything to the new listing panel
                        Listing listing = new Listing();
                        listing.setName(listingTitle);
                        listing.setPublisherName(user.getUsername());
                        listing.setDescription(description);
                        listing.setPublisherID(user.getID());
                        listing.setCost(price);
                        listing.setSize(size);
                        listing.setWeight(weight);
                        listing.setConditionLevel(conditionLevel);
                        String materials = cotton + "% Cotton \n" + nylon + "% Nylon \n" + polyester + "% Polyester";
                        listing.setMaterials(materials);
                        listing.setType(selectedOption);
                        listing.setDate(getDate());
                        double offset = calculateCO2Offset(weight, cotton, nylon, polyester);
                        listing.setCO2Offset(offset);

                        addListing(listing);

                    }
                });

            add(panel);
        }
    }
    
    /**
     * Add a listing to the database with validation.
     * @author Bashar Zain
     * @param listing The listing you want to add.
     */
    protected void addListing(Listing listing) {
        String name = listing.getName();
        String desc = listing.getDescription();
        double cost = listing.getCost();
        String size = listing.getSize();
        double weight = listing.getWeight();
        String materials = listing.getMaterials();

        if(name.length() < 5) {
            JOptionPane.showMessageDialog( null, "Name must be greater than 5 characters.");
            return;
        }

        if(desc.length() < 20) {
            JOptionPane.showMessageDialog( null, "Description must be greater than 20 characters.");
            return;
        }

        if(cost < 1.00) {
            JOptionPane.showMessageDialog( null, "Cost must be at least $1.00!");
            return;
        }

        if(
        name.contains("'")      ||
        desc.contains("'")      ||
        size.contains("'")      ||
        materials.contains("'")
        ) {
            JOptionPane.showMessageDialog( null, "Your listing has invalid characters!");
            return;
        }

        ListingPortal portal = new ListingPortal("PROD");
        portal.addListing(listing);

        JOptionPane.showMessageDialog( null, "You have created a new " + listing.getType() + " Listing!");
        setVisible(false);

    }

    /**
     * Using Java's SimpleDateFormat, return a formatted string date.
     * @author Bashar Zain
     * @return Date in string.
     */

    public String getDate() {
        // CREDITS: https://stackoverflow.com/questions/6406470/java-simpledateformat
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        Date date = new Date();  
        return formatter.format(date);  
    }

    /**
     * Calculate the CO2 offset using fixed variables.
     * 
     * @author Bashar Zain
     * @param weight The total weight of the object.
     * @param cotton The amount of cotton in a percent.
     * @param nylon The amount of nylon in a percent.
     * @param polyester The amount of polyester in a percent.
     * @return The CO2 offset.
     */

    public double calculateCO2Offset(double weight, int cotton, int nylon, int polyester) {

        double cottonToCO2 = 2.1; // Arrived at these numbers based on ChatGPT's calculations.
        double nylonToCO2 = 5.43;
        double polyesterToCO2 = 2.85;

        double weightOfCotton = weight * (cotton / 100.0);
        double weightOfNylon = weight * (nylon / 100.0);
        double weightOfPolyester = weight * (polyester / 100.0);

        double res = (cottonToCO2 * weightOfCotton) + (nylonToCO2 * weightOfNylon) + (polyesterToCO2 * weightOfPolyester);

        return res;
    }

}
