import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Page that lets you purchase an item
 * 
 * Everything was created by Kiran Goli in this class.
 * 
 * @author Kiran Goli
 * @version 1.0
 */
public class BuyNow extends JFrame {
    User user;
    Listing listing;
    Homepage home;
    
    /**
     * Constructor of Buy Now Page
     */
    public BuyNow(User passUser, Listing passListing, Homepage passHome) {
        JFrame buyNowPage = new JFrame("BuyNow");
        Toolkit tk = Toolkit.getDefaultToolkit(); // Toolkit for screen size
        user = passUser;
        listing = passListing;
        home = passHome;

        buyNowPage.setSize(1200,900);
        
        buyNowPage.setLayout(null);
        buyNowPage.setVisible(true);

        JButton buyButton = new JButton("Buy"); // https://www.javatpoint.com/java-jbutton
        buyButton.setBounds(100, 730, 150, 50); // Adjusted size of the button
        buyNowPage.add(buyButton);

        JLabel listingTitle = new JLabel(listing.getName());
        JLabel listingInformation = new JLabel("<html>" + listing.getDescription() + "</html>"); // HTML for wrapping long description
        JLabel listingPublisher = new JLabel("Publisher: " + listing.getPublisherName());
        JLabel listingType = new JLabel("Type: " + listing.getType());
        JLabel listingSize = new JLabel("Size: " + listing.getSize());

        String unicode = null;
        switch(listing.getType()){
            case "Accessories":
                unicode = "⭐";
            break;
            
            case "Shoes":
                unicode = "👟";
            break;
            
            case "Bottoms":
                unicode = "👖";
            break;
            
            case "Tops":
                unicode = "👕";
            break;
            
            default:
                unicode = "⭐";
            break;
        }

        JLabel listingImage = new JLabel(unicode);
        listingImage.setFont(new Font("Dialog", Font.PLAIN, 200)); // Adjusted size for image icon
        listingImage.setBounds(100, 100, 250, 250); // Adjusted position of image

        JLabel listingMaterials = new JLabel("Materials: " + listing.getMaterials());
        JLabel listingWeight = new JLabel("Weight: " + listing.getWeight() + " g");
        JLabel listingCO2Offset = new JLabel("CO2 Offset: " + listing.getCO2Offset() + " g");
        JLabel listingCost = new JLabel("Price: $" + listing.getCost());
        JLabel listingConditionLevel = new JLabel("Condition: " + listing.getConditionLevel());
        UserPortal portal = new UserPortal("PROD");
        User lister = portal.getByID(listing.getPublisherID());
        JLabel listingContactNow = new JLabel("Contact Now: \n" + lister.getEmail() + " | " + lister.getPhoneNumber());

        // Everything here has been scaled and bounded by ChatGPT (chat.openai.com)
        listingTitle.setBounds(450, 100, 600, 50); // Adjusted positioning for title
        listingTitle.setFont(new Font("Arial", Font.PLAIN, 32));

        listingInformation.setBounds(450, 150, 600, 100);
        listingInformation.setFont(new Font("Arial", Font.PLAIN, 20));

        listingPublisher.setBounds(450, 250, 600, 30);
        listingPublisher.setFont(new Font("Arial", Font.PLAIN, 18));

        listingSize.setBounds(450, 290, 600, 30);
        listingSize.setFont(new Font("Arial", Font.PLAIN, 18));

        listingType.setBounds(450, 330, 600, 30);
        listingType.setFont(new Font("Arial", Font.PLAIN, 18));

        listingMaterials.setBounds(450, 370, 600, 30);
        listingMaterials.setFont(new Font("Arial", Font.PLAIN, 18));

        listingWeight.setBounds(450, 410, 600, 30);
        listingWeight.setFont(new Font("Arial", Font.PLAIN, 18));

        listingCO2Offset.setBounds(450, 450, 600, 30);
        listingCO2Offset.setFont(new Font("Arial", Font.PLAIN, 18));

        listingCost.setBounds(450, 490, 600, 30);
        listingCost.setFont(new Font("Arial", Font.PLAIN, 18));

        listingConditionLevel.setBounds(450, 530, 600, 30);
        listingConditionLevel.setFont(new Font("Arial", Font.PLAIN, 18));
        
        listingContactNow.setBounds(450, 570, 600, 30);
        listingContactNow.setFont(new Font("Arial", Font.PLAIN, 18));

        buyNowPage.add(listingImage);
        buyNowPage.add(listingTitle);
        buyNowPage.add(listingInformation);
        buyNowPage.add(listingPublisher);
        buyNowPage.add(listingSize);
        buyNowPage.add(listingType);
        buyNowPage.add(listingMaterials);
        buyNowPage.add(listingWeight);
        buyNowPage.add(listingCO2Offset);
        buyNowPage.add(listingCost);
        buyNowPage.add(listingConditionLevel);
        buyNowPage.add(listingContactNow);

        buyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buyNowPage.setVisible(false); // Hide BuyNow Page

                JFrame buyingPage = new JFrame(); // https://www.javatpoint.com/java-jframe
                JLabel paymentInfoTitle = new JLabel("Enter your payment info");
                
                JButton confirmPaymentInfo = new JButton("Confirm");

                buyingPage.setBounds(730, 333, 700, 700);
                buyingPage.setSize(700, 700);
                buyingPage.setLayout(null);
                buyingPage.setVisible(true);

                JLabel nameLabel = new JLabel("Name on Card:");
                JLabel expiryDateLabel = new JLabel("Expiry Date (MM/YY):");
                JLabel cardNumberLabel = new JLabel("Card Number:");
                JLabel cvvLabel = new JLabel("CVV:");

                JTextField nameField = new JTextField(); // https://www.javatpoint.com/java-jtextfield
                JTextField expiryDateField = new JTextField();
                JTextField cardNumberField = new JTextField();
                JTextField cvvField = new JTextField();

                // Positioning the labels and text fields
                nameLabel.setBounds(50, 150, 200, 30);
                nameField.setBounds(250, 150, 400, 30);

                expiryDateLabel.setBounds(50, 200, 200, 30);
                expiryDateField.setBounds(250, 200, 150, 30);

                cardNumberLabel.setBounds(50, 250, 200, 30);
                cardNumberField.setBounds(250, 250, 400, 30);

                cvvLabel.setBounds(50, 300, 200, 30);
                cvvField.setBounds(250, 300, 100, 30);

                confirmPaymentInfo.setFont(new Font("Arial", Font.PLAIN, 20));
                confirmPaymentInfo.setBounds(250, 350, 200, 50);

                paymentInfoTitle.setFont(new Font("Arial", Font.PLAIN, 25));
                paymentInfoTitle.setBounds(50, 100, 400, 50);

                buyingPage.add(nameLabel);
                buyingPage.add(nameField);
                buyingPage.add(expiryDateLabel);
                buyingPage.add(expiryDateField);
                buyingPage.add(cardNumberLabel);
                buyingPage.add(cardNumberField);
                buyingPage.add(cvvLabel);
                buyingPage.add(cvvField);
                buyingPage.add(paymentInfoTitle);
                buyingPage.add(confirmPaymentInfo);

                JLabel error = new JLabel("Error: Invalid payment info");
                error.setBounds(150, 400, 400, 40);
                error.setFont(new Font("Arial", Font.PLAIN, 18));
                error.setForeground(Color.RED);
                buyingPage.add(error);
                error.setVisible(false);

                confirmPaymentInfo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String cardNumber = cardNumberField.getText();
                        
                        // If statements here by ChatGPT
                        if (nameField.getText().isEmpty() || expiryDateField.getText().isEmpty() || cardNumber.isEmpty() || cvvField.getText().isEmpty()) {
                            error.setText("Error: Please fill in all fields");
                            error.setVisible(true);
                        } else if (cardNumber.length() != 16 || !cardNumber.chars().allMatch(Character::isDigit)) {
                            error.setText("Error: Invalid card number");
                            error.setVisible(true);
                        } else if (!expiryDateField.getText().matches("\\d{2}/\\d{2}")) {
                            error.setText("Error: Invalid expiry date format");
                            error.setVisible(true);
                        } else if (cvvField.getText().length() != 3 || !cvvField.getText().chars().allMatch(Character::isDigit)) {
                            error.setText("Error: Invalid CVV");
                            error.setVisible(true);
                        } else {
                            // Hide input fields and show success message
                            nameField.setVisible(false);
                            nameLabel.setVisible(false);
                            expiryDateField.setVisible(false);
                            expiryDateLabel.setVisible(false);
                            cardNumberField.setVisible(false);
                            cardNumberLabel.setVisible(false);
                            cvvField.setVisible(false);
                            cvvLabel.setVisible(false);
                            confirmPaymentInfo.setVisible(false);
                            paymentInfoTitle.setVisible(false);
                            error.setVisible(false);

                            JLabel shopping = new JLabel("Thank you for shopping!");
                            ListingPortal portal = new ListingPortal("PROD");
                            portal.deleteListing(listing);
                            shopping.setFont(new Font("Arial", Font.PLAIN, 30));
                            shopping.setBounds(150, 350, 400, 50);
                            buyingPage.add(shopping);
                        }
                    }
                });

                buyingPage.addWindowListener(new WindowAdapter() { // Allows users to interact with window-specific features of the frame.
                    public void windowClosing(WindowEvent e) {
                        buyNowPage.setVisible(false);
                        home.setVisible(false);
                        Homepage home = new Homepage(user);
                        home.setVisible(true);
                    }
                });
            }
        });
    }
}
