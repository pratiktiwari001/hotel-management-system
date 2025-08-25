
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App extends JFrame implements ActionListener{
    App(){
        //Creating Frame
        // setSize(1366, 565);
        // setLocation(100, 100);
        setBounds(277, 257, 1366, 565); //(posFrom-X, posFrom-Y, width, height)
        setLayout(null); //it does not use any layout



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg")); // for accessing image
        Image i2 = i1.getImage().getScaledInstance(1366, 565, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1366, 565);
        add(image);


        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);


        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setForeground(Color.RED);
        next.setFont(new Font("serif", Font.PLAIN, 25));
        next.setBackground(Color.WHITE);
        next.addActionListener(this);
        image.add(next);


        setVisible(true);

        while(true){
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}
