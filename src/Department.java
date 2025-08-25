
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

public class Department extends JFrame implements ActionListener{
    JTable table;
    JButton back ;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(460, 240, 1000, 600);


        JLabel text = new JLabel("DEPARTMENTS");
        text.setBounds(200,0,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(text);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/department.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,500,600);
        add(image);

        JLabel column1 = new JLabel("Department");
        column1.setBounds(40,40,180,20);
        add(column1);

        JLabel column2 = new JLabel("Budget");
        column2.setBounds(220,40,300,20);
        add(column2);

        JLabel column3 = new JLabel("Number of Members");
        column3.setBounds(365,40,350,20);
        add(column3);


        table = new JTable();
        table.setBounds(10,70,500,400);
        add(table);


        try {
            Conn conn = new Conn();
            String query = "select * from department;";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        add(back);

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Reception();
    }
    

    
}