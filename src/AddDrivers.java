
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDrivers extends JFrame implements ActionListener{
    JButton add,cancel;
    JTextField tfName, tfCompany, tfAge, tfModel, tfLocation;
    JComboBox  genderCombo, availableCombo;

        AddDrivers(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(360, 220, 1200, 650);


        JLabel heading = new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(180,20,200,30);
        add(heading);


        JLabel lblName = new JLabel("Full Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(60,80,140,35);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(230,80,180,35);
        add(tfName);


        JLabel lblAge = new JLabel("Age");
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAge.setBounds(60,140,140,35);
        add(lblAge);

        tfAge = new JTextField();
        tfAge.setBounds(230,140,180,35);
        add(tfAge);


        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblGender.setBounds(60,200,140,35);
        add(lblGender);

        String genderOptions[] = {"Male","Female","Others"};
        genderCombo = new JComboBox<>(genderOptions);
        genderCombo.setBounds(230,200,180,35);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);


        JLabel lblCompany = new JLabel("Car Company");
        lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCompany.setBounds(60,260,140,35);
        add(lblCompany);

        tfCompany = new JTextField();
        tfCompany.setBounds(230,260,180,35);
        add(tfCompany);


        JLabel lblModel = new JLabel("Car Model");
        lblModel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblModel.setBounds(60,320,140,35);
        add(lblModel);

        tfModel = new JTextField();
        tfModel.setBounds(230,320,180,35);
        add(tfModel);


        JLabel lblAvailable = new JLabel("Availability");
        lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAvailable.setBounds(60,380,140,35);
        add(lblAvailable);

        String availableOptions[] = {"Available","Busy"};
        availableCombo = new JComboBox<>(availableOptions);
        availableCombo.setBounds(230,380,180,35);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);


        JLabel lblLocation = new JLabel("Location");
        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLocation.setBounds(60,440,140,35);
        add(lblLocation);

        tfLocation = new JTextField();
        tfLocation.setBounds(230,440,180,35);
        add(tfLocation);


        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,525,150,35);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(240,525,150,35);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,600,400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add) {
            String name = tfName.getText();
            String age = tfAge.getText();
            String gender = (String) genderCombo.getSelectedItem();
            String company = tfCompany.getText();
            String model = tfModel.getText();
            String available = (String) availableCombo.getSelectedItem();
            String location = tfLocation.getText();


            try {
                Conn conn = new Conn();
                String str = "insert into driver values('" + name + "', '" + age+"','" + gender + "', '" + company + "', '" + model + "', '" + available + "', '" + location + "');";

                conn.s.execute(str);
                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

            
        } else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }


}
