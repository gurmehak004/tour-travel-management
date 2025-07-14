package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel, cac, cfood;
    JLabel labelusername, labelid, labelno, labelph, labelprice;
    JButton checkprice, bookpackage, back;
    JTextField tfperson, tfdays;
    String username;

    BookHotel(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 200, 20);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40, 110, 150, 20);
        lblpackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet ra = c.s.executeQuery("select * from hotel");
            while (ra.next()) {
                chotel.add(ra.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40, 150, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpersons);

        tfperson = new JTextField("1");
        tfperson.setBounds(250, 150, 200, 25);
        add(tfperson);

        JLabel lbldays = new JLabel("No of Days");
        lbldays.setBounds(40, 190, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);

        JLabel lblac = new JLabel("AC/ Non-AC");
        lblac.setBounds(40, 230, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);

        JLabel lblfood = new JLabel("Food included");
        lblfood.setBounds(40, 270, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40, 310, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 310, 150, 25);
        labelid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelid);

        JLabel lblno = new JLabel("Number");
        lblno.setBounds(40, 350, 150, 25);
        lblno.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblno);

        labelno = new JLabel();
        labelno.setBounds(250, 350, 150, 25);
        add(labelno);

        JLabel lblph = new JLabel("Phone");
        lblph.setBounds(40, 390, 150, 20);
        lblph.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblph);

        labelph = new JLabel();
        labelph.setBounds(250, 390, 200, 25);
        labelph.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelph);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 430, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 150, 25);
        add(labelprice);

        try {
            Conn conn = new Conn();
            String query = "select * from customer where username='" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelno.setText(rs.getString("number"));
                labelph.setText(rs.getString("phone"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200, 490, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 400);
        add(l12);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {

                Conn c = new Conn();
                ResultSet rb = c.s.executeQuery("select * from  hotel where name='" + chotel.getSelectedItem() + "'");
                while (rb.next()) {
                    int cost = Integer.parseInt(rb.getString("costperperson"));
                    int food = Integer.parseInt(rb.getString("foodincluded"));
                    int ac = Integer.parseInt(rb.getString("acroom"));

                    int persons = Integer.parseInt(tfperson.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total = cost;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;

                        total *= persons * days;
                        labelprice.setText("Rs" + total);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number  ");
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                String query = "insert into bookhotel values('" + labelusername.getText() + "','" + chotel.getSelectedItem() + "','" + tfperson.getText() + "','" + tfdays.getText() + "','" + cac.getSelectedItem() + "','" + cfood.getSelectedItem() + "','" + labelid.getText() + "','" + labelno.getText() + "','" + labelph.getText() + "','" + labelprice.getText() + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Booking Failed", JOptionPane.ERROR_MESSAGE); //Added Error message
            } 
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("gurmehak");
    }
}

