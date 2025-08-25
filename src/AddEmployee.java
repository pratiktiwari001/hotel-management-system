
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField tfName, tfEmail, tfPhone, tfAge, tfSalary, tfAdhar;
    JRadioButton rbMale, rbFemale;
    JButton submit;
    JComboBox cbJob;
    AddEmployee(){
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        setBounds(535, 200, 850, 650);


        JLabel text = new JLabel("ADD EMPLOYEE");
        text.setBounds(275,10,300,30);
        text.setFont(new Font("Railway",Font.BOLD,25));
        add(text);

        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(60, 70, 150, 40);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblName);

         tfName = new JTextField();
        tfName.setBounds(200, 70, 200, 40);
        add(tfName);


        JLabel lblAge = new JLabel("AGE");
        lblAge.setBounds(60, 130, 150, 40);
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblAge);

         tfAge = new JTextField();
        tfAge.setBounds(200, 130, 200, 40);
        add(tfAge);


        JLabel lblGender = new JLabel("GENDER");
        lblGender.setBounds(60, 190, 150, 40);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblGender);

         rbMale = new JRadioButton("Male");
        rbMale.setBounds(200,190,80,40);
        rbMale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbMale.setBackground(Color.WHITE);
        add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(280,190,80,40);
        rbFemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);


        JLabel lblJob = new JLabel("JOB");
        lblJob.setBounds(60, 250, 150, 40);
        lblJob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblJob);

        String str[] = {"Manager", "Front Desk Clerks", "Housekeeping", "Porters", "Kitchen Staff", "Room Service", "Chef","Waiter","Accountant", "Driver"}; 
         cbJob = new JComboBox(str);
        cbJob.setBounds(200,250,200,40);
        cbJob.setBackground(Color.WHITE);
        add(cbJob);


        JLabel lblSalary = new JLabel("SALARY");
        lblSalary.setBounds(60, 310, 150, 40);
        lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblSalary);

         tfSalary = new JTextField();
        tfSalary.setBounds(200, 310, 200, 40);
        add(tfSalary);


        JLabel lblPhone = new JLabel("PHONE");
        lblPhone.setBounds(60, 370, 150, 40);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblPhone);

         tfPhone = new JTextField();
        tfPhone.setBounds(200, 370, 200, 40);
        add(tfPhone);


        JLabel lblEmail = new JLabel("E-MAIL");
        lblEmail.setBounds(60, 430, 150, 40);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblEmail);

         tfEmail = new JTextField();
        tfEmail.setBounds(200, 430, 200, 40);
        add(tfEmail);


        JLabel lblAdhar = new JLabel("Aadhar Number");
        lblAdhar.setBounds(60, 490, 150, 40);
        lblAdhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblAdhar);

         tfAdhar = new JTextField();
        tfAdhar.setBounds(200, 490, 200, 40);
        add(tfAdhar);


         submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(350,560,150,30);
        submit.addActionListener(this);
        add(submit);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 120,450,380);
        add(image);



        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name = tfName.getText();
        String age = tfAge.getText();
        String salary = tfSalary.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        String adhar = tfAdhar.getText();

        String gender = null;
        if(rbMale.isSelected()){
            gender = "Male";
        }else if(rbFemale.isSelected()){
            gender = "Female";
        }

        String job = (String) cbJob.getSelectedItem();

        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return;
        }

        if(age.equals("")){
            JOptionPane.showMessageDialog(null, "Age should not be empty");
            return;
        }

        if(salary.equals("")){
            JOptionPane.showMessageDialog(null, "Salary should not be empty");
            return;
        }

        if(phone.equals("")){
            JOptionPane.showMessageDialog(null, "Phone Number should not be empty");
            return;
        }

        if (email.isEmpty() || !email.contains("@")) {
        JOptionPane.showMessageDialog(null, "E-mail should not be empty and must contain '@'");
        return;
        }


        if(adhar.equals("")){
            JOptionPane.showMessageDialog(null, "Aadhar Number should not be empty");
            return;
        }

        try {
           Conn conn = new Conn();
           String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+adhar+"')" ;

           conn.s.executeUpdate(query);

           JOptionPane.showMessageDialog(null, "Employee added Successfully");

           setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
