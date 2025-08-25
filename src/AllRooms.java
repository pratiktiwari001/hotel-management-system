
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.*;

public class AllRooms extends JFrame implements ActionListener{
    JTable table;
    JButton back ;
    AllRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(310, 190, 1300, 700);


        JLabel text = new JLabel("ROOM DETAILS");
        text.setBounds(200,0,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(text);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600,0,700,700);
        add(image);

        JLabel column1 = new JLabel("Room Number");
        column1.setBounds(20,40,110,20);
        add(column1);

        JLabel column2 = new JLabel("Availability");
        column2.setBounds(150,40,90,20);
        add(column2);

        JLabel column3 = new JLabel("Cleaning Status");
        column3.setBounds(260,40,130,20);
        add(column3);

        JLabel column4 = new JLabel("Price");
        column4.setBounds(400,40,100,20);
        add(column4);

        JLabel column5 = new JLabel("Bed-Type");
        column5.setBounds(510,40,100,20);
        add(column5);


        table = new JTable();
        table.setBounds(10,70,590,500);
        add(table);


        try {
            Conn conn = new Conn();
            String query = "select * from room;";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,600,120,30);
        back.addActionListener(this);
        add(back);

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Reception();
    }
    

    
}
