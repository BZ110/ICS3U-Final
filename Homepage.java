import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is used to to populate a homepage in a variety of states(when logged in and not logged in)
 * with a navigation panel, where the user can interact with it.
 *
 * @author Lakshmanan Ramanathan
 * @version 1.0
 */

public class Homepage extends JFrame {

    /* To ensure (this, the parent frame) has a dedicated variable in other clsses (Action Listeners). */
    private Homepage thisHome = this;
    
    /* The user that is signed in. */
    private User user;
    
    /* The state in which button is highlighted white or yellow. */
    String buttonState;

    /**
     * Sets up the required background information for the Homepage upon creation, like size, title & close operation
     *
     * @author Lakshmanan Ramanathan
     * @param state this is a string that is passed into the function to indicate which navigation.
     */
    public Homepage(String state) {
        
        setLocationRelativeTo(null);

        JLabel PAGETitle = new JLabel("Shop from Locally for Trendy Fasion While Saving Our Planet!");
        PAGETitle.setFont(new Font("Arial", Font.BOLD, 24));
        PAGETitle.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Create a page title at the bottom
        buttonState = "Regular";
        setSize(1600, 1000); // Setting the default size of the Homepage(Needed to make sure it does not minimize fully)
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Extending it on launch so it take up the whole screen so it is cross compatible across resolution

        if(state.equals("Boot")) {
            populate();
            JPanel navBar = navigatorBarBoot();
            
            add(navBar, BorderLayout.NORTH);
            setTitle("Homepage StyleCycle");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            add(PAGETitle, BorderLayout.SOUTH); 
            
        }

    }

    /**
     * This is the constructor for the homepage when a user signs in after logging through the Login section, this is has the same base setup as the HomePage on Boot
     * but has different features on creation controlled through the specific Navigation bar.
     *
     * @author Lakshmanan Ramanathan
     * @param newUser The user that is signed in.
     */

    public Homepage(User newUser) {
        setLocationRelativeTo(null);
        JLabel PAGETitle = new JLabel("Shop from Locally for Trendy Fasion While Saving Our Planet!");
        PAGETitle.setFont(new Font("Arial", Font.BOLD, 24));
        PAGETitle.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Create a page title at the bottom

        setSize(1600, 1000); // Setting a default size so it is resiziable and minimizable
        buttonState = "Regular";
        user = newUser;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel navBar = navigatorBarUser();
        add(navBar, BorderLayout.NORTH);
        populate();
        setTitle("SyleCycle Logged In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(PAGETitle, BorderLayout.SOUTH);

    }
    
    /**
     * This constructor is a bit different, it purposely allows to colour the View Your Listings Button and the Shop and Save one.
     * 
     * @author Bashar Zain
     * @param newUser The user that is currently signed in.
     * @param state The button we are supposed to highlight.
     */
    public Homepage(User newUser, String state) {
        setLocationRelativeTo(null);
        JLabel PAGETitle = new JLabel("Shop from Locally for Trendy Fasion While Saving Our Planet!");
        PAGETitle.setFont(new Font("Arial", Font.BOLD, 24));
        PAGETitle.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Create a page title at the bottom

        setSize(1600, 1000); // Setting a default size so it is resiziable and minimizable
        user = newUser;
        buttonState = state;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel navBar = navigatorBarUser();
        add(navBar, BorderLayout.NORTH);
        populate();
        setTitle("SyleCycle Logged In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(PAGETitle, BorderLayout.SOUTH);

    }

    /**
     * Creates an integreatable panel that can be added for the user to visit different pages of the application
     *
     * @author Lakshmanan Ramanathan
     * @return A navBar that can be inserted as a panel that has buttons for the user to navigate the site
     * @hidden
     */
    private JPanel navigatorBarBoot() {

        JPanel navBar = new JPanel();
        navBar.setBackground(Color.LIGHT_GRAY);
        navBar.setLayout(new BoxLayout(navBar, BoxLayout.X_AXIS)); // used the source linked in main to add the border https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html

        JLabel name = new JLabel("StyleCycle");
        name.setFont(new Font("Arial", Font.BOLD, 24));
        name.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // Learn More Button to navigate the user to the learn more page
        JButton learnMoreButton = new JButton("Learn More");

        learnMoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // Method to handle action events on Button press
                LearnMorePage learnMorePage = new LearnMorePage("Boot", thisHome, null); // Debugged this into chatgpt as I accidentally  passed a .this reference
                learnMorePage.setVisible(true);
                setVisible(false); // Hiding this page
            }
        });

        learnMoreButton.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        learnMoreButton.setBackground(Color.WHITE);

        // Home Button to indicate what page the user is on
        JButton homeButton = new JButton(" Home ");
        //TODO Function DONE
        homeButton.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        homeButton.setBackground(Color.YELLOW);

        // Creating a loginButton that takes the user on Button press to a log in pane, we pass this home so that it can be closed on the sign up page
        JButton loginButton = new JButton("Log In");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogInForm logInForm = new LogInForm(thisHome);
                logInForm.setVisible(true);
            }
        });

        loginButton.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20)); //https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        loginButton.setBackground(Color.WHITE);

        // Creating a signUpButton to take the user on Button press
        JButton signUpButton = new JButton("Sign Up");

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignUpForm SignUpForm = new SignUpForm(thisHome); //Passing in this home so that we can close it latter
                SignUpForm.setVisible(true);
            }
        });

        signUpButton.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        signUpButton.setBackground(Color.WHITE);

        // Adding all components to the panel
        navBar.add(name);
        navBar.add(learnMoreButton);
        navBar.add(Box.createHorizontalGlue());        
        navBar.add(homeButton);
        navBar.add(Box.createHorizontalStrut(20));
        navBar.add(loginButton);
        navBar.add(Box.createHorizontalStrut(20));
        navBar.add(signUpButton);
        navBar.add(Box.createHorizontalStrut(20));
        return navBar;

    }

    /**
     * This create a new navbar that is meant for the user to know that they are logged in, it has a new set of features that allows user that are logged in to veiw their listings, buy stuff
     * and create new listings
     *
     * @author Lakshmanan Ramanathan
     * @return Jpanel that fits into a Jframe
     */

    private JPanel navigatorBarUser() {
        JPanel navBar = new JPanel();
        navBar.setBackground(Color.LIGHT_GRAY);
        navBar.setLayout(new BoxLayout(navBar, BoxLayout.X_AXIS));

        JLabel name = new JLabel("StyleCycle");
        name.setFont(new Font("Arial", Font.BOLD, 24));
        name.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel greet = new JLabel("Welcome, " + user.getFullName()); // This is to indicate to the user that they are logged in
        greet.setFont(new Font("Arial", Font.ITALIC, 24));
        name.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JButton learnMoreButton = new JButton("Learn More");

        learnMoreButton.addActionListener(new ActionListener() { // "navigates" to the learn more page tbd
                public void actionPerformed(ActionEvent e) {
                    LearnMorePage learnMorePage = new LearnMorePage("User", thisHome, user);
                    learnMorePage.setVisible(true);
                    setVisible(false);
                }
            });

        learnMoreButton.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        learnMoreButton.setBackground(Color.WHITE);

        JButton viewYourListings = new JButton("View Your Listings"); // View your listings button
        viewYourListings.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        if(buttonState.equals("ListingView")){
            viewYourListings.setBackground(Color.YELLOW);
        } else {
            viewYourListings.setBackground(Color.WHITE);
        }
        
        viewYourListings.addActionListener(new ActionListener() { // "navigates" to the learn more page tbd
            public void actionPerformed(ActionEvent e) {
                Homepage home = new Homepage(user, "ListingView");
                home.populate(user);
                home.setVisible(true);
                setVisible(false);
            }
        });
        JButton viewAllListings = new JButton("Shop and Save!"); // Shop and Save button, navigates to homepage
        viewAllListings.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        
        if(buttonState.equals("Regular")){
            viewAllListings.setBackground(Color.YELLOW);
        } else {
            viewAllListings.setBackground(Color.WHITE);
        }
        viewAllListings.addActionListener(new ActionListener() { // "navigates" to the learn more page tbd
            public void actionPerformed(ActionEvent e) {
                Homepage home = new Homepage(user);
                home.populate();
                home.setVisible(true);
                setVisible(false);
            }
        });
        JButton createListing = new JButton("Create New Listing"); // create listing button should popup a form
        createListing.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CreateProductPage creationPage = new CreateProductPage(thisHome,user.getID(), "New", user); // Create a temporary Jframe for the user to input information about the listing before saving it
                    creationPage.setVisible(true);
                }
            });

        createListing.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        createListing.setBackground(Color.WHITE);

        JButton signOut = new JButton("Sign Out"); // Signout button
        signOut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    Homepage homepage = new Homepage("Boot"); // Reopening a new homepage while discarding the previous session instead of 'logging out'
                    homepage.setVisible(true);
                }
            });

        // Adding all the elements for the navbar

        signOut.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        signOut.setBackground(Color.WHITE);

        navBar.add(name);
        navBar.add(Box.createHorizontalStrut(20));

        navBar.add(greet);
        navBar.add(Box.createHorizontalStrut(20));

        navBar.add(learnMoreButton);
        navBar.add(Box.createHorizontalGlue()); // Used CHATGPT to learn how to left align via glueing

        navBar.add(viewAllListings);
        navBar.add(Box.createHorizontalStrut(20));

        navBar.add(viewYourListings);
        navBar.add(Box.createHorizontalStrut(20));

        navBar.add(createListing);
        navBar.add(Box.createHorizontalStrut(20));

        navBar.add(signOut);
        navBar.add(Box.createHorizontalStrut(20));

        return navBar;


    }

    /**
     * This function create a scrollable pane and adds multiple panels and iterativly populates each
     * panel from extracting through the rows and colums on the database populating
     * each panel then with the panels populating the scroll pane
     *
     * @author Lakshmanan Ramanathan
     */
    public void populate() {
        ListingPortal portal = new ListingPortal("PROD");
        JPanel outerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();//https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        JPanel listingsPanel = new JPanel();
        Listing[] listings = portal.getEverything(); 
        for (int i = listings.length - 1; i > -1; i--) { 
            //Title
            //Category
            //Desc
            //Name of the Seller
            //Weight
            //Material Make Up
            //CO2 Offset
            //Cost
            //Buy Now
            Listing temp = listings[i];
            

            JPanel listingPanel = new JPanel();
            GridBagConstraints gbc1 = new GridBagConstraints();

            listingPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            listingPanel.setPreferredSize(new Dimension(430, 750));
            listingPanel.setBackground(Color.WHITE);
            listingPanel.setLayout(new GridBagLayout());

            gbc1.anchor = GridBagConstraints.WEST;
            gbc1.insets = new Insets(5, 5, 5, 5); // Learned how to use insetrs from this tutorial on java swing: https://www.youtube.com/watch?v=xk4_1vDrzzo
            gbc1.gridx = 0;
            gbc1.weightx = 1.0;
            gbc1.fill = GridBagConstraints.HORIZONTAL;
            
            String unicode = null;
            switch(temp.getType()){
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
                    // Default case, fallback.
                    unicode = "⭐";
                break;
            }
            JLabel image = new JLabel(unicode);
            image.setFont(new Font("", Font.BOLD, 300));
            gbc1.gridy = 0;
            listingPanel.add(image, gbc1);

            JLabel tempTitle = new JLabel(temp.getName());
            tempTitle.setFont(new Font("Arial", Font.BOLD, 20));
            gbc1.gridy = 1;
            listingPanel.add(tempTitle, gbc1);

            JLabel category = new JLabel("Category: " + temp.getType());
            category.setFont(new Font("Arial", Font.ITALIC, 16));
            gbc1.gridy = 2;
            listingPanel.add(category, gbc1);

            JLabel lister = new JLabel("Lister: " + temp.getPublisherName());
            lister.setFont(new Font("Arial", Font.ITALIC, 14));
            gbc1.gridy = 3;
            listingPanel.add(lister, gbc1);

            JLabel desc = new JLabel("Description: " + temp.getDescription());
            desc.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc1.gridy = 4;
            listingPanel.add(desc, gbc1);

            JLabel material = new JLabel("Fabrication: " + temp.getMaterials());
            material.setFont(new Font("Arial", Font.ITALIC, 14));
            gbc1.gridy = 5;
            listingPanel.add(material, gbc1);

            JLabel weight = new JLabel("Item Weight: " + temp.getWeight() + " g");
            weight.setFont(new Font("Arial", Font.PLAIN, 14));
            gbc1.gridy = 6;
            listingPanel.add(weight, gbc1);

            JLabel co2 = new JLabel("CO2 Offset: " + temp.getCO2Offset() + " g");
            co2.setFont(new Font("Arial", Font.BOLD, 16));
            gbc1.gridy = 7;
            listingPanel.add(co2, gbc1);

            JLabel condition = new JLabel(temp.getWordedConditionLevel() + " (" + temp.getConditionLevel() + "/10)");
            condition.setFont(new Font("Arial", Font.BOLD, 18));
            gbc1.gridy = 8;
            listingPanel.add(condition, gbc1);

            JLabel time = new JLabel(temp.getDate());
            time.setFont(new Font("Arial", Font.PLAIN, 10));
            gbc1.gridy = 9;
            listingPanel.add(time, gbc1);

            JLabel size = new JLabel(temp.getSize());
            size.setFont(new Font("Arial", Font.BOLD, 18));
            gbc1.gridy = 10;
            listingPanel.add(size, gbc1);
            
            JLabel cost = new JLabel("$ " + temp.getCost() + " CAD");
            cost.setFont(new Font("Arial", Font.BOLD, 18));
            gbc1.gridy = 11;
            listingPanel.add(cost, gbc1);

            if(!(user == null)){
                JButton buyNow = new JButton("BUY NOW");
            
                buyNow.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { // Method to handle action events on Button press
                    BuyNow buyNow = new BuyNow(user, temp, thisHome);
                }
                });
                
                buyNow.setFont(new Font("Arial", Font.BOLD, 14));
                buyNow.setBackground(Color.LIGHT_GRAY);
                gbc1.gridy = 12;
                gbc1.anchor = GridBagConstraints.CENTER;
                listingPanel.add(buyNow, gbc1);
            } else {
                JButton buyNow = new JButton("LOGIN TO BUY");
            
                buyNow.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { // Method to handle action events on Button press
                    LogInForm newLoginPage = new LogInForm(thisHome);
                    newLoginPage.setVisible(true);
                }
                });
                
                buyNow.setFont(new Font("Arial", Font.BOLD, 14));
                buyNow.setBackground(Color.LIGHT_GRAY);
                gbc1.gridy = 12;
                gbc1.anchor = GridBagConstraints.CENTER;
                listingPanel.add(buyNow, gbc1);
            }
            
            
            

            listingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            listingsPanel.add(Box.createHorizontalStrut(10));
            listingsPanel.add(listingPanel);

        }
        outerPanel.add(listingsPanel, gbc);

        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));

        JScrollPane scrollPane = new JScrollPane(outerPanel);
        add(scrollPane, BorderLayout.CENTER);


    }

    /**
     * This function allows the user to create panels on a pane exactly similar to the other populate function, but this overloaded method
     * creates panels only if the user is the one who created that panel acting as a filter for the pane on the homepage iterativly adding labels for row coulums from the database tabel
     * on the listings then on he listings to the panes
     *
     * @author Lakshmanan Ramanathan
     * @param user
     */

    public void populate(User user) {
        ListingPortal portal = new ListingPortal("PROD");

        JPanel outerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel listingsPanel = new JPanel();
        Listing[] listings = portal.getEverything();
        for (int i = listings.length - 1; i > -1; i--) {
            //Title
            //Category
            //Desc
            //Name of the Seller
            //Weight
            //Material Make Up
            //CO2 Offset
            //Cost
            //Buy Now
            Listing temp = listings[i];
            if(user.getID() == temp.getPublisherID()) {

                JPanel listingPanel = new JPanel();
                GridBagConstraints gbc1 = new GridBagConstraints();

                listingPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                listingPanel.setPreferredSize(new Dimension(400, 700));
                listingPanel.setBackground(Color.WHITE);
                listingPanel.setLayout(new GridBagLayout());

                // HAD THIS SPECIFC GDC setup by chat gpt by playing around with the values
                gbc1.anchor = GridBagConstraints.WEST; // Align all components to the left
                gbc1.insets = new Insets(5, 5, 5, 5); // Padding around components
                gbc1.gridx = 0; // Start all components in column 0
                gbc1.weightx = 1.0;
                gbc1.fill = GridBagConstraints.HORIZONTAL;
                
                String unicode = null;
                switch(temp.getType()){
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
                        // Default case, fallback.
                        unicode = "⭐";
                    break;
                }
                JLabel image = new JLabel(unicode);
                image.setFont(new Font("", Font.BOLD, 300));
                gbc1.gridy = 0;
                listingPanel.add(image, gbc1);

                JLabel tempTitle = new JLabel(temp.getName());
                tempTitle.setFont(new Font("Arial", Font.BOLD, 20));
                gbc1.gridy = 1;
                listingPanel.add(tempTitle, gbc1);

                JLabel category = new JLabel("Category: " + temp.getType());
                category.setFont(new Font("Arial", Font.ITALIC, 16));
                gbc1.gridy = 2;
                listingPanel.add(category, gbc1);

                JLabel lister = new JLabel("Lister: " + temp.getPublisherName());
                lister.setFont(new Font("Arial", Font.ITALIC, 14));
                gbc1.gridy = 3;
                listingPanel.add(lister, gbc1);

                JLabel desc = new JLabel("Description: " + temp.getDescription());
                desc.setFont(new Font("Arial", Font.PLAIN, 14));
                gbc1.gridy = 4;
                listingPanel.add(desc, gbc1);

                JLabel material = new JLabel("Fabrication: " + temp.getMaterials());
                material.setFont(new Font("Arial", Font.ITALIC, 14));
                gbc1.gridy = 5;
                listingPanel.add(material, gbc1);

                JLabel weight = new JLabel("Item Weight: " + temp.getWeight() + " g");
                weight.setFont(new Font("Arial", Font.PLAIN, 14));
                gbc1.gridy = 6;
                listingPanel.add(weight, gbc1);

                JLabel co2 = new JLabel("CO2 Offset: " + temp.getCO2Offset() + " g");
                co2.setFont(new Font("Arial", Font.BOLD, 16));
                gbc1.gridy = 7;
                listingPanel.add(co2, gbc1);

                JLabel condition = new JLabel(temp.getWordedConditionLevel() + " (" + temp.getConditionLevel() + "/10)");
                condition.setFont(new Font("Arial", Font.BOLD, 18));
                gbc1.gridy = 8;
                listingPanel.add(condition, gbc1);

                JLabel cost = new JLabel("$ " + temp.getCost() + " CAD");
                cost.setFont(new Font("Arial", Font.BOLD, 18));
                gbc1.gridy = 9;
                listingPanel.add(cost, gbc1);

                JButton remove = new JButton("Remove");
                remove.setFont(new Font("Arial", Font.BOLD, 14));
                remove.setBackground(Color.RED);
                
                remove.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { // Method to handle action events on Button press
                    ListingPortal portal = new ListingPortal("PROD");
                    portal.deleteListing(temp);
                    JOptionPane.showMessageDialog(null, "This listing has been removed! (ID: " + temp.getID() + ")");
                    Homepage home = new Homepage(user, "ListingView");
                    home.populate(user);
                    home.setVisible(true);
                    setVisible(false);
                }
                });
                
                gbc1.gridy = 10;
                gbc1.anchor = GridBagConstraints.CENTER;
                listingPanel.add(remove, gbc1);


                listingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                listingsPanel.add(Box.createHorizontalStrut(10));
                listingsPanel.add(listingPanel);
            }

        }
        outerPanel.add(listingsPanel, gbc);

        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 90, 10));

        JScrollPane scrollPane = new JScrollPane(outerPanel); // https://www.javatpoint.com/java-jscrollbar / https://www.javatpoint.com/java-joptionpane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //https://www.javatpoint.com/java-jscrollpane
        add(scrollPane, BorderLayout.CENTER);


    }

}
