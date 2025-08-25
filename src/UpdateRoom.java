
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice cCustomer;
    JTextField tfRoom, tfAvailable, tfClean, tfPending;
    JButton check, update, back;
    UpdateRoom(){
        setBounds(460,340,900,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,30));
        text.setBounds(100,30,300,30);
        text.setForeground(Color.BLUE);
        add(text);


        JLabel lblId = new JLabel("Customer ID");
        lblId.setBounds(50,80,150,30);
        add(lblId);

        cCustomer = new Choice();
        cCustomer.setBounds(200,80,150,30);
        add(cCustomer);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from customer;");
            while(rs.next()){
                cCustomer.add(rs.getString("ID_Number"));
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(50,130,150,30);
        add(lblRoom);

        tfRoom = new JTextField();
        tfRoom.setBounds(200,130,150,30);
        add(tfRoom);


        JLabel lblAvailable = new JLabel("Availability");
        lblAvailable.setBounds(50,180,150,30);
        add(lblAvailable);

        tfAvailable = new JTextField();
        tfAvailable.setBounds(200,180,150,30);
        add(tfAvailable);


        JLabel lbClean = new JLabel("Cleaning Status");
        lbClean.setBounds(50,230,150,30);
        add(lbClean);

        tfClean = new JTextField();
        tfClean.setBounds(200,230,150,30);
        add(tfClean);



        check = new JButton("Check");
        check.setBounds(150, 300,100,30);
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        
        update = new JButton("Update");
        update.setBounds(400, 300,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        
        back = new JButton("Back");
        back.setBounds(650, 300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 450, 250);
        add(image);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id = cCustomer.getSelectedItem();
            String query = "select * from customer where ID_Number = '"+id+"';";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while(rs.next()){
                    tfRoom.setText(rs.getString("Room_Number"));
                    // tfAvailable.setText(rs.getString("availability"));
                    // tfClean.setText(rs.getString("cleaningStatus"));
                }

                ResultSet rs2 = conn.s.executeQuery("select * from room where roomNumber = '"+tfRoom.getText()+"';");
                while(rs2.next()){
                    tfAvailable.setText(rs2.getString("availability"));
                    tfClean.setText(rs2.getString("cleaningStatus"));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==update){
            String id = cCustomer.getSelectedItem();
            String room = tfRoom.getText();
            String available = tfAvailable.getText();
            String status = tfClean.getText();

            try {
                Conn conn = new Conn();
                String query = "Update room set availability = '"+available+"',cleaningStatus = '"+status+"' where roomNumber = '"+room+"';";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }

    }

    

}
    
