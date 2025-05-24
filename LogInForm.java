import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class will create and open a login page in the center of the screen so that they can sign it, it
 * will also validate it from the database, while ensuring basic checks like null values input length
 *
 * @author Lakshmanan Ramanathan
 * @version 1.0
 *
 */
public class LogInForm extends JFrame{
    Homepage home;

    /**
     * This constructor creates a login form that accepts input and stores the input to strings when a button is clicked
     *
     * @author Lakshmanan Ramanathan
     * @param thisHome you have to pass the homepage so that you can close it when login is clicked and verified
     */
    public LogInForm(Homepage newHome) {
        home = newHome;
        setTitle("Log In Form");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // setting it dispose instead of quit
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(); // Creating a panel to store the labels and feilds
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel usernameLabel = new JLabel("Username:"); // Username label set to top right
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(15); // Text feild for input set to top left
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:"); // password leabel set to top left on 2 row
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15); // Text feild for input set to bottom left on 2 row (LEARNT THAT THERE WAS THIS FUNCTION FROM CHAT GPT)
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;    
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login"); // Creating a button at the center bottom to submit the information gathered
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;        
        loginButton.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        loginButton.setBackground(Color.WHITE);
        panel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText(); //https://www.javatpoint.com/java-jtextfield
                    String password = new String(passwordField.getPassword()); // Convert password to String USED CHAT GPT FOR THIS LINE
                    logMeIn(username, password); // running this into the log me in function.
                }
            });

        add(panel);
    }

    /**
     * This function will validate if the user is in the database and check their information after performing basic checks.
     * @param username The username of the user.
     * @param password The password of the user.
     * @author Bashar Zain
     */
    private void logMeIn(String username, String password) {
        UserPortal portal = new UserPortal("PROD");

        if(username.length() < 3) {
            JOptionPane.showMessageDialog(null, "Your username has to be greater than 3 characters.");
            return;
        }

        if(password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Your password has to be greater than 8 characters.");
            return;
        }

        if(username.contains("'") || password.contains("'")) {
            JOptionPane.showMessageDialog(null, "The information provided contains invalid characters. (')");
            return;
        }

        User user = portal.getByUsername(username); //Bashar

        if(!(user.getUsername() != null)) {
            JOptionPane.showMessageDialog(null, "This user does not exist in our database!");
            return;
        }

        if(user.getPassword().equals(password)) { // we find the user first then check the password Lakshman
            JOptionPane.showMessageDialog(null, "Welcome, " + user.getFullName() + "!"); //https://www.javatpoint.com/java-joptionpane
            setVisible(false);
            Homepage homepage = new Homepage(user);
            homepage.setVisible(true);
            home.setVisible(false); // closing the passed in home so there are no duplicate screens
            return;
        }
    }

}