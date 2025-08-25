
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

public class EmployeeInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back ;
    EmployeeInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(460, 240, 1000, 650);

        JLabel text = new JLabel("EMPLOYEE's Information");
        text.setBounds(325,0,350,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(text);


        JLabel column1 = new JLabel("Name");
        column1.setBounds(50,40,110,20);
        add(column1);

        JLabel column2 = new JLabel("Age");
        column2.setBounds(170,40,110,20);
        add(column2);

        JLabel column3 = new JLabel("Gender");
        column3.setBounds(300,40,100,20);
        add(column3);

        JLabel column4 = new JLabel("Job");
        column4.setBounds(420,40,100,20);
        add(column4);

        JLabel column5 = new JLabel("Salary");
        column5.setBounds(540,40,590,20);
        add(column5);

        JLabel column6 = new JLabel("Phone Number");
        column6.setBounds(640,40,120,20);
        add(column6);

        JLabel column7 = new JLabel("E-mail");
        column7.setBounds(780,40,80,20);
        add(column7);

        JLabel column8 = new JLabel("Aadhar Number");
        column8.setBounds(880,40,100,20);
        add(column8);


        table = new JTable();
        table.setBounds(10,70,980,450);
        add(table);


        try {
            Conn conn = new Conn();
            String query = "select * from employee;";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(440,550,120,30);
        back.addActionListener(this);
        add(back);

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Reception();
    }
    

    
}

