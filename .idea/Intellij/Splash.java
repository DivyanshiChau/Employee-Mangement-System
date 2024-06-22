package employee.management.system;


import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        setUndecorated(true);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front1.gif"));
        Image i2 = i1.getImage().getScaledInstance(1550,870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,870);


        add(image);
        setSize(1920,1080);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);


        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Splash();
    }
}
