
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboId;
    JTextField tfNumber, tfName, tfCountry, tfDeposit;
    JRadioButton rmale,rfemale;
    Choice cRoom;
    JLabel checkInTime;
    JButton add,back;

    AddCustomer() {
        setBounds(350,200,900,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Railway",Font.PLAIN,25));
        add(text);

        JLabel lblId = new JLabel("ID Proof");
        lblId.setBounds(35,80,140,30);
        lblId.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblId);

        String optionsId[]= {"Aadhar Card", "PAN Card", "Voter ID", "Passport", "Driving License"};
        comboId = new JComboBox<>(optionsId);
        comboId.setBounds(200,80,150,30);
        comboId.setBackground(Color.WHITE);
        add(comboId);


        JLabel lblNumber = new JLabel("ID Number");
        lblNumber.setBounds(35,130,140,30);
        lblNumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(200,130,150,30);
        add(tfNumber);


        JLabel lblName = new JLabel("Name");
        lblName.setBounds(35,180,140,30);
        lblName.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblName);

         tfName = new JTextField();
        tfName.setBounds(200,180,150,30);
        add(tfName);


        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(35,230,140,30);
        lblGender.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblGender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(200,230,60,30);
        rmale.setFont(new Font("Tahoma",Font.PLAIN,15));
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(270,230,80,30);
        rfemale.setFont(new Font("Tahoma",Font.PLAIN,15));
        rfemale.setBackground(Color.WHITE);
        add(rfemale);


        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(35,280,140,30);
        lblCountry.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(200,280,150,30);
        add(tfCountry);


        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(35,330,140,30);
        lblRoom.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblRoom);

        cRoom = new Choice();
        try {
           Conn conn = new Conn();
           String query = "select * from room where availability = 'Available';";
           ResultSet rs = conn.s.executeQuery(query);
           while(rs.next()){
            cRoom.add(rs.getString("roomNumber"));
           }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        cRoom.setBounds(200,330,150,30);
        add(cRoom);


        JLabel lblTime = new JLabel("CheckIn Time");
        lblTime.setBounds(35,380,140,30);
        lblTime.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblTime);

        java.util.Date date = new java.util.Date();

        checkInTime = new JLabel(""+ date);
        checkInTime.setBounds(200,380,200,30);
        checkInTime.setFont(new Font("Tahoma",Font.PLAIN,13));
        add(checkInTime);


        JLabel lblDeposit = new JLabel("Deposit");
        lblDeposit.setBounds(35,430,140,30);
        lblDeposit.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblDeposit);

        tfDeposit = new JTextField();
        tfDeposit.setBounds(200,430,150,30);
        add(tfDeposit);


        add = new JButton("Add");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(50,500,150,35);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(240,500,150,35);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,80,400,400);
        add(image);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id = (String) comboId.getSelectedItem();
            String number = tfNumber.getText();
            String name = tfName.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            }else if(rfemale.isSelected()){
                gender = "Female";
            }

            String country = tfCountry.getText();
            String room = cRoom.getSelectedItem();
            String time = checkInTime.getText();
            String deposit = tfDeposit.getText();

            try {
                String queryAddCustomer = "insert into customer values ('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"');";


                String queryUpdateRoom = "Update room set availability = 'Occupied' where roomNumber = '"+room+"';";

                Conn conn = new Conn();
                conn.s.executeUpdate(queryAddCustomer);
                conn.s.executeUpdate(queryUpdateRoom);

                JOptionPane.showMessageDialog(null, "Customer Added Successfully");

                setVisible(false);
                new Reception();
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }


    
}
