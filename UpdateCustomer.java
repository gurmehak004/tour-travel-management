package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfno, tfcon, tfadd, tfem, tfphn, tfid, tfgen;
    JRadioButton male, female;
    JButton adds, back;

    UpdateCustomer(String username) {
        setBounds(500, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);

        JLabel lblno = new JLabel("Number");
        lblno.setBounds(30, 130, 150, 25);
        add(lblno);

        tfno = new JTextField();
        tfno.setBounds(220, 130, 150, 25);
        add(tfno);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        tfgen = new JTextField();
        tfgen.setBounds(220, 210, 150, 25);
        add(tfgen);

        JLabel lblcon = new JLabel("Country");
        lblcon.setBounds(30, 250, 150, 25);
        add(lblcon);

        tfcon = new JTextField();
        tfcon.setBounds(220, 250, 150, 25);
        add(tfcon);

        JLabel lbladd = new JLabel("Address");
        lbladd.setBounds(30, 290, 150, 25);
        add(lbladd);

        tfadd = new JTextField();
        tfadd.setBounds(220, 290, 150, 25);
        add(tfadd);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 330, 150, 25);
        add(lblemail);

        tfem = new JTextField();
        tfem.setBounds(220, 330, 150, 25);
        add(tfem);

        JLabel lblphn = new JLabel("Phone");
        lblphn.setBounds(30, 370, 150, 25);
        add(lblphn);

        tfphn = new JTextField();
        tfphn.setBounds(220, 370, 150, 25);
        add(tfphn);

        adds = new JButton("Update");
        adds.setBackground(Color.BLACK);
        adds.setForeground(Color.WHITE);
        adds.setBounds(70, 430, 100, 25);
        adds.addActionListener(this);
        add(adds);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 100, 450, 300);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username='" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfno.setText(rs.getString("number"));
                tfgen.setText(rs.getString("gender"));
                tfcon.setText(rs.getString("country"));
                tfphn.setText(rs.getString("phone"));
                tfem.setText(rs.getString("email"));
                tfadd.setText(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == adds) {
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfno.getText();
            String name = labelname.getText();
            String gender = tfgen.getText();
            String country = tfcon.getText();
            String address = tfadd.getText();
            String email = tfem.getText();
            String phone = tfphn.getText();

            try {
                Conn c = new Conn();
                String query = "update customer set username='" + username + "',id='" + id + "',number='" + number + "',name='" + name + "',gender='" + gender + "',country='" + country + "',address='" + address + "',email='" + email + "',phone='" + phone + "' ";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateCustomer("gurmehak");
    }
}
