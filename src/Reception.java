import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,rooms,department,allEmployee, customers, managerInfo, checkout, update, roomStatus, pickup, searchRoom, logout;
    Reception() {
        setBounds(510,190,900,700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(20,50,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(20,100,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Department");
        department.setBounds(20,150,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(20,200,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customer Info");
        customers.setBounds(20,250,200,30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(20,300,200,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(20,350,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        update = new JButton("Update Status");
        update.setBounds(20,400,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(20,450,200,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup = new JButton("Pickup Service");
        pickup.setBounds(20,500,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(20,550,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout = new JButton("Logout");
        logout.setBounds(20,600,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 580, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,50,600,580);
        add(image);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==rooms){
            setVisible(false);
            new AllRooms();
        }
        else if(ae.getSource()==department){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource()==allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }
        else if (ae.getSource()==customers) {
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource()==managerInfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource()==searchRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateStatus();
        }
        else if(ae.getSource()==roomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource()==pickup){
            setVisible(false);
            new PickupService();
        }
        else if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
    
    
}
