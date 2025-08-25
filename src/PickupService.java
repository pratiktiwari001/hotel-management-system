
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.*;

public class PickupService extends JFrame implements ActionListener{
    JTable table;
    JButton back, applyFilter;
    Choice carType, location;
    JCheckBox available;
    ResultSet rs;
    PickupService(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(460, 165, 1000, 750);


        JLabel text = new JLabel("Pickup Service");
        text.setBounds(400,30,200,30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);


        JLabel lblCar = new JLabel("Type of Car");
        lblCar.setBounds(100,100,100,20);
        lblCar.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblCar);

        carType = new Choice();
        carType.setBounds(200,100,200,25);
        add(carType);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT DISTINCT Car_model FROM driver;");
            while(rs.next()){
                carType.add(rs.getString("Car_model"));
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel lblLocation = new JLabel("Location");
        lblLocation.setBounds(600,100,100,20);
        lblLocation.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblLocation);

        location = new Choice();
        location.setBounds(700,100,200,25);
        add(location);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT DISTINCT Location FROM driver;");
            while(rs.next()){
                location.add(rs.getString("Location"));
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel column1 = new JLabel("Name");
        column1.setBounds(40,150,100,20);
        add(column1);

        JLabel column2 = new JLabel("Age");
        column2.setBounds(180,150,100,20);
        add(column2);

        JLabel column3 = new JLabel("Gender");
        column3.setBounds(320,150,100,20);
        add(column3);

        JLabel column4 = new JLabel("Car Company");
        column4.setBounds(460,150,120,20);
        add(column4);

        JLabel column5 = new JLabel("Car Model");
        column5.setBounds(600,150,100,20);
        add(column5);

        JLabel column6 = new JLabel("Availability");
        column6.setBounds(760,150,100,20);
        add(column6);

        JLabel column7 = new JLabel("Location");
        column7.setBounds(880,150,100,20);
        add(column7);


        table = new JTable();
        table.setBounds(10,180,980,450);
        add(table);


        try {
            Conn conn = new Conn();
            String query = "select * from driver;";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        applyFilter = new JButton("Apply Filter");
        applyFilter.setBackground(Color.BLACK);
        applyFilter.setForeground(Color.WHITE);
        applyFilter.setBounds(190,650,120,30);
        applyFilter.addActionListener(this);
        add(applyFilter);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(690,650,120,30);
        back.addActionListener(this);
        add(back);


        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == applyFilter){
                try {
                    String car =(String) carType.getSelectedItem();
                    String Location =(String) location.getSelectedItem();
                    String query1 = "select * from driver where Car_model ='" + car + "' AND Location = '"+Location+"';";
                    
                    // String query2 = "select * from room where availability = 'available' and bedType = '" + bedType + "';";

                    Conn conn = new Conn();
                    ResultSet rs;

                    // if(available.isSelected()){
                    //     rs = conn.s.executeQuery(query2);
                    // } else{
                        rs = conn.s.executeQuery(query1);
                    // }
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            else if(ae.getSource() == back){
                setVisible(false);
                new Reception();
            }

    }
    

    
}

