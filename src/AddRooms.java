
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfRoom, tfPrice;
    JComboBox availableCombo, cleanCombo, typeCombo;

        AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(410, 220, 1100, 600);


        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(180,20,200,30);
        add(heading);


        JLabel lblRoomno = new JLabel("Room Number");
        lblRoomno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblRoomno.setBounds(60,80,140,35);
        add(lblRoomno);

        tfRoom = new JTextField();
        tfRoom.setBounds(230,80,180,35);
        add(tfRoom);


        JLabel lblAvailable = new JLabel("Availability");
        lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAvailable.setBounds(60,140,140,35);
        add(lblAvailable);

        String availableOptions[] = {"Available","Occupied"};
        availableCombo = new JComboBox<>(availableOptions);
        availableCombo.setBounds(230,140,180,35);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);


        JLabel lblClean = new JLabel("Cleaning Status");
        lblClean.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblClean.setBounds(60,200,140,35);
        add(lblClean);

        String cleanOptions[] = {"Cleaned","Dirty"};
        cleanCombo = new JComboBox<>(cleanOptions);
        cleanCombo.setBounds(230,200,180,35);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);


        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPrice.setBounds(60,260,140,35);
        add(lblPrice);

        tfPrice = new JTextField();
        tfPrice.setBounds(230,260,180,35);
        add(tfPrice);


        JLabel lblType = new JLabel("Bed Type");
        lblType.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblType.setBounds(60,320,140,35);
        add(lblType);

        String typeOptions[] = {"Single-Bed","Double-Bed"};
        typeCombo = new JComboBox<>(typeOptions);
        typeCombo.setBounds(230,320,180,35);
        typeCombo.setBackground(Color.WHITE);
        add(typeCombo);


        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,450,150,35);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(240,450,150,35);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(500,50,550,400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add) {
            String roomNumber = tfRoom.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String status = (String) cleanCombo.getSelectedItem();
            String price = tfPrice.getText();
            String type = (String) typeCombo.getSelectedItem();


            try {
                Conn conn = new Conn();
                String str = "insert into room values('" + roomNumber + "', '" + availability+"','" + status + "', '" + price + "', '" + type + "');";

                conn.s.execute(str);
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

            
        } else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }

    
}
