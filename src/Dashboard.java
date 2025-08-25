
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    JMenuItem addEmployee, addRoom, addDriver, reception;

    Dashboard(){
        setBounds(0,0,1920,1080);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1920, 1080);
        add(image);


        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(620, 80, 1000, 50);
        text.setForeground(Color.white);
        text.setFont(new Font("Tahoma", Font.PLAIN, 50));
        image.add(text);


        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1920, 30);
        image.add(mb);


        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);


        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        addRoom = new JMenuItem("ADD ROOMS");
        addRoom.addActionListener(this);
        admin.add(addRoom);

        addDriver = new JMenuItem("ADD DRIVERS");
        addDriver.addActionListener(this);
        admin.add(addDriver);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addEmployee){
            new AddEmployee();
        } else if (ae.getSource() == addRoom){
            new AddRooms();
        } else if (ae.getSource() == addDriver){
            new AddDrivers();
        } else if (ae.getSource() == reception){
            new Reception();
        }

    }

    
}
