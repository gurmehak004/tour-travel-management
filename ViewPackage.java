
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {
    JButton back;
        ViewPackage(String username) {
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("View Package Details");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid=new JLabel("Package");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        JLabel labelpackage=new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);
        
        JLabel lblno=new JLabel("Total Persons");
        lblno.setBounds(30,130,150,25);
        add(lblno);
        
        JLabel labelpersons=new JLabel();
        labelpersons.setBounds(220,130,150,25);
        add(labelpersons);
        
        JLabel lblname=new JLabel("Id");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        JLabel labelid=new JLabel();
        labelid.setBounds(220,170,150,25);
        add(labelid);
        
        JLabel lblgender=new JLabel("Number");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        JLabel labelno=new JLabel();
        labelno.setBounds(220,210,150,25);
        add(labelno);
        
        JLabel lblcountry=new JLabel("Phone");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
        JLabel labelphone=new JLabel();
        labelphone.setBounds(220,250,150,25);
        add(labelphone);
        
        JLabel lbltotal=new JLabel("Price");
        lbltotal.setBounds(30,290,150,25);
        add(lbltotal);
        
        JLabel labelprice=new JLabel();
        labelprice.setBounds(220,290,150,25);
        add(labelprice);
        
        
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,360,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);
        

        
        try {
            Conn conn=new Conn();
            String query="select * from bookpackage where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("package"));
                labelpersons.setText(rs.getString("persons"));
                labelid.setText(rs.getString("id"));
                labelno.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
               
            }
            
        } catch(Exception e) {
            
        }
        setVisible(true);

        
    }
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);

}
    public static void main(String[] args) {
        new ViewPackage("gurmehak");
    }
}
