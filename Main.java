
/**
 * Easily execute the application.
 * 
 * @author Bashar Zain
 * @version 1.0
 */
public class Main
{
    /**
     * Execute the main application.
     * 
     * @author Bashar Zain
     */
    public static void main(String[] args){
        Homepage home = new Homepage("Boot");
        home.setVisible(true);
    }
    
    /**
     * Execute test 1.
     * 
     * @author Bashar Zain
     */
    public static void executeTestOne(String[] args){
        Test test = new Test();
        test.main(new String[0]);
    }
    
    /**
     * Execute test 2.
     * 
     * @author Bashar Zain
     */
    public static void executeTestTwo(String[] args){
        Test2 test2 = new Test2();
        test2.main(new String[0]);
    }
}

/*

Documentation For Learning:
 > Lakshmanan Ramanathan
 
Using JButton: https://www.javatpoint.com/java-jbutton

Using the Grid Bag Layout: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

Using Border Layout: https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html

Using Flow Layout: https://docs.oracle.com/javase/tutorial/uiswing/layout/flow.html

Using Layout Managers: https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html

Using JLabel: https://www.javatpoint.com/java-jlabel

Using JTextFeild: https://www.javatpoint.com/java-jtextfield

Using JPasswordField: https://www.javatpoint.com/java-jpasswordfield

Using JOptionPane: https://www.javatpoint.com/java-joptionpane

Using JScrollBar: https://www.javatpoint.com/java-jscrollbar

Using JTextPane: https://www.javatpoint.com/java-jtextpane

Using DropDown Combo Box: https://www.javatpoint.com/java-jcombobox

Using JFrame: https://www.javatpoint.com/java-jframe

Using Java Scroll Pane: https://www.javatpoint.com/java-jscrollpane

https://www.youtube.com/watch?v=xk4_1vDrzzo This video helped me master the fundamentals
 
 */