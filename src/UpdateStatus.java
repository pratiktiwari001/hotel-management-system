
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateStatus extends JFrame implements ActionListener {
    Choice cCustomer;
    JTextField tfRoom, tfName, tfTime, tfDeposit, tfPending;
    JButton check, update, back;
    UpdateStatus(){
        setBounds(460,290,1000,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,30));
        text.setBounds(150,30,200,30);
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


        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50,180,150,30);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200,180,150,30);
        add(tfName);


        JLabel lbTime = new JLabel("CheckIn Time");
        lbTime.setBounds(50,230,150,30);
        add(lbTime);

        tfTime = new JTextField();
        tfTime.setBounds(200,230,150,30);
        add(tfTime);


        JLabel lblDeposit = new JLabel("Deposited Amount");
        lblDeposit.setBounds(50,280,150,30);
        add(lblDeposit);

        tfDeposit = new JTextField();
        tfDeposit.setBounds(200,280,150,30);
        add(tfDeposit);


        JLabel lblPending = new JLabel("Pending Amount");
        lblPending.setBounds(50,330,150,30);
        add(lblPending);

        tfPending = new JTextField();
        tfPending.setBounds(200,330,150,30);
        add(tfPending);


        check = new JButton("Check");
        check.setBounds(40, 400,100,30);
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        
        update = new JButton("Update");
        update.setBounds(200, 400,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        
        back = new JButton("Back");
        back.setBounds(360, 400,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updateStatus.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520, 20, 400, 400);
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
                    tfName.setText(rs.getString("name"));
                    tfTime.setText(rs.getString("CheckIn_Time"));
                    tfDeposit.setText(rs.getString("Deposit_Amount"));
                }

                ResultSet rs2 = conn.s.executeQuery("select * from room where roomNumber = '"+tfRoom.getText()+"';");
                while(rs2.next()){
                    int price = Integer.parseInt(rs2.getString("price"));
                    int deposit = Integer.parseInt( tfDeposit.getText());
                    tfPending.setText(Integer.toString(price-deposit));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==update){
            String id = cCustomer.getSelectedItem();
            String room = tfRoom.getText();
            String name = tfName.getText();
            String time = tfTime.getText();
            String deposit = tfDeposit.getText();

            try {
                Conn conn = new Conn();
                String query = "Update customer set Room_Number = '"+room+"',Name = '"+name+"',CheckIn_Time = '"+time+"',Deposit_Amount = '"+deposit+"' where ID_Number = '"+id+"';";
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
