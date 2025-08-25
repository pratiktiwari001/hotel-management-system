
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Checkout extends JFrame implements ActionListener{
    Choice cCustomer;
    JLabel lblRoomNumber, lblCheckInTime, lblCheckOutTime, lblPendingAmt, lblPaidAmt;
    JButton checkout, back, check;
    int deposit;

    public Checkout() {
        setBounds(460,290,1000,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("CHECKOUT WINDOW");
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        text.setBounds(350,20,300,30);
        add(text);

        JLabel lblId = new JLabel("Customer ID");
        lblId.setBounds(30,80,150,30);
        add(lblId);

        cCustomer = new Choice();
        cCustomer.setBounds(200,80,150,30);
        add(cCustomer);



        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(30,120,150,30);
        add(lblRoom);

        lblRoomNumber = new JLabel();
        lblRoomNumber.setBounds(200,120,150,30);
        add(lblRoomNumber);


        JLabel lblPaid = new JLabel("Amount Paid");
        lblPaid.setBounds(30,160,150,30);
        add(lblPaid);

        lblPaidAmt = new JLabel();
        lblPaidAmt.setBounds(200,160,200,30);
        add(lblPaidAmt);


        JLabel lblPending = new JLabel("Pending Amount");
        lblPending.setBounds(30,200,150,30);
        add(lblPending);

        lblPendingAmt = new JLabel();
        lblPendingAmt.setBounds(200,200,200,30);
        add(lblPendingAmt);


        JLabel lblCheckIn = new JLabel("Checkin Time");
        lblCheckIn.setBounds(30,240,150,30);
        add(lblCheckIn);

        lblCheckInTime = new JLabel();
        lblCheckInTime.setBounds(200,240,200,30);
        add(lblCheckInTime);


        JLabel lblCheckOut = new JLabel("Checkout Time");
        lblCheckOut.setBounds(30,280,150,30);
        add(lblCheckOut);

        Date date = new Date();
        lblCheckOutTime = new JLabel(""+date);
        lblCheckOutTime.setBounds(200,280,200,30);
        add(lblCheckOutTime);


        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer;");
            while(rs.next()){
                cCustomer.add(rs.getString("ID_Number"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 80, 400, 350);
        add(image);


        check = new JButton("Get Details");
        check.setBounds(50,380,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(200,380,100,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBounds(350,380,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            try {
                Conn conn = new Conn();
                ResultSet rs2 = conn.s.executeQuery("select * from customer where ID_Number = '"+cCustomer.getSelectedItem()+"';");
                while(rs2.next()){
                lblRoomNumber.setText(rs2.getString("Room_Number"));
                lblCheckInTime.setText(rs2.getString("CheckIn_Time"));
                deposit = Integer.parseInt(rs2.getString("Deposit_Amount"));
            }
            ResultSet rs3 = conn.s.executeQuery("select * from room where roomNumber = '"+lblRoomNumber.getText()+"';");
                while(rs3.next()){
                    int price = Integer.parseInt(rs3.getString("price"));
                    lblPaidAmt.setText("Rs. "+Integer.toString(deposit));
                    lblPendingAmt.setText("Rs. "+Integer.toString(price-deposit));
                }     
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==checkout){
            String query1 = "delete from customer where ID_Number = '"+cCustomer.getSelectedItem()+"';";
            String query2 = "update room set availability = 'Available' where roomNumber = '"+lblRoomNumber.getText()+"';";
            try {
                Conn conn = new Conn();
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null, "Checkout Successful");
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
