import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Shows important information and educates the consumer about fast fashion 
 * and the effects of not responsibly consuming textiles and their impact 
 * on the environment
 *
 * @author Kiran Goli
 * @version 1.0
 */
public class LearnMorePage extends JFrame
{
    /* CREDITS
     * javatpoint.com/java-jscrollpane
     * javatpoint.com/java-jpanel 
     */
    
    
    
    User user;
    Homepage home;
    String state;
    /**
     * Loading the navigation bar.
     * just for the top part its copy and paste
     * 
     * @author Lakshmanan Ramanathan 
     */
    private JPanel navigatorBarBoot(User user) {

        JPanel navBar = new JPanel(); // javatpoint.com/java-jpanel 
        navBar.setBackground(Color.LIGHT_GRAY);
        navBar.setLayout(new BoxLayout(navBar, BoxLayout.X_AXIS));

        JLabel name = new JLabel("StyleCycle"); // https://www.javatpoint.com/java-jlabel
        name.setFont(new Font("Arial", Font.BOLD, 24));
        name.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // Learn More Button to navigate the user to the learn more page
        JButton learnMoreButton = new JButton("Learn More");

        learnMoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // Method to handle action events on Button press
                LearnMorePage learnMorePage = new LearnMorePage("Boot", home, null); // Debugged this into chatgpt as I accidentally  passed a .this reference
                learnMorePage.setVisible(true);
                setVisible(false); // Hiding this page
            }
        });

        learnMoreButton.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        learnMoreButton.setBackground(Color.YELLOW);

        // Home Button to indicate what page the user is on
        JButton homeButton = new JButton(" Home ");
        //TODO Function DONE
        homeButton.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        homeButton.setBackground(Color.WHITE);


        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Homepage home = null;
                if(!(user == null)){
                    home = new Homepage(user);
                } else {
                    home = new Homepage("Boot");
                }
                home.setVisible(true);
                setVisible(false);
            }
        });

        navBar.add(name);
        navBar.add(learnMoreButton);
        navBar.add(Box.createHorizontalGlue());        
        navBar.add(homeButton);
        navBar.add(Box.createHorizontalStrut(20));
        navBar.add(Box.createHorizontalStrut(20));

        navBar.add(Box.createHorizontalStrut(20));
        return navBar;

    }
    
    /**
     * Constructor for Learn More Page.
     * 
     * @author Kiran Goli
     */
    public LearnMorePage(String state, Homepage home, User user)
    {
        super("Learn about us and healthy consumption");
        this.state = state;
        this.home = home;
        this.user = user;
        
        
        Toolkit tk = Toolkit.getDefaultToolkit(); 
        
        
        
        setSize(1500,990); // Sets frame size as current screen size
        
        JLabel learnPageTitle = new JLabel("About Us and Our Goal"); 
        JLabel learnPageInformation = new JLabel("<html>Our goal is to encourage healthy and environmentally friendly consuming habits<br>Fast fashion is an industry that rapidly produces and wastes substantial amounts of <br>materials due to their goal to stay on track with the latest developments Consequently, <br> most of these materials are not properly recycled or simply dumped into landfills<br><br><br>We offer a marketplace that seeks to enable sellers to resell their used clothes online<br>This does not only provide another use for old garments, but it also reduces the amount<br>of clothing material that could potentially end up in landfills. This is an important step for <br> combatting increasing clothing waste, along with indirectly reducing the impact fast fashion<br>has on the environment, by providing an alternative website for reselling.<br><br><br>Giving consumers the opportunity to donate any old clothing encourages them to learn about<br>the effects of fast fashion on the environment. With better knowledge, healthy consuming <br>habits can be made based on the environmental ethics of clothing. This is what we aim to<br>achieve, which has led us to building this website as a first step to solving the problem. <br><br><br>Sustainable Development Goal 12 (SDG 12) focuses on ensuring sustainable consumption and <br> production patterns. This goal emphasizes the importance of reducing waste, minimizing the <br>environmental impact of production, and promoting more efficient use of resources. By <br>encouraging industries, governments, and individuals to adopt practices that conserve resources,<br>reduce emissions, and minimize pollution, SDG 12 aims to create a more sustainable <br>economy. Key targets include improving resource efficiency, reducing food waste, promoting <br>sustainable business practices, and enhancing public awareness about the environmental impact of <br>consumption. Achieving SDG 12 is crucial for safeguarding the planet’s resources for future<br>generations while fostering a green, circular economy.");
        JLabel learnPageImage = new JLabel("\uD83D\uDC55"); // Icon displayed
        
        learnPageTitle.setFont(new Font("Arial",Font.PLAIN,70));
        learnPageTitle.setBounds(10,150,1300,70);

        learnPageInformation.setFont(new Font("Arial",Font.PLAIN,15));
        learnPageInformation.setBounds(10,0,0,0);
        
        learnPageImage.setFont(new Font("Dialog",Font.PLAIN,333));
        learnPageImage.setBounds(1000,330,1300,333);
        
        JPanel navBar = navigatorBarBoot(this.user);
        add(navBar, BorderLayout.NORTH);
        
        add(learnPageImage);
        add(learnPageTitle);
        add(learnPageInformation);
        
        
        setVisible(true); 
        
        
        
    }
    
    /**
     * Load manually at times for testing.
     * 
     * @author Kiran Goli
     */
    public static void main(String[] args) {
        LearnMorePage learnPage = new LearnMorePage(null, null, null);
    }
    
}
    
