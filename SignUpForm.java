import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class create a Jframe that allows the user to input all their data, and through a button click the program collects the input in the fields.
 * 
 * @author Lakshmanan Ramanathan
 */
public class SignUpForm extends JFrame{
    
    Homepage home;
    
    /**
     * The constructor to make the popup to sign up.
     * 
     * @author Lakshmanan Ramanathan
     */
    public SignUpForm(Homepage newhome) {
        home = newhome;
        setTitle("Sign Up Form");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(); // Creating a panel to store all the feilds, it is a copy and paste of the login form with an extra label and text
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel fullName = new JLabel("Enter Your Full Name:"); // Full name label set to top right
        fullName.setFont(new Font("Arial", Font.ITALIC, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(fullName, gbc);

        JTextField fullNameFeild = new JTextField(15); // Full name feild for input set to middle left
        fullNameFeild.setFont(new Font("Arial", Font.ITALIC, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        fullNameFeild.setColumns(15);// found this function via CHAT GPT
        panel.add(fullNameFeild, gbc);

        JLabel email = new JLabel("Enter Your Email"); // Full name label set to middle right
        fullName.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(email, gbc);

        JTextField emailFeild = new JTextField(15); // Full name feild for input set to middle left
        fullNameFeild.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        emailFeild.setColumns(15);// found this function via CHAT GPT
        panel.add(emailFeild, gbc);

        JLabel phoneLabel = new JLabel("Your Phone Number"); // Full name label set to middle right
        fullName.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(phoneLabel, gbc);

        JTextField phoneFeild = new JTextField(15); // Full name feild for input set to top left
        fullNameFeild.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        phoneFeild.setColumns(15);
        panel.add(phoneFeild, gbc);

        JLabel usernameLabel = new JLabel("Enter a Username:"); // Username label to set to middle left
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(15); // Username field to set to middle right
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        usernameField.setColumns(15);
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Enter a Password:"); // password leabel set to top left on 2 row
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15); // Text feild for input set to bottom left on 2 row (LEARNT THAT THERE WAS THIS FUNCTION FROM CHAT GPT)
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 4;    
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        JButton signUp = new JButton("Sign Up"); // Creating a button at the center bottom to submit the information gathered
        signUp.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 1;
        gbc.gridy = 5;        
        signUp.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        signUp.setBackground(Color.WHITE);
        panel.add(signUp, gbc);

        signUp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String fullName = fullNameFeild.getText();
                    String username = usernameField.getText(); 
                    String password = new String(passwordField.getPassword()); // Convert password to String USED CHAT GPT FOR THIS LINE
                    String phoneNumber = phoneFeild.getText();
                    String email = emailFeild.getText();

                    signUpUser(username, password, fullName, email, phoneNumber); // running this into the sign me up function.

                }
            });

        add(panel);


    }

    /**
     * This method ensures that the user inputs all valid feilds and informs the user when a certain input does not pass the guidlines through an option pane.
     *
     * @author Bashar Zain
     * @param username
     * @param password
     * @param fullName
     */
    public void signUpUser(String username, String password, String fullName, String email, String phoneNumber){

        UserPortal portal = new UserPortal("PROD");

        User user = new User();
        if(fullName.length() < 3) {
            JOptionPane.showMessageDialog(null, "Your full name has to be greater than 3 characters.");
            return;
        }

        if(username.length() < 3) {
            JOptionPane.showMessageDialog(null, "Your username has to be greater than 3 characters.");
            return;
        }

        if(password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Your password has to be greater than 8 characters.");
            return;
        }

        if(!(email.contains("@") && (
            email.contains(".org") ||
            email.contains(".net") ||
            email.contains(".com") ||
            email.contains(".edu") ||
            email.contains(".lol") ||
            email.contains(".gov") ||
            email.contains(".xyz") ||
            email.contains(".gg") ||
            email.contains(".cc") ||
            email.contains(".ca") ||
            email.contains(".us") ||
            email.contains(".in") ||
            email.contains(".uk")) // Only have support for certain domains in certain countries.
        )){
            JOptionPane.showMessageDialog(null, "This email isn't valid.");
            return; 
        }
        
        // Loop each character.
        for(int i = 0; i < phoneNumber.length(); i++){
            char x = phoneNumber.charAt(i);
            if(x != '0' &&
               x != '1' &&
               x != '2' &&
               x != '3' &&
               x != '4' &&
               x != '5' &&
               x != '6' &&
               x != '7' &&
               x != '8' &&
               x != '9' ||
               ((phoneNumber.length() > 10) || (phoneNumber.length() < 10))
            ){
                JOptionPane.showMessageDialog(null, "The phone number provided is not valid.");
                return;
            }
        }

        if(portal.getByUsername(username).getUsername() != null) {
            JOptionPane.showMessageDialog(null, "This username already exists in our database.");
            return;
        }

        if(fullName.contains("'") || username.contains("'") || password.contains("'") || email.contains("'") || phoneNumber.contains("'")) {
            JOptionPane.showMessageDialog(null, "The information provided contains invalid characters. (')");
            return;
        }


        user.setFullName(fullName);
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);

        portal.addUser(user);
        JOptionPane.showMessageDialog(null, "Thank You For Signing up with STYLE CYCLE, Please Log In");
        setVisible(false);
        LogInForm logIn = new LogInForm(home);
        logIn.setVisible(true);

   
    }

}