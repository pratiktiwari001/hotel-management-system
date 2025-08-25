
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

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back, applyFilter;
    JComboBox<Object> bedCombo;
    JCheckBox available;
    ResultSet rs;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(460, 165, 1000, 750);


        JLabel text = new JLabel("Search for Room");
        text.setBounds(400,30,200,30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);


        JLabel lblBed = new JLabel("Bed Type");
        lblBed.setBounds(50,100,100,20);
        lblBed.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblBed);

        bedCombo = new JComboBox<>(new String[]{"Single-Bed","Double-Bed"});
        bedCombo.setBounds(170,100,150,25);
        bedCombo.setBackground(Color.WHITE);
        add(bedCombo);


        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,200,25);
        available.setBackground(Color.WHITE);
        available.setFont(new Font("Tahoma", Font.BOLD, 15));
        available.addActionListener(this);
        add(available);


        JLabel column1 = new JLabel("Room Number");
        column1.setBounds(40,150,150,20);
        add(column1);

        JLabel column2 = new JLabel("Availability");
        column2.setBounds(250,150,120,20);
        add(column2);

        JLabel column3 = new JLabel("Cleaning Status");
        column3.setBounds(430,150,130,20);
        add(column3);

        JLabel column4 = new JLabel("Price");
        column4.setBounds(630,150,130,20);
        add(column4);

        JLabel column5 = new JLabel("Bed-Type");
        column5.setBounds(850,150,100,20);
        add(column5);


        table = new JTable();
        table.setBounds(10,180,980,450);
        add(table);


        try {
            Conn conn = new Conn();
            String query = "select * from room;";
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
                    String bedType =(String) bedCombo.getSelectedItem();
                    String query1 = "select * from room where bedType ='" + bedType + "';";
                    
                    String query2 = "select * from room where availability = 'available' and bedType = '" + bedType + "';";

                    Conn conn = new Conn();
                    ResultSet rs;

                    if(available.isSelected()){
                        rs = conn.s.executeQuery(query2);
                    } else{
                        rs = conn.s.executeQuery(query1);
                    }
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
