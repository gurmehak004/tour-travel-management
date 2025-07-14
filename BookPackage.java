
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JLabel labelusername,labelid,labelno,labelph,labelprice;
    JButton checkprice,bookpackage,back;
    JTextField tfperson;
    String username;
    BookPackage(String username) {
        this.username=username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblusername);
        
        labelusername=new JLabel();
        labelusername.setBounds(250,70,200,20);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labelusername);
        
        JLabel lblpackage=new JLabel("Select Package");
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblpackage);
        
        cpackage=new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);
        
        JLabel lblpersons=new JLabel("Total Persons");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblpersons);
        
        tfperson=new JTextField("1");
        tfperson.setBounds(250,150,200,25);
        add(tfperson);
        
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(40,190,150,25);
        lblid.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblid);
        
        labelid=new JLabel();
        labelid.setBounds(250,190,150,25);
        labelid.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labelid);
        
        JLabel lblno=new JLabel("Number");
        lblno.setBounds(40,230,150,25);
        lblno.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblno);
        
        labelno=new JLabel();
        labelno.setBounds(250,230,150,25);
        add(labelno);
        
        JLabel lblph=new JLabel("Phone");
        lblph.setBounds(40,270,150,20);
        lblph.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblph);
        
        labelph=new JLabel();
        labelph.setBounds(250,270,200,25);
        labelph.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labelph);
        
        JLabel lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setBounds(250,310,150,25);
        add(labelprice);
        
         try {
            Conn conn=new Conn();
            String query="select * from customer where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelno.setText(rs.getString("number"));
                labelph.setText(rs.getString("phone"));
        
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        checkprice=new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);  
        
        bookpackage= new JButton("Book Package");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage); 
        
        back= new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l12=new JLabel(i3);
        l12.setBounds(550,50,500,300);
        add(l12);
        
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==checkprice) {
            String pack=cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package")) {
            cost+=12000;
        } else if(pack.equals("Silver Package")) {
            cost+=24000;
        } else {
            cost+=32000;
        }
         int persons=  Integer.parseInt(tfperson.getText());
         cost*=persons;
         labelprice.setText("Rs"+cost);
        } else if(ae.getSource()==bookpackage) {
            try {
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelno.getText()+"','"+labelph.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new BookPackage("gurmehak");
    }
}
