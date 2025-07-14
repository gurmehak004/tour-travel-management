package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfno,tfcon,tfadd,tfem,tfphn;
    JRadioButton male,female;
    JButton adds,back;
    
    
    AddCustomer(String username) {
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        comboid=new JComboBox(new String[] {"Passport","Aadhar Card","Pan Card","Ration Card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lblno=new JLabel("Number");
        lblno.setBounds(30,130,150,25);
        add(lblno);
        
        tfno=new JTextField();
        tfno.setBounds(220,130,150,25);
        add(tfno);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        labelname=new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        male=new JRadioButton("Male");
        male.setBounds(220,210,70,25);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(300,210,70,25);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
         JLabel lblcon=new JLabel("Country");
        lblcon.setBounds(30,250,150,25);
        add(lblcon);
        
        tfcon=new JTextField();
        tfcon.setBounds(220,250,150,25);
        add(tfcon);
        
         JLabel lbladd=new JLabel("Address");
        lbladd.setBounds(30,290,150,25);
        add(lbladd);
        
        tfadd=new JTextField();
        tfadd.setBounds(220,290,150,25);
        add(tfadd);
        
         JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(30,330,150,25);
        add(lblemail);
        
        tfem=new JTextField();
        tfem.setBounds(220,330,150,25);
        add(tfem);
        
         JLabel lblphn=new JLabel("Phone");
        lblphn.setBounds(30,370,150,25);
        add(lblphn);
        
        tfphn=new JTextField();
        tfphn.setBounds(220,370,150,25);
        add(tfphn);
        
        adds=new JButton("Add");
        adds.setBackground(Color.BLACK);
        adds.setForeground(Color.WHITE);
        adds.setBounds(70,430,100,25);
        adds.addActionListener(this);
        add(adds);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,430,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/troly.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,40,400,500);
        add(image);
        
        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from account where username='" +username+"'");
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        } catch(Exception e ) {
            e.printStackTrace();
        }
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==adds) {
            String username=labelusername.getText();
            String id=comboid.getSelectedItem().toString();
            String number=tfno.getText();
            String name=labelname.getText();
            String gender=null;
            if(male.isSelected()) {
                gender="Male";
            }
            else {
                gender="Female";
            }
            String country=tfcon.getText();
            String address=tfadd.getText();
            String email=tfem.getText();
            String phone=tfphn.getText();
            
            try {
                Conn c=new Conn();
                String query="Insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+email+"','"+phone+"') ";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
                    
            
        } else {
            setVisible(false);
        }
        
    }
    public static void main(String[] args) {
        new AddCustomer("gurmehak");
    }
}
